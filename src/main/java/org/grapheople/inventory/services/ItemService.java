package org.grapheople.inventory.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grapheople.inventory.entities.item.Item;
import org.grapheople.inventory.entities.item.ItemProperty;
import org.grapheople.inventory.entities.item.ItemTag;
import org.grapheople.inventory.enums.ItemPropertyDataType;
import org.grapheople.inventory.enums.ItemPropertyType;
import org.grapheople.inventory.repositories.ItemRepository;
import org.grapheople.inventory.vo.request.CreateItemRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public Item getItem(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public Item createItem(Long userId, CreateItemRequest request) {
        Item item = new Item();
        item.setImageList(request.getImageList());
        item.setDescription(request.getDescription());
        item.setName(request.getName());
        item.setUserId(userId);
        item.setPropertyList(
                request.getPropertyList().stream().map(property -> {
                    ItemProperty itemProperty = new ItemProperty();
                    itemProperty.setItemPropertyType(property.getItemPropertyType());
                    itemProperty.setPropertyDataType(property.getPropertyDataType());
                    itemProperty.setName(property.getName());
                    itemProperty.setContent(property.getContent());
                    return itemProperty;
                }).toList());
        item.setTagList(
                request.getTagList().stream().map(tag -> {
                    ItemTag itemTag = new ItemTag();
                    itemTag.setName(tag.getName());
                    return itemTag;
                }).toList());

        if (request.getParentId() != null) {
            itemRepository.findById(request.getParentId()).ifPresent(parentItem -> item.setParentId(parentItem.getParentId()));
        }
        if (request.getComponentList() != null && !request.getComponentList().isEmpty()) {
            List<Item> componentList = itemRepository.findAllById(request.getComponentList());
            item.setComponentList(componentList);
        }
        return itemRepository.save(item);
    }
}

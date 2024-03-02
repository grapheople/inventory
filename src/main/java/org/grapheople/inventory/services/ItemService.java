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
        item.setDescription(request.getDescription());
        item.setName(request.getName());
        item.setUserId(userId);
        item.setPropertyList(
                request.getPropertyList().stream().map(property -> {
                    ItemProperty itemProperty = new ItemProperty();
                    itemProperty.setItemPropertyType(property.getItemPropertyType());
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

        Item componentItem = new Item();
        componentItem.setDescription("component item");
        componentItem.setName("component item");
        componentItem.setUserId(userId);
        componentItem.setPropertyList(
                List.of(new ItemProperty(ItemPropertyType.RECEIPT, ItemPropertyDataType.PLAIN_TEXT, "component property", "component content")));
        item.setComponentList(List.of(componentItem));
        return itemRepository.save(item);
    }
}

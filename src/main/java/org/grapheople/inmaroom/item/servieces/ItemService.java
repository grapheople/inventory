package org.grapheople.inmaroom.item.servieces;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grapheople.inmaroom.common.CommonException;
import org.grapheople.inmaroom.common.ErrorCode;
import org.grapheople.inmaroom.item.entities.Item;
import org.grapheople.inmaroom.item.entities.ItemPost;
import org.grapheople.inmaroom.item.entities.ItemProperty;
import org.grapheople.inmaroom.item.repositories.ItemPostRepository;
import org.grapheople.inmaroom.item.repositories.ItemRepository;
import org.grapheople.inmaroom.item.vo.CreateItemPostRequest;
import org.grapheople.inmaroom.item.vo.CreateItemRequest;
import org.grapheople.inmaroom.item.vo.ItemVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemPostRepository itemPostRepository;

    public List<Item> getItems() {
        return itemRepository.findAll();
    }

    public ItemVO getItem(Long id) {
        return itemRepository
                .findById(id)
                .map(ItemVO::of)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND));
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
                    itemProperty.setContent(property.getContent());
                    return itemProperty;
                }).toList());
        item.setTagList(request.getTagList());

        if (request.getParentId() != null) {
            itemRepository.findById(request.getParentId()).ifPresent(parentItem -> item.setParentId(parentItem.getParentId()));
        }
        if (request.getComponentList() != null && !request.getComponentList().isEmpty()) {
            List<Item> componentList = itemRepository.findAllById(request.getComponentList());
            item.setComponentList(componentList);
        }
        return itemRepository.save(item);
    }

    public ItemPost createItemPost(Long userId, Long itemId, CreateItemPostRequest request) {
        ItemPost itemPost = new ItemPost();
        itemPost.setUserId(userId);
        itemPost.setItemId(itemId);
        itemPost.setContent(request.getContent());
        itemPost.setImageList(request.getImageList());
        return itemPostRepository.save(itemPost);
    }
}

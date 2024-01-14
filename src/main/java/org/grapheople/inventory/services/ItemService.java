package org.grapheople.inventory.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grapheople.inventory.entities.Item;
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

    public Item createItem(Long userId, CreateItemRequest request) {
        Item item = new Item();
        item.setDescription(request.getDescription());
        item.setName(request.getName());
        item.setUserId(userId);
        return itemRepository.save(item);
    }
}

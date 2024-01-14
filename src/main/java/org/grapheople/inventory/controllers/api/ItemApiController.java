package org.grapheople.inventory.controllers.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grapheople.inventory.common.ApiResult;
import org.grapheople.inventory.entities.Item;
import org.grapheople.inventory.services.ItemService;
import org.grapheople.inventory.vo.request.CreateItemRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/item")
public class ItemApiController {
    private final ItemService itemService;

    @GetMapping("/")
    public ResponseEntity<ApiResult<List<Item>>> getItems() {
        return ResponseEntity.ok(new ApiResult<>(itemService.getItems()));
    }

    @PostMapping("/")
    public ResponseEntity<ApiResult<Item>> insertItem(@RequestBody CreateItemRequest request) {
        Long testUserId = 1L;
        return ResponseEntity.ok(new ApiResult<>(itemService.createItem(testUserId, request)));

    }
}

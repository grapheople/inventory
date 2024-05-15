package org.grapheople.inmaroom.item.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.grapheople.inmaroom.common.ApiResult;
import org.grapheople.inmaroom.item.entities.Item;
import org.grapheople.inmaroom.item.entities.ItemPost;
import org.grapheople.inmaroom.item.servieces.ItemService;
import org.grapheople.inmaroom.item.vo.CreateItemPostRequest;
import org.grapheople.inmaroom.item.vo.CreateItemRequest;
import org.grapheople.inmaroom.item.vo.ItemVO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/item")
public class ItemApiController {
    private final ItemService itemService;

    @GetMapping("")
    public ResponseEntity<ApiResult<List<Item>>> getItems() {
        return ResponseEntity.ok(new ApiResult<>(itemService.getItems()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResult<ItemVO>> getItem(@PathVariable Long id) {
        return ResponseEntity.ok(new ApiResult<>(itemService.getItem(id)));
    }

    @PostMapping("")
    public ResponseEntity<ApiResult<Item>> createItem(@RequestBody CreateItemRequest request) {
        Long testUserId = 1L;
        return ResponseEntity.ok(new ApiResult<>(itemService.createItem(testUserId, request)));
    }

    @PostMapping("/{id}/post")
    public ResponseEntity<ApiResult<ItemPost>> createItemPost(@PathVariable Long id, @RequestBody CreateItemPostRequest request) {
        Long testUserId = 1L;
        return ResponseEntity.ok(new ApiResult<>(itemService.createItemPost(testUserId, id, request)));
    }
}

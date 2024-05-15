package org.grapheople.inmaroom.controllers.web;

import lombok.RequiredArgsConstructor;
import org.grapheople.inmaroom.item.servieces.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web/inventory")
public class WebInventoryController {
    private final ItemService itemService;
    @RequestMapping( "")
    public String item(Model model) {
        model.addAttribute("items", itemService.getItems());
        return "/item/inventory_home";
    }

    @RequestMapping("/items/{id}")
    public String itemDetail(@PathVariable Long id, Model model) {
        model.addAttribute("item", itemService.getItem(id));
        return "/item/item_detail";
    }
}

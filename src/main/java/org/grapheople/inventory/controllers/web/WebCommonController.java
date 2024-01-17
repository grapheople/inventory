package org.grapheople.inventory.controllers.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web/common")
public class WebCommonController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Hello, Thymeleaf!");
        return "index"; // Thymeleaf 템플릿 파일의 이름 (templates 폴더 내의 index.html)
    }
}

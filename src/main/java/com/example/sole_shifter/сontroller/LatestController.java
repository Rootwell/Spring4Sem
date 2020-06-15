package com.example.sole_shifter.сontroller;

import com.example.sole_shifter.service.HeaderService;
import com.example.sole_shifter.service.PostsCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/latest")
public class LatestController {

    @Autowired
    PostsCategoryService postsCategoryService;

    @Autowired
    HeaderService headerService;

    @GetMapping
    public String getLatest(Authentication authentication, Model model) {
        model.addAttribute("selection", "latest");
        model.addAttribute("posts", postsCategoryService.getLatest());
        headerService.setHrefAndName(authentication, model);
        return "postspage";
    }
}

package com.example.sole_shifter.сontroller;

import com.example.sole_shifter.model.User;
import com.example.sole_shifter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/becomeAuthor")
@PreAuthorize("hasAuthority('ORD_USER')")
public class BecomeAuthorController {

    @Autowired
    UserService userService;

    @GetMapping
    public String page(Authentication authentication, Model model) {
        User user = userService.getUser(authentication);
        model.addAttribute("user", user);
        return "becomeauthor";
    }
}
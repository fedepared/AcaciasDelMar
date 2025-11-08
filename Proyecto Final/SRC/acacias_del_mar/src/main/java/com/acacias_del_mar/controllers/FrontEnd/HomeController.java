package com.acacias_del_mar.controllers.FrontEnd;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    @PreAuthorize("isAuthenticated()")
    public String homePage(Model model) {
        
        model.addAttribute("currentPage","/home");
        return "home";
    }
}

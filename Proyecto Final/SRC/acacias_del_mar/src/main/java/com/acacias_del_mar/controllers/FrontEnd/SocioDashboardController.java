package com.acacias_del_mar.controller.view;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/socio")
@PreAuthorize("hasRole('SOCIO')")
public class SocioDashboardController {

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        model.addAttribute("currentPage", "/socio/dashboard");
        return "socio/dashboard"; // -> templates/socio/dashboard.html
    }
}

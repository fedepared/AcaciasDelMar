package com.acacias_del_mar.controllers.FrontEnd;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/admin/compras") 
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class CompraGarageVistaController {

    @GetMapping
    public String showComprasPage(Model model) {
        model.addAttribute("currentPage", "/admin/compras");
        
        return "admin/compras";
    }
}
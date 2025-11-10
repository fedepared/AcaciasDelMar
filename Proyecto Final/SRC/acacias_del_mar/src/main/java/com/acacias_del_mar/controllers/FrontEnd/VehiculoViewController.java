package com.acacias_del_mar.controllers.FrontEnd;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/vehiculos")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class VehiculoViewController {

    @GetMapping
    public String showVehiculosPage(Model model) {
        // Esto es para que el 'layout.html' sepa qué enlace marcar como 'activo'
        model.addAttribute("currentPage", "/admin/vehiculos");
        
        // Esto le dice a Thymeleaf que busque en:
        // src/main/resources/templates/admin/vehiculos.html
        return "admin/vehiculos";
    }
}

package com.acacias_del_mar.controllers.FrontEnd;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/zonas")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class ZonaVistaController {

    @GetMapping
    public String showZonasPage(Model model) {
        // Para que el layout marque "Zonas" como activo
        model.addAttribute("currentPage", "/admin/zonas");
        
        // Devuelve templates/admin/zonas.html
        return "admin/zonas";
    }
}

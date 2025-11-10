package com.acacias_del_mar.controllers.FrontEnd;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/asignaciones")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class AsignacionesVistaController {

    @GetMapping
    public String showAsignacionesPage(Model model) {
        // Para que el layout marque "Asignaciones V-G" como activo
        model.addAttribute("currentPage", "/admin/asignaciones");
        
        // Devuelve templates/admin/asignaciones.html
        return "admin/asignaciones";
    }
}

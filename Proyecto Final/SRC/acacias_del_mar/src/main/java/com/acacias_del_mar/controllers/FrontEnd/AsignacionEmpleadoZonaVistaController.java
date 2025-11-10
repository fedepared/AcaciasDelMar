package com.acacias_del_mar.controllers.FrontEnd;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
// Mapeamos a la URL que definimos en layout.html
@RequestMapping("/admin/asignaciones-ez") 
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class AsignacionEmpleadoZonaVistaController { // Tal como lo pediste

    @GetMapping
    public String showAsignacionesPage(Model model) {
        // Para que el layout marque "Asignaciones E-Z" como activo
        model.addAttribute("currentPage", "/admin/asignaciones-ez");
        
        // Devuelve templates/admin/asignaciones-ez.html
        return "admin/asignaciones-ez";
    }
}
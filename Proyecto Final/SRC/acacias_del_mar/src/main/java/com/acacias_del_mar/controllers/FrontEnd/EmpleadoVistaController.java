package com.acacias_del_mar.controllers.FrontEnd;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/empleados")
@PreAuthorize("hasRole('ADMINISTRADOR')")
public class EmpleadoVistaController {

    @GetMapping
    public String showEmpleadosPage(Model model) {
        // Para que el layout marque "Empleados" como activo
        model.addAttribute("currentPage", "/admin/empleados");
        
        // Devuelve templates/admin/empleados.html
        return "admin/empleados";
    }
}

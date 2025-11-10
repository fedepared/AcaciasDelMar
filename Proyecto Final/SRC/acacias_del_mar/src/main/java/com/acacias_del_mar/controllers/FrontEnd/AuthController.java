package com.acacias_del_mar.controllers.FrontEnd;

import com.acacias_del_mar.DTOs.RegistroDTO;
import com.acacias_del_mar.services.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;

@Controller
public class AuthController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/")
    public String handleRootRedirect(Authentication authentication) {
        
        if (authentication != null && authentication.isAuthenticated()) {
            return "redirect:/home";
        }
        
        return "redirect:/login";
    }
    
    @GetMapping("/login")
    public String viewLoginPage(){
        return "login";
    }
    
    @GetMapping("/register")
    public String viewRegisterPage(Model model)
    {
        model.addAttribute("usuarioDTO", new RegistroDTO());
        return "register";
    }
    
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("usuarioDTO") RegistroDTO registroDTO,BindingResult bindingResult,Model model)
    {
        //errores de validacion del DTO
        if(bindingResult.hasErrors()){
            return "register";
        }
        
        try{
            usuarioService.registrarUsuario(registroDTO);
            return "redirect:/login?register_success=true"; //va de nuevo a login
        }catch (RuntimeException e){
            model.addAttribute("registroError",e.getMessage());
            return "register";
        }
    }
}

package com.acacias_del_mar.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    public void onAuthenticationSuccess(HttpServletRequest request,HttpServletResponse response,Authentication authentication) throws IOException, ServletException
    {
        //para obtener los roles del usuario logeado
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        //redirección en sí
        for(GrantedAuthority authority : authorities)
        {
            String authorityName = authority.getAuthority();
            
            if(authorityName.equals("ROLE_ADMINISTRADOR")){
                response.sendRedirect("admin/socios");
                return;
            }
            if(authorityName.equals("ROLE_EMPLEADO"))
            {
                response.sendRedirect("empleado/dashboard");
                return;
            }
        }
        
        response.sendRedirect("socio/dashboard");
        
        
    }

    

    
}

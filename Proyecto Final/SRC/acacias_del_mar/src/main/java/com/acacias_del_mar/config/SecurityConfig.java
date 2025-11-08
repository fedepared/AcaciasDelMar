package com.acacias_del_mar.config;

import com.acacias_del_mar.repositories.UsuarioRepository; 
import com.acacias_del_mar.entities.Usuario; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
import static org.springframework.web.servlet.function.RequestPredicates.headers;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
    
    
    @Autowired
    private CustomAuthenticationSuccessHandler successHandler;
    //Codifica contraseñas
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    //Le dice a Spring Security como buscar a un usuario en la db
    @Bean
    public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository)
    {
        return username -> {
            //Buscar por campo nombre
            Usuario usuario = usuarioRepository.findByNombre(username)
                    .orElseThrow(()  ->new UsernameNotFoundException("Usuario no encontrado" + username));
            
            //Convertir usuario en userDetails de spring
            return org.springframework.security.core.userdetails.User
                    .withUsername(usuario.getNombre())
                    .password(usuario.getPass())
                    .roles(usuario.getTipoUsuario().name().toUpperCase())
                    .build();
        };
    }
    
    //Filtros de seguridad para las urls publicas y privadas
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
         // Política de Seguridad de Contenidos (CSP)
        String cspPolicy = 
            "default-src 'self';" + 
            "style-src 'self' https://cdn.jsdelivr.net https://cdnjs.cloudflare.com 'unsafe-inline';" + 
            "font-src 'self' https://cdnjs.cloudflare.com;" + 
            "script-src 'self' 'unsafe-inline';" + 
            "img-src 'self' data:;"; 
        
        http.authorizeHttpRequests(auth -> 
            auth
                //Permitidas
                .requestMatchers("/css/**","/js/**","/images/**").permitAll()
                .requestMatchers("/","/login","/register").permitAll()
                //No permitidas
                .anyRequest().authenticated()
        )
        //formulario de login
        .formLogin(form -> form
                .loginPage("/login")//url de login
                .loginProcessingUrl("/login-process") //a donde va el login
                .successHandler(successHandler) //a donde va despues de logearse correctamente 
                .failureUrl("/login?error=true") //a donde va si falla
                .permitAll() //la pagina de login es visible para todos
        )
        //logout
        .logout(logout -> 
                logout.logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()  
        )
        .csrf(csrf -> csrf.disable()) //deshabilitarlo para produ
        
        .headers(headers -> headers
                // Añadimos la cabecera CSP
                .addHeaderWriter(new StaticHeadersWriter("Content-Security-Policy", cspPolicy))
        ); 
        
        return http.build();
    }
    
}

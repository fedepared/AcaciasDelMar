package com.acacias_del_mar.services.Usuario;

import com.acacias_del_mar.DTOs.RegistroDTO;
import com.acacias_del_mar.entities.Usuario;
import java.util.List;


public interface UsuarioService {
    List<Usuario> obtenerUsuarios();
    
    Usuario crearContacto();
    
    boolean existeUsuario(String nombre);
    
    Usuario registrarUsuario(RegistroDTO registroDTO);
}

package com.acacias_del_mar.services.Usuario;

import com.acacias_del_mar.entities.Usuario;
import com.acacias_del_mar.repositories.UsuarioRepository;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Slf4j
@Transactional
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepository userRepository;
    
    @Override
    public List<Usuario> obtenerUsuarios() {
        log.info("Get Usuarios");
        return userRepository.findAll();
    }

    @Override
    public Usuario crearContacto() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean existeUsuario(String nombreUsuario) {
        return userRepository.existsByNombre(nombreUsuario);
    }
    
    
}

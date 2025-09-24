package com.seguridad.seguridad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguridad.seguridad.models.Usuario;
import com.seguridad.seguridad.repository.UsuarioRepository;

@Service 
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    //servicio para listar usuarios
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    //servicio para agregar un usuario
    public void agregarUsuario(Usuario usuario){
        usuarioRepository.usuario_agregar(usuario.getCod_usu(),usuario.getAli_usu(), usuario.getEma_usu(),usuario.getCla_usu(),usuario.getEst_usu());
    }
    
}

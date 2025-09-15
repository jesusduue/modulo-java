package com.seguridad.seguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seguridad.seguridad.models.usuario;
import com.seguridad.seguridad.repository.UsuarioRepository;

@Controller
public class usuarioController {
  /*   */
   //showUsuarioView() es un metodo de controlador en una aplicacion web de spring. su objetivo es manejar las peticiones http get que llegan a la ruta /usuario y devolver el nombre de la vista que debe ser renderizada 
/*    public String showUsuarioView() {
       return "usuario"; // Nombre de la vista a retornar
   } */
   //funcion para listar los usuarios
    
   @Autowired
    private UsuarioRepository usuarioRepository;
    @GetMapping("/usuario")
    public String UsuarioListar(Model models) {
        List<usuario> usuarios = usuarioRepository.findAll();
        models.addAttribute("usuarios", usuarios);
        return "usuario";
    }

}

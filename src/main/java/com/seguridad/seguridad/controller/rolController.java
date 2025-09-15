package com.seguridad.seguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seguridad.seguridad.models.Rol;
import com.seguridad.seguridad.repository.RolRepository;


@Controller
public class rolController {

    //inyectamos la dependencia del repositorio
   @Autowired
   private RolRepository rolRepository;
    //funcion para listar los roles
    @GetMapping("/rol")
    public String RolListar(Model models) {
        List<Rol> rols = rolRepository.findAll();
        models.addAttribute("rols", rols);
        return "rol";
    }
}
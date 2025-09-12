package com.seguridad.seguridad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class rolController {
   @GetMapping("/rol")
   //showRolView() es un metodo de controlador en una aplicacion web de spring. su objetivo es manejar las peticiones http get que llegan a la ruta /rol y devolver el nombre de la vista que debe ser renderizada 
   public String showRolView() {
       return "rol"; // Nombre de la vista a retornar
   }
   
}


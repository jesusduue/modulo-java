package com.seguridad.seguridad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class rolFanPagController {
   @GetMapping("/rol_fan_pag")
   //showRolFanPagView() es un metodo de controlador en una aplicacion web de spring. su objetivo es manejar las peticiones http get que llegan a la ruta /rolFanPag y devolver el nombre de la vista que debe ser renderizada 
   public String showRolFanPagView() {
       return "rol_fan_pag"; // Nombre de la vista a retornar
   }
   
}

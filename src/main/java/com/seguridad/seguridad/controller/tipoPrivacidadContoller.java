package com.seguridad.seguridad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class tipoPrivacidadContoller {
   @GetMapping("/tipo_privacidad")
   //showTipoPrivacidadView() es un metodo de controlador en una aplicacion web de spring. su objetivo es manejar las peticiones http get que llegan a la ruta /tipo_privacidad y devolver el nombre de la vista que debe ser renderizada 
   public String showTipoPrivacidadView() {
       return "tipo_privacidad"; // Nombre de la vista a retornar
   }
   
}

package com.seguridad.seguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seguridad.seguridad.models.tipoPrivacidad;
import com.seguridad.seguridad.repository.tipoPrivacidadRepository;


@Controller
public class tipoPrivacidadContoller {
    // Inyectamos la dependencia del repositorio
@Autowired
private tipoPrivacidadRepository tipoPrivacidadRepository;

@GetMapping("/tipo_privacidad")
public String TipoPrivacidad(Model models) {
    List<tipoPrivacidad> tipoPrivlList = tipoPrivacidadRepository.findAll();
    models.addAttribute("tipoPrivlList", tipoPrivlList);
    return "tipo_privacidad"; // Devuelve el nombre de la vista
}
}

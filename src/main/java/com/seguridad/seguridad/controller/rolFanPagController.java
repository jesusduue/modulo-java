package com.seguridad.seguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.seguridad.seguridad.models.Rol_Fan_Page;
import com.seguridad.seguridad.repository.rolFanPagRepository;


@Controller
public class rolFanPagController {

    @Autowired
    private rolFanPagRepository rolFanPagRepository;
    @GetMapping("/rol_fan_pag")
    public String RolFanPag(Model models) {
        List<Rol_Fan_Page> rolFanPags = rolFanPagRepository.findAll();
        models.addAttribute("rolFanPags", rolFanPags);
        return "rol_fan_pag";
    }

}

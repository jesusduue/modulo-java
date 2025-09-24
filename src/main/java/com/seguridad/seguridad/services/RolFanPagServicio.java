package com.seguridad.seguridad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguridad.seguridad.models.Rol_Fan_Page;
import com.seguridad.seguridad.repository.RolFanPagRepository;

@Service
public class RolFanPagServicio {
    @Autowired
    private RolFanPagRepository rolFanPagRepository;

    //objeto para listar
    public List<Rol_Fan_Page> listar(){
        return rolFanPagRepository.findAll();
    }
    
    //metodo para agregar un rol
    public void agregarRolFanPag(Rol_Fan_Page rolFanPage){
        rolFanPagRepository.rol_fan_pag_agregar(
            rolFanPage.getCod_rol_fan(), 
            rolFanPage.getPersona().getCod_per(), 
            rolFanPage.getFan_page().getCod_fan_pag(), 
            rolFanPage.getRol().getCod_rol(),
            rolFanPage.getEst_rol_fan()); 
    }
}
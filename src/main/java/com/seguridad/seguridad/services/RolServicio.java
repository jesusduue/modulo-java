package com.seguridad.seguridad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguridad.seguridad.models.Rol;
import com.seguridad.seguridad.repository.RolRepository;

@Service
public class RolServicio {

    @Autowired
    private RolRepository rolRepository;

    /* obtiene y devuelve un lista de todos los roles de la bse de datos
     * @return un lista de objetos de rol
     */
    public List<Rol> listar(){
        return rolRepository.findAll();
    }
    
    //metodo para agregar un rol
    public void agregarRol(Rol rol){
        rolRepository.rol_agregar(rol.getCod_rol(), rol.getNom_rol(), rol.getDes_rol(), rol.getEst_rol());
    }
}

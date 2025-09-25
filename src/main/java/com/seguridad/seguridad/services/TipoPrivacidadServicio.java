package com.seguridad.seguridad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seguridad.seguridad.models.TipoPrivacidad;
import com.seguridad.seguridad.repository.TipoPrivacidadRepository;

@Service
public class TipoPrivacidadServicio {
    
    @Autowired
    private TipoPrivacidadRepository tipoPrivacidadRepository;

    //servicio para listar usuario con el query listo del repositorio
    public List<TipoPrivacidad> listar(){
        return tipoPrivacidadRepository.findAll();
    }

    //servicion para agregar un nuevo tipo
    public void agregarTipoPrivacidad(TipoPrivacidad tipoPrivacidad){
        tipoPrivacidadRepository.tipo_privacidad_agregar(tipoPrivacidad.getCod_tip(), tipoPrivacidad.getNom_tip(), tipoPrivacidad.getEst_tip());
    }

    //servicio para modificar
    public Integer modificarTipoPrivacidad(TipoPrivacidad tipoPrivacidad){
        return tipoPrivacidadRepository.tipo_privacidad_modificar(tipoPrivacidad.getCod_tip(), tipoPrivacidad.getNom_tip(), tipoPrivacidad.getEst_tip());
    }

    //servicio para eliminar
    public Integer eliminarTipoPrivacidad(int cod_tip){
        return tipoPrivacidadRepository.tipo_privacidad_eliminar(cod_tip);
    }

    public TipoPrivacidad buscarPorId(int cod_tip){
        return tipoPrivacidadRepository.findById(cod_tip).orElse(null);
    }
}

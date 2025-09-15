package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.tipoPrivacidad;

@Repository
public interface tipoPrivacidadRepository extends JpaRepository<tipoPrivacidad, Integer> {
    // Métodos estandar de spring data JPA
    // List<tipoPrivacidad> findAll();
    @Query(value = "select * from seguridad.tipo_privacidad_listado()", nativeQuery = true)
    List<Object> tipo_privacidad_listado();
    
}

package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    // Métodos de consulta personalizados pueden ser añadidos aquí

    @Query(value = "select * from perfil_personal.persona_listado()", nativeQuery=true) 
    List<Object> persona_listado();
    
}

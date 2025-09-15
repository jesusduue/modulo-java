package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<usuario, Integer> {
    //metodo estandar de spring data JPA
    //list<usuario> findAll()
    @Query(value = "select * from seguridad.usuario_listado()", nativeQuery=true) 
    List<Object> usuario_listado();                      
}

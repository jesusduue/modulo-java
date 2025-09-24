package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.Fan_Page;

@Repository
public interface FanPageRepository extends JpaRepository<Fan_Page, Integer> {
    // Métodos de consulta personalizados pueden ser añadidos aquí
    @Query(value = "select * from seguridad.fan_page_listado()", nativeQuery=true) 
    List<Object> fan_page_listado();
}

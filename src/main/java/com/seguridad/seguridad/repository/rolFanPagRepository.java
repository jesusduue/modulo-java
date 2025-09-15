package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.Rol_Fan_Page;

@Repository
public interface rolFanPagRepository extends JpaRepository<Rol_Fan_Page, Integer> {
    //metodo estandar de spring data JPA
    //list<RolFanPag> findAll()

    //metodo para invocar el procedimiento almacenado (mas seguro)
    @Query(value = "select * from seguridad.rol_fan_page_listado()", nativeQuery=true)
    List<Object> rol_fan_page_listado();
    
}

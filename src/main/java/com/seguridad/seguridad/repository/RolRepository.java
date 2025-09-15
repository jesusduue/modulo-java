package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.Rol;

@Repository
public interface  RolRepository extends JpaRepository<Rol, Integer> {
    //metodo estandar de spring data JPA
    //list<Rol> findAll()

    //metodo para invocar el procedimiento almacenado (mas seguro)
    @Query(value = "select * from seguridad.rol_listado()", nativeQuery=true)
    List<Object> rol_listado();
}

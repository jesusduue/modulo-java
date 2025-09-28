package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.Rol_Fan_Page;

import jakarta.transaction.Transactional;

@Repository
public interface RolFanPagRepository extends JpaRepository<Rol_Fan_Page, Integer> {
    //metodo estandar de spring data JPA
    //list<RolFanPag> findAll()

    //metodo para invocar el procedimiento almacenado (mas seguro)
    @Query(value = "select * from seguridad.rol_fan_page_listado()", nativeQuery=true)
    List<Object> rol_fan_page_listado();


    //metodo para agregar
    @Transactional
    @Query(value="SELECT seguridad.rol_fan_pag_agregar(:cod_rol_fan, :fky_per, :fky_fan_pag, :fky_rol, :est_rol_fan)", nativeQuery= true)
    Integer rol_fan_pag_agregar(@Param("cod_rol_fan") int cod_rol_fan,
                              @Param("fky_per") int fky_per,
                              @Param("fky_fan_pag") int fky_fan_pag,
                              @Param("fky_rol") int fky_rol,
                              @Param("est_rol_fan") String est_rol_fan);

    //metodo para modificar
    @Transactional
    @Query(value="SELECT seguridad.rol_fan_pag_modificar(:cod_rol_fan, :fky_per, :fky_fan_pag, :fky_rol, :est_rol_fan)", nativeQuery= true)
    Integer rol_fan_pag_modificar(@Param("cod_rol_fan") int cod_rol_fan,
                              @Param("fky_per") int fky_per,
                              @Param("fky_fan_pag") int fky_fan_pag,
                              @Param("fky_rol") int fky_rol,
                              @Param("est_rol_fan") String est_rol_fan);
                              
    //metodo para eliminar
    @Transactional
    @Query(value="SELECT seguridad.rol_fan_pag_eliminar(:cod_rol_fan)", nativeQuery=true)
    Integer rol_fan_pag_eliminar(@Param("cod_rol_fan") int cod_rol_fan);                          

}

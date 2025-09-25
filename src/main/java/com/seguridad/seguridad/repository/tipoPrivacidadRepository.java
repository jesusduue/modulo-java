package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.TipoPrivacidad;

import jakarta.transaction.Transactional;

@Repository
public interface TipoPrivacidadRepository extends JpaRepository<TipoPrivacidad, Integer> {
    // Métodos estandar de spring data JPA
    // List<tipoPrivacidad> findAll();
    @Query(value = "select * from seguridad.tipo_privacidad_listado()", nativeQuery = true)
    List<Object> tipo_privacidad_listado();
    
    //metodo para agregar 
    @Transactional
    @Query(value="SELECT seguridad.tipo_privacidad_agregar(:cod_tip,  :nom_tip,  :est_tip)", nativeQuery=true)
    Integer tipo_privacidad_agregar(@Param("cod_tip") Integer cod_tip, @Param("nom_tip") String nom_tip, @Param("est_tip") String est_tip );

    //metodo para modificar
    @Transactional
    @Query(value="SELECT seguridad.tipo_privacidad_modificar(:cod_tip,  :nom_tip,  :est_tip)", nativeQuery=true)
    Integer tipo_privacidad_modificar(@Param("cod_tip") Integer cod_tip, @Param("nom_tip") String nom_tip, @Param("est_tip") String est_tip );

    //metodo para eliminar
    @Transactional
    @Query(value="SELECT seguridad.tipo_privacidad_eliminar(:cod_tip)", nativeQuery=true)
    Integer tipo_privacidad_eliminar(@Param("cod_tip") int cod_tip);
    
}

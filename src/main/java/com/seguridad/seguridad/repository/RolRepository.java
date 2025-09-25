package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.Rol;

import jakarta.transaction.Transactional;

@Repository
public interface  RolRepository extends JpaRepository<Rol, Integer> {
    //metodo estandar de spring data JPA
    //list<Rol> findAll()

    //metodo para invocar el procedimiento almacenado (mas seguro)
    @Query(value = "select * from seguridad.rol_listado()", nativeQuery=true)
    List<Object> rol_listado();


    //metodo para agregar
    @Transactional
    @Query(value="SELECT seguridad.rol_agregar(:cod_rol, :nom_rol, :des_rol, :est_rol)", nativeQuery= true)
    Integer rol_agregar(@Param("cod_rol") Integer cod_rol, @Param("nom_rol") String nom_rol, @Param("des_rol") String des_rol, @Param("est_rol") String est_rol);

    //metodo para modificar
     @Transactional
    @Query(value="SELECT seguridad.rol_modificar(:cod_rol,:nom_rol,:des_rol,:est_rol)", nativeQuery=true)
    Integer rol_modificar(@Param("cod_rol") int cod_rol, @Param("nom_rol") String nom_rol, @Param("des_rol") String des_rol, @Param("est_rol") String est_rol);

    //Metodo para Eliminar
    @Transactional
    @Query(value="SELECT seguridad.rol_eliminar(:cod_rol)", nativeQuery=true)
    Integer rol_eliminar(@Param("cod_rol") int cod_rol);
}

package com.seguridad.seguridad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.seguridad.seguridad.models.Usuario;

import jakarta.transaction.Transactional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    //metodo estandar de spring data JPA
    //list<usuario> findAll()
    @Query(value = "select * from seguridad.usuario_listado()", nativeQuery=true) 
    List<Object> usuario_listado();                      

    //metodo para agregar
    @Transactional
    @Query(value="SELECT seguridad.usuario_agregar(:cod_usu, :ali_usu, :ema_usu, :cla_usu, :est_usu )", nativeQuery=true)
    Integer usuario_agregar(@Param("cod_usu") Integer cod_usu, @Param("ali_usu") String ali_usu, @Param("ema_usu") String ema_usu, @Param("cla_usu") String cla_usu, @Param("est_usu") String est_usu);

}

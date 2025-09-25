package com.seguridad.seguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; // Se importa ModelAttribute para el post
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seguridad.seguridad.models.Rol;
import com.seguridad.seguridad.services.RolServicio;

@Controller
public class rolController {

    // se anade el servicio y no el repositorio
    @Autowired
    private RolServicio rolServicio;

    //funcion para listar los roles
    @GetMapping("/rol")
    public String RolListar(Model models) {
        List<Rol> rols = rolServicio.listar(); // CAMBIO: Se llama al método listar del servicio.
        models.addAttribute("rols", rols);
        // Esto es crucial para que el formulario del modal "Agregar" funcione con Thymeleaf (th:object).
        models.addAttribute("rol", new Rol());

        return "rol";
    }


    // // ELIMINADO: Este método ya no es necesario.
    // // El formulario para agregar está en un modal en la página principal,
    // // por lo que no se necesita una ruta GET separada para "rol/agregar".
    // @GetMapping("rol/agregar")
    // public String agregarRol(Model models) {
    //     models.addAttribute("rol", new Rol());
    //     return "rol";
    // }

    //metodo para agregar
    @PostMapping("/rol")
    //Se usa @ModelAttribute para indicar que el objeto 'rol' viene de los datos del formulario.
    public String agregarRol(@ModelAttribute Rol rol, RedirectAttributes redirect) {
        try {
            //log para depurracion para saber si los datos del formularion estan llegando al controlador
            System.out.println("Datos recibidos: cod_rol:" + rol.getCod_rol() + ", nom_rol:" + rol.getNom_rol() + ", des_rol:" + rol.getDes_rol() + ", est_rol:" + rol.getEst_rol());

            //metodo del servicio para agregar
            rolServicio.agregarRol(rol);

            redirect.addFlashAttribute("mensaje","ROL AGREGADO EXITOSAMENTE");
            return "redirect:/rol";
        } catch (Exception e) {
            redirect.addFlashAttribute("error","Ocurrió un error al agregar: " + e.getMessage());
            return "redirect:/rol";
        }
    }
    //metodo para eliminar
    @PostMapping("/rol/eliminar")
    @SuppressWarnings("CallToPrintStackTrace")
    public String eliminarRol(@Param("cod_rol") int cod_rol, RedirectAttributes redirect){
       try {
        Rol rol = rolServicio.buscarPorId(cod_rol);
           if(rol != null){
            Integer resultado = rolServicio.eliminarRol(cod_rol);
            System.out.println("resultado eliminar" + resultado);
            redirect.addFlashAttribute("mensaje", "Resultado eliminado con exito");
           }else{
            redirect.addFlashAttribute("error", "Error al eliminar");
           }
       } catch (Exception e) {
            e.printStackTrace();//esto mostrara 
            redirect.addFlashAttribute("error", "Ocurrió un error al eliminar: " + e.getMessage());
       } 
       return "redirect:/rol";
    }

    //metodo para modificar
    @PostMapping("/rol/modificar")
    public String modificarRol(@ModelAttribute Rol rol, RedirectAttributes redirect) {
        try {
            Integer resultado = rolServicio.modificarRol(rol);
            if (resultado != null) {
                redirect.addFlashAttribute("mensaje", "ROL MODIFICADO EXITOSAMENTE");
            } else {
                redirect.addFlashAttribute("error", "Error al modificar");
            }
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Ocurrió un error al modificar: " + e.getMessage());
        }
        return "redirect:/rol";
    }


}
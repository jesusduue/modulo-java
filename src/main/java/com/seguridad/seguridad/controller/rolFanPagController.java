package com.seguridad.seguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seguridad.seguridad.models.Rol_Fan_Page;
import com.seguridad.seguridad.repository.FanPageRepository;
import com.seguridad.seguridad.repository.PersonaRepository;
import com.seguridad.seguridad.repository.RolRepository;
import com.seguridad.seguridad.services.RolFanPagServicio;


@Controller
public class rolFanPagController {

    //  Inyectamos el servicio en lugar del repositorio directamente. Es una mejor práctica.
    @Autowired
    private RolFanPagServicio rolFanPagServicio;
    
    //  Inyectamos los otros repositorios que necesitamos para los datos del formulario.
    // Asegúrate de tener creados estos archivos de repositorio en tu proyecto.
    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private FanPageRepository fanPageRepository;

    @Autowired
    private RolRepository rolRepository;


    @GetMapping("/rol_fan_pag")
    public String RolFanPag(Model models) {
        //  Obtenemos la lista de roles asignados para mostrar en la tabla principal.
        List<Rol_Fan_Page> rolFanPags = rolFanPagServicio.listar();
        models.addAttribute("rolFanPags", rolFanPags);
        
        // Creamos un objeto vacío para enlazarlo con el formulario de "Agregar".
        models.addAttribute("rolFanPag", new Rol_Fan_Page());

        // Obtenemos y añadimos las listas de personas, fan pages y roles.
        //    Estos se usarán para rellenar dinámicamente los <select> en el modal.
        models.addAttribute("personas", personaRepository.findAll());
        models.addAttribute("fanPages", fanPageRepository.findAll());
        models.addAttribute("roles", rolRepository.findAll());

        return "rol_fan_pag";
    }

    @PostMapping("/rol_fan_pag")
    public String guardarRolFanPag(@ModelAttribute Rol_Fan_Page rolFanPag, RedirectAttributes redirect) {
        try {
            rolFanPagServicio.agregarRolFanPag(rolFanPag);
            // Si todo sale bien, enviamos un mensaje de éxito.
            redirect.addFlashAttribute("mensaje", "Asignación de rol guardada correctamente.");
        } catch (Exception e) {
            // Si ocurre un error, enviamos un mensaje de error.
            redirect.addFlashAttribute("error", "Error al guardar la asignación: " + e.getMessage());
        }
        return "redirect:/rol_fan_pag";
    }

        //metodo para eliminar
    @PostMapping("/rol_fan_pag/eliminar")
    @SuppressWarnings("CallToPrintStackTrace")
    public String eliminarRolFanPag(@Param("cod_rol_fan") int cod_rol_fan, RedirectAttributes redirect){
       try {
           Rol_Fan_Page rolFanPag = rolFanPagServicio.buscarPorId(cod_rol_fan);
           if(rolFanPag != null){
               Integer resultado = rolFanPagServicio.eliminarRolFanPag(cod_rol_fan);
               System.out.println("resultado eliminar" + resultado);
               redirect.addFlashAttribute("mensaje", "Resultado eliminado con exito");
           }else{
            redirect.addFlashAttribute("error", "Error al eliminar");
           }
       } catch (Exception e) {
            e.printStackTrace();//esto mostrara 
            redirect.addFlashAttribute("error", "Ocurrió un error al eliminar: " + e.getMessage());
       }
       return "redirect:/rol_fan_pag";
    }

    //metodo para modificar
    @PostMapping("/rol_fan_pag/modificar")
    public String modificarRolFanPag(@ModelAttribute Rol_Fan_Page rolFanPag, RedirectAttributes redirect) {
        try {
            Integer resultado = rolFanPagServicio.modificarRolFanPag(rolFanPag);
            //log para depuracion
            System.out.println("Resultado de la modificacion: " + resultado);
            if(resultado != null){
                redirect.addFlashAttribute("mensaje","modificado con exito");
            }else{
                redirect.addFlashAttribute("error", "error al modificar");
            }
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "ocurrio un error al");
        }
        return "redirect:/rol_fan_pag";
    }

}
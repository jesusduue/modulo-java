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

import com.seguridad.seguridad.models.TipoPrivacidad;
import com.seguridad.seguridad.services.TipoPrivacidadServicio;

@Controller
public class tipoPrivacidadContoller {
    // Inyectamos la dependencia del repositorio
@Autowired
private TipoPrivacidadServicio tipoPrivacidadServicio;

@GetMapping("/tipo_privacidad")
public String TipoPrivacidad(Model models) {
    List<TipoPrivacidad> tipoPrivlList = tipoPrivacidadServicio.listar();
    models.addAttribute("tipoPrivlList", tipoPrivlList);

        //se hace de esta manera para que el Formulario del modal Agregar, funcione con thymeleaf (th:object)
    models.addAttribute("tipoPrivacidad", new TipoPrivacidad()); 
    
    return "tipo_privacidad"; // Devuelve el nombre de la vista
}
    
    //metodo para agregar un nuevo tipo de privacidad
        @PostMapping("/tipo_privacidad")
        public String agregarTipoPrivacidad(@ModelAttribute TipoPrivacidad tipoPrivacidad, RedirectAttributes redirect) {
            //TODO: process POST request
            try {

                //log para saber si se recibin los datos del formulario
                System.out.println("datos recibidos: cod_tip:" + tipoPrivacidad.getCod_tip() + ", nom_tip: "+ tipoPrivacidad.getNom_tip() + " est_tip" + tipoPrivacidad.getEst_tip());

                //se llama el metodo agregar desde services
                tipoPrivacidadServicio.agregarTipoPrivacidad(tipoPrivacidad);

                redirect.addFlashAttribute("Agregado Correctamente");
                return "redirect:/tipo_privacidad";
            } catch (Exception e) {

                redirect.addFlashAttribute("Error al Registrar: " + e.getMessage());
                return "redirect:/tipo_privacidad";
            }
            
        }
    
    //enpoint o metodo para eliminar 
    @PostMapping("/tipo_privacidad/eliminar")
    @SuppressWarnings("CallToPrintStackTrace")
    public String eliminarTipoPrivacidad(@Param("cod_tip") int cod_tip, RedirectAttributes redirect){
       try {
        TipoPrivacidad tipoPrivacidad = tipoPrivacidadServicio.buscarPorId(cod_tip);
           if(tipoPrivacidad != null){
            Integer resultado = tipoPrivacidadServicio.eliminarTipoPrivacidad(cod_tip);
            System.out.println("resultado eliminar" + resultado);
            redirect.addFlashAttribute("mensaje", "Resultado eliminado con exito");
           }else{
            redirect.addFlashAttribute("error", "Error al eliminar");
           }
       } catch (Exception e) {
            e.printStackTrace();//esto mostrara 
            redirect.addFlashAttribute("error", "Ocurrió un error al eliminar: " + e.getMessage());
       } 
       return "redirect:/tipo_privacidad";
    }
        
    //endpoint para modificar
        //metodo para modificar
    @PostMapping("/tipo_privacidad/modificar")
    public String modificarTipoPrivacidad(@ModelAttribute TipoPrivacidad tipoPrivacidad, RedirectAttributes redirect) {
        try {
            Integer resultado = tipoPrivacidadServicio.modificarTipoPrivacidad(tipoPrivacidad);
            if (resultado != null) {
                redirect.addFlashAttribute("mensaje", "ROL MODIFICADO EXITOSAMENTE");
            } else {
                redirect.addFlashAttribute("error", "Error al modificar");
            }
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Ocurrió un error al modificar: " + e.getMessage());
        }
        return "redirect:/tipo_privacidad";
    }

}

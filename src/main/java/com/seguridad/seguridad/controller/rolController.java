package com.seguridad.seguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute; // Se importa ModelAttribute para el post
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.seguridad.seguridad.models.Rol;
import com.seguridad.seguridad.services.RolServicio; // AÑADIDO: Se importa el servicio para usarlo

@Controller
public class rolController {

    // // COMENTADO: Se inyectará el servicio en lugar del repositorio directamente.
    // @Autowired
    // private RolRepository rolRepository;

    // AÑADIDO: Inyectamos la dependencia del servicio.
    @Autowired
    private RolServicio rolServicio;

    //funcion para listar los roles
    @GetMapping("/rol")
    public String RolListar(Model models) {
        List<Rol> rols = rolServicio.listar(); // CAMBIO: Se llama al método listar del servicio.
        models.addAttribute("rols", rols);
        // AÑADIDO: Se agrega un nuevo objeto Rol al modelo.
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
    @PostMapping("/rol") // CAMBIO: Se ajusta la ruta a "/rol" para que coincida con el formulario.
    // CAMBIO: Se usa @ModelAttribute para indicar que el objeto 'rol' viene de los datos del formulario.
    public String agregarRol(@ModelAttribute Rol rol, RedirectAttributes redirect) {
        try {
            //log para depurracion para saber si los datos del formularion estan llegando al controlador
            System.out.println("Datos recibidos: cod_rol:" + rol.getCod_rol() + ", nom_rol:" + rol.getNom_rol() + ", des_rol:" + rol.getDes_rol() + ", est_rol:" + rol.getEst_rol());

            // CAMBIO: Se llama al método para agregar del servicio, pasando el objeto completo.
            // Esto mejora la estructura del código (Controlador -> Servicio -> Repositorio).
            rolServicio.agregarRol(rol);

            redirect.addFlashAttribute("mensaje","ROL AGREGADO EXITOSAMENTE");
            return "redirect:/rol";
        } catch (Exception e) {
            redirect.addFlashAttribute("error","Ocurrió un error al agregar: " + e.getMessage());
            return "redirect:/rol";
        }
    }
}
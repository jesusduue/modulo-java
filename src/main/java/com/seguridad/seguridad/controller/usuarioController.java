package com.seguridad.seguridad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.seguridad.seguridad.models.Usuario;
import com.seguridad.seguridad.services.UsuarioServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 

@Controller
public class usuarioController {
    
   //showUsuarioView() es un metodo de controlador en una aplicacion web de spring. su objetivo es manejar las peticiones http get que llegan a la ruta /usuario y devolver el nombre de la vista que debe ser renderizada 
/*    public String showUsuarioView() {
       return "usuario"; // Nombre de la vista a retornar
   } */
   //funcion para listar los usuarios
    
   @Autowired
    private UsuarioServicio usuarioServicio; //se llama los metodos agredados en el serivicio para no llamar al repositorio ya qu este se llama dentro del servicio

    //endpoint para listar
    @GetMapping("/usuario")
    public String UsuarioListar(Model models) {
        List<Usuario> usuarios = usuarioServicio.listar(); //metodo listar en services
        models.addAttribute("usuarios", usuarios);

        //se agrega un nuevo objeto al usuario al modelo
        //se hace de esta manera para que el Formulario del modal Agregar, funcione con thymeleaf (th:object)
        models.addAttribute("usuario" , new Usuario());
        return "usuario";
    }

    //enpoint para agregar 
    @PostMapping("/usuario")
    //se usua @ModelAttribute para indicar que el objeto usuario, viiene de los datos del formulario
    public String agregarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirect) {
        //TODO: process POST request
        try {
            // log para saber si estan llegando los datos desde el formulario
            System.out.println("Datos recibidos: cod_usu:" + usuario.getCod_usu() + ", ali_usu"+ usuario.getAli_usu()  + ", ema_usu"+ usuario.getEma_usu()  + ", cla_usu" + usuario.getCla_usu()  + ", est_usu"+ usuario.getEst_usu());

            // se llama el metodo agregar del servicio pasandole los datos del obejto usuario completo
            usuarioServicio.agregarUsuario(usuario);

            redirect.addFlashAttribute("Usuario registrado Correctamente");
            return "redirect:/usuario";
        } catch (Exception e) {
            redirect.addFlashAttribute("Error al Registrar: " + e.getMessage());
            return "redirect:/usuario";
        }

    }

    //endpoint para eliminar
     @PostMapping("/usuario/eliminar")
    @SuppressWarnings("CallToPrintStackTrace")
    public String eliminarUsuario(@Param("cod_usu") int cod_usu, RedirectAttributes redirect){
       try {
        Usuario usuario = usuarioServicio.buscarPorId(cod_usu);
           if(usuario != null){
            Integer resultado = usuarioServicio.eliminarUsuario(cod_usu);
            System.out.println("resultado eliminar" + resultado);
            redirect.addFlashAttribute("mensaje", "Resultado eliminado con exito");
           }else{
            redirect.addFlashAttribute("error", "Error al eliminar");
           }
       } catch (Exception e) {
            e.printStackTrace();//esto mostrara 
            redirect.addFlashAttribute("error", "Ocurrió un error al eliminar: " + e.getMessage());
       } 
       return "redirect:/usuario";
    }

    //enpoint para modificar
        @PostMapping("/usuario/modificar")
    public String modificarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirect) {
        try {
            Integer resultado = usuarioServicio.modificarUsuario(usuario);
            if (resultado != null) {
                redirect.addFlashAttribute("mensaje", "ROL MODIFICADO EXITOSAMENTE");
            } else {
                redirect.addFlashAttribute("error", "Error al modificar");
            }
        } catch (Exception e) {
            redirect.addFlashAttribute("error", "Ocurrió un error al modificar: " + e.getMessage());
        }
        return "redirect:/usuario";
    }
    
}

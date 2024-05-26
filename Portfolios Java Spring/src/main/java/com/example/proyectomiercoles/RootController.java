package com.example.proyectomiercoles;


import com.example.proyectomiercoles.models.Lenguaje;
import com.example.proyectomiercoles.models.Mensaje;
import com.example.proyectomiercoles.models.Persona;
import com.example.proyectomiercoles.models.Proyecto;
import com.example.proyectomiercoles.services.LenguajeService;
import com.example.proyectomiercoles.services.MensajeService;
import com.example.proyectomiercoles.services.PersonaService;
import com.example.proyectomiercoles.services.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RootController {

    @Autowired
    private LenguajeService lenguajeServicio;

    @Autowired
    private ProyectoService proyectoServicio;

    @Autowired
    private MensajeService mensajeService;

    @Autowired
    private PersonaService personaService;

    /*  No carga el CSS ni las imagenes
    @GetMapping("/{id}")
    public String index(@PathVariable Long id, Model model) {
        //ProyectoMiercolesApplication.id_persona = id;
        List<Proyecto> pros = proyectoServicio.getAllPros();
        model.addAttribute("proyectos", pros);

        List<Lenguaje> lengs = lenguajeServicio.getAllLenguajes();
        model.addAttribute("lenguajes", lengs);

        Persona persona = personaService.getPersona();
        model.addAttribute("persona", persona);
        return "index";
    }


    @PostMapping("/{id}")
    public String prueba(@PathVariable Long id, @RequestParam String email, @RequestParam String asunto, @RequestParam String cuerpo, Model model) {
        //ProyectoMiercolesApplication.id_persona = id;
        List<Proyecto> pros = proyectoServicio.getAllPros();
        model.addAttribute("proyectos", pros);

        List<Lenguaje> lengs = lenguajeServicio.getAllLenguajes();
        model.addAttribute("lenguajes", lengs);

        Persona persona = personaService.getPersona();
        model.addAttribute("persona", persona);
        try {
            Mensaje mensaje = new Mensaje();
            mensaje.setAsunto(asunto);
            mensaje.setCuerpo(cuerpo);
            mensaje.setEmail(email);
            mensaje.setId_persona(persona.getId_persona());
            mensajeService.saveMensaje(mensaje);
            return "index";
        } catch (NumberFormatException nfe) {
            return "index";
        }
    }*/

    @GetMapping("/")
    public String index(/*@PathVariable Long id,*/ Model model) {
        List<Proyecto> pros = proyectoServicio.getAllPros();
        model.addAttribute("proyectos", pros);

        List<Lenguaje> lengs = lenguajeServicio.getAllLenguajes();
        model.addAttribute("lenguajes", lengs);

        Persona persona = personaService.getPersona();
        model.addAttribute("persona", persona);
        return "index";
    }


    @PostMapping("/")
    public String prueba(/*@PathVariable Long id,*/ @RequestParam String email, @RequestParam String asunto, @RequestParam String cuerpo, Model model) {
        List<Proyecto> pros = proyectoServicio.getAllPros();
        model.addAttribute("proyectos", pros);

        List<Lenguaje> lengs = lenguajeServicio.getAllLenguajes();
        model.addAttribute("lenguajes", lengs);

        Persona persona = personaService.getPersona();
        model.addAttribute("persona", persona);
        try {
            Mensaje mensaje = new Mensaje();
            mensaje.setAsunto(asunto);
            mensaje.setCuerpo(cuerpo);
            mensaje.setEmail(email);
            mensaje.setId_persona(persona.getId_persona());
            mensajeService.saveMensaje(mensaje);
            return "index";
        } catch (NumberFormatException nfe) {
            return "index";
        }
    }
}
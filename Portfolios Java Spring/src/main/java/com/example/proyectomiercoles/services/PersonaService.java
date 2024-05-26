package com.example.proyectomiercoles.services;

import com.example.proyectomiercoles.ProyectoMiercolesApplication;
import com.example.proyectomiercoles.models.Persona;
import com.example.proyectomiercoles.reps.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository personaRep;

    public Persona getPersona () {
        return personaRep.findById(ProyectoMiercolesApplication.id_persona).orElse(null);
    }

}

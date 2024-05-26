package com.example.proyectomiercoles.services;

import com.example.proyectomiercoles.models.Mensaje;
import com.example.proyectomiercoles.reps.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeService {
    @Autowired
    private MensajeRepository repositorioMensaje;

    public Mensaje saveMensaje(Mensaje mensaje) {
        return repositorioMensaje.save(mensaje);
    }
}

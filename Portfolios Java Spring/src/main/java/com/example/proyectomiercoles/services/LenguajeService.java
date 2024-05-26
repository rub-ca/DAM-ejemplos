package com.example.proyectomiercoles.services;

import com.example.proyectomiercoles.ProyectoMiercolesApplication;
import com.example.proyectomiercoles.models.Lenguaje;
import com.example.proyectomiercoles.reps.LenguajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LenguajeService {
    @Autowired
    private LenguajeRepository repositorioLenguaje;

    public List<Lenguaje> getAllLenguajes() {
        List<Lenguaje> listaOriginal = repositorioLenguaje.findAll();
        List<Lenguaje> lista = new ArrayList<Lenguaje>();

        for (int x = 0; x < listaOriginal.size(); x++) {
            if (listaOriginal.get(x).getId_persona() == ProyectoMiercolesApplication.id_persona) {
                lista.add(listaOriginal.get(x));
            }
        }

        return lista;
    }


}

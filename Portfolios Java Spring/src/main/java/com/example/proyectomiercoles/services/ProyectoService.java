package com.example.proyectomiercoles.services;

import com.example.proyectomiercoles.ProyectoMiercolesApplication;
import com.example.proyectomiercoles.models.Lenguaje;
import com.example.proyectomiercoles.models.Proyecto;
import com.example.proyectomiercoles.reps.LenguajeRepository;
import com.example.proyectomiercoles.reps.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRep;

    public List<Proyecto> getAllPros() {
        List<Proyecto> listaOriginal = proyectoRep.findAll();
        List<Proyecto> lista = new ArrayList<Proyecto>();

        for (int x = 0; x < listaOriginal.size(); x++) {
            if (listaOriginal.get(x).getId_persona() == ProyectoMiercolesApplication.id_persona) {
                lista.add(listaOriginal.get(x));
            }
        }
        return lista;
    }

}

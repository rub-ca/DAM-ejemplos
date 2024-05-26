package com.example.proyectomiercoles.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "lenguajes")
public class Lenguaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_lenguaje;
    private String nombre;
    private Long nivel;
    private Long id_persona;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "lenguajesUtilizados")
    private List<Proyecto> proyectos = new ArrayList<>();

    public Long getId_lenguaje() {
        return id_lenguaje;
    }

    public void setId_lenguaje(Long id_lenguaje) {
        this.id_lenguaje = id_lenguaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Object> getNivel() {
        ArrayList<Object> retorno = new ArrayList<>();
        for (int x = 0; x < nivel; x++) {
            retorno.add(new Object());
        }
        return retorno;
    }

    public void setNivel(Long nivel) {
        this.nivel = nivel;
    }

    public String getProyectos() {
        String retorno = "Proyectos: ";

        for (Proyecto p : proyectos) {
            retorno += p.getNombre() + " ";
        }
        return retorno;
    }

    public void setProyectos(List<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }
}

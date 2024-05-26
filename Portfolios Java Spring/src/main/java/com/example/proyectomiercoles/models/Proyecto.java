package com.example.proyectomiercoles.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proyectos")
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_proyecto;
    private String nombre;
    private String descripcion;
    private String imagen;
    private String url;

    private Long id_persona;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "relacion",
            joinColumns = @JoinColumn(name = "id_proyecto"), inverseJoinColumns = @JoinColumn(name = "id_lenguaje")
    )
    private List<Lenguaje> lenguajesUtilizados = new ArrayList<>();

    public Long getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(Long id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return "http://" + url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Lenguaje> getLenguajesUtilizados() {
        return lenguajesUtilizados;
    }

    public void setLenguajesUtilizados(List<Lenguaje> lenguajesUtilizados) {
        this.lenguajesUtilizados = lenguajesUtilizados;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }
}

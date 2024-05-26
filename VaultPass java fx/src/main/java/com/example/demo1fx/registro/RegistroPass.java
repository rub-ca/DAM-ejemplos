package com.example.demo1fx.registro;

public class RegistroPass {
    public int id;
    public String nombre;
    public String sitio;
    public String contraCifrada;

    public RegistroPass(int id, String nombre, String sitio, String contra) {
        this.id = id;
        this.nombre = nombre;
        this.sitio = sitio;
        this.contraCifrada = contra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    @Override
    public String toString() {
        return "RegistroPass{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", sitio='" + sitio + '\'' +
                ", contraCifrada='" + contraCifrada + '\'' +
                '}';
    }
}

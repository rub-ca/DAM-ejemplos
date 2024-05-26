package com.example.proyectomiercoles.models;

import jakarta.persistence.*;

@Entity
@Table(name = "mensajes")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_mensaje;

    private String email;
    private String asunto;
    private String cuerpo;

    private Long id_persona;

    public Long getId_mensaje() {
        return id_mensaje;
    }

    public void setId_mensaje(Long id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }
}

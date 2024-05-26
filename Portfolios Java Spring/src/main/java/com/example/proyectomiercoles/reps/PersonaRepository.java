package com.example.proyectomiercoles.reps;

import com.example.proyectomiercoles.models.Lenguaje;
import com.example.proyectomiercoles.models.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository  extends JpaRepository<Persona, Long> {
}

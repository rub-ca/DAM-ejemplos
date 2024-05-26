package com.example.proyectomiercoles.reps;

import com.example.proyectomiercoles.models.Lenguaje;
import com.example.proyectomiercoles.models.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}
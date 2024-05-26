package com.example.proyectomiercoles.reps;

import com.example.proyectomiercoles.models.Lenguaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LenguajeRepository extends JpaRepository<Lenguaje, Long> {
}
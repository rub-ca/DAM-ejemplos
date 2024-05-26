package com.example.proyectomiercoles.reps;

import com.example.proyectomiercoles.models.Lenguaje;
import com.example.proyectomiercoles.models.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProyectoRepository extends JpaRepository<Proyecto, Long> {
}
package com.fondeo.fondeo.repository;

import com.fondeo.fondeo.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepositorio extends JpaRepository<Equipo, Integer> {
}

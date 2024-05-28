package com.fondeo.fondeo.repository;

import com.fondeo.fondeo.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Integer> {
}

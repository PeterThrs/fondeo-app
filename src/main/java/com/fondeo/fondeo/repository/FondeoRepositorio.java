package com.fondeo.fondeo.repository;

import com.fondeo.fondeo.models.Fondeo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FondeoRepositorio extends JpaRepository<Fondeo, Integer> {
}

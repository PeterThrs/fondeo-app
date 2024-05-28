package com.fondeo.fondeo.repository;

import com.fondeo.fondeo.models.Integrante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntegranteRepositorio extends JpaRepository<Integrante, Integer> {

}

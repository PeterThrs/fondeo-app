package com.fondeo.fondeo.repository;

import com.fondeo.fondeo.models.Donativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonativoRepositorio extends JpaRepository<Donativo, Integer> {
}

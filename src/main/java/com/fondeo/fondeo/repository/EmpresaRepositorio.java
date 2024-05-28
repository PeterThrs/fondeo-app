package com.fondeo.fondeo.repository;

import com.fondeo.fondeo.models.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository<Empresa, Integer> {
}

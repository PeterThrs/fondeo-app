package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Integrante;
import com.fondeo.fondeo.repository.IntegranteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegranteService implements IIntegranteService{

    @Autowired
    private IntegranteRepositorio integranteRepositorio;

    @Override
    public List<Integrante> listarIntegrantes() {
        return this.integranteRepositorio.findAll();
    }

    @Override
    public Integrante buscarIntegrantePorId(Integer idIntegrante) {
        return this.integranteRepositorio.findById(idIntegrante).orElse(null);
    }

    @Override
    public Integrante guardarIntegrante(Integrante integrante) {
        return this.integranteRepositorio.save(integrante);
    }

    @Override
    public void eliminarIntegrantePorId(Integer idIntegrante) {
        this.integranteRepositorio.deleteById(idIntegrante);
    }
}

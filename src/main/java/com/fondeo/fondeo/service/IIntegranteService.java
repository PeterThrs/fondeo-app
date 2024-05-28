package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Integrante;

import java.util.List;

public interface IIntegranteService {
    public List<Integrante> listarIntegrantes();
    public Integrante buscarIntegrantePorId(Integer idIntegrante);
    public Integrante guardarIntegrante(Integrante integrante);
    public void eliminarIntegrantePorId(Integer idIntegrante);
}

package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Estado;

import java.util.List;

public interface IEstadoService {
    public List<Estado> listarEstados();
    public Estado buscarEstadoPorId(Integer idEstado);
    public Estado guardarEstado(Estado estado);
    public void eliminarEstadoPorId(Integer idEstado);
}

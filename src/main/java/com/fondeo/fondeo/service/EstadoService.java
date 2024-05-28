package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Estado;
import com.fondeo.fondeo.repository.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoService implements IEstadoService{

    @Autowired
    private EstadoRepositorio estadoRepositorio;

    @Override
    public List<Estado> listarEstados() {
        return this.estadoRepositorio.findAll();
    }

    @Override
    public Estado buscarEstadoPorId(Integer idEstado) {
        return this.estadoRepositorio.findById(idEstado).orElse(null);
    }

    @Override
    public Estado guardarEstado(Estado estado) {
        return this.estadoRepositorio.save(estado);
    }

    @Override
    public void eliminarEstadoPorId(Integer idEstado) {
        this.estadoRepositorio.deleteById(idEstado);
    }
}

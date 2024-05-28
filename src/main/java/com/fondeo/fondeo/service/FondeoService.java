package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Fondeo;
import com.fondeo.fondeo.repository.FondeoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FondeoService implements IFondeoService{

    @Autowired
    private FondeoRepositorio fondeoRepositorio;

    @Override
    public List<Fondeo> listarFondeos() {
        return this.fondeoRepositorio.findAll();
    }

    @Override
    public Fondeo buscarFondeoPorId(Integer idFondeo) {
        return this.fondeoRepositorio.findById(idFondeo).orElse(null);
    }

    @Override
    public Fondeo guardarFondeo(Fondeo fondeo) {
        return this.fondeoRepositorio.save(fondeo);
    }

    @Override
    public void eliminarFondeoPorId(Integer idFondeo) {
        this.fondeoRepositorio.deleteById(idFondeo);
    }
}

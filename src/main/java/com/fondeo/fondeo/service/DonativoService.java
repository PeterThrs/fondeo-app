package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Donativo;
import com.fondeo.fondeo.repository.DonativoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonativoService implements IDonativoService{

    @Autowired
    private DonativoRepositorio donativoRepositorio;

    @Override
    public List<Donativo> listarDonativos() {
        return this.donativoRepositorio.findAll();
    }

    @Override
    public Donativo buscarDonativoPorId(Integer idDonativo) {
        return this.donativoRepositorio.findById(idDonativo).orElse(null);
    }

    @Override
    public Donativo guardarDonativo(Donativo donativo) {
        return this.donativoRepositorio.save(donativo);
    }

    @Override
    public void eliminarDonativoPorId(Integer idDonativo) {
        this.donativoRepositorio.deleteById(idDonativo);
    }
}

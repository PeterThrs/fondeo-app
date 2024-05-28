package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Equipo;
import com.fondeo.fondeo.repository.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService implements IEquipoService{

    @Autowired
    private EquipoRepositorio equipoRepositorio;

    @Override
    public List<Equipo> listarEquipos() {
        return this.equipoRepositorio.findAll();
    }

    @Override
    public Equipo buscarEquipoPorId(Integer idEquipo) {
        return this.equipoRepositorio.findById(idEquipo).orElse(null);
    }

    @Override
    public Equipo guardarEquipo(Equipo equipo) {
        return this.equipoRepositorio.save(equipo);
    }

    @Override
    public void eliminarEquipoPorId(Integer idEquipo) {
        this.equipoRepositorio.deleteById(idEquipo);
    }
}

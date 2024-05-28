package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Equipo;

import java.util.List;

public interface IEquipoService {
    public List<Equipo> listarEquipos();
    public Equipo buscarEquipoPorId(Integer idEquipo);
    public Equipo guardarEquipo(Equipo equipo);
    public void eliminarEquipoPorId(Integer idEquipo);
}

package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Donativo;

import java.util.List;

public interface IDonativoService {
    public List<Donativo> listarDonativos();
    public Donativo buscarDonativoPorId(Integer idDonativo);
    public Donativo guardarDonativo(Donativo donativo);
    public void eliminarDonativoPorId(Integer idDonativo);
}

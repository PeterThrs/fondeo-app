package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Fondeo;

import java.util.List;

public interface IFondeoService {
    public List<Fondeo> listarFondeos();
    public Fondeo buscarFondeoPorId(Integer idFondeo);
    public Fondeo guardarFondeo(Fondeo fondeo);
    public void eliminarFondeoPorId(Integer idFondeo);

}

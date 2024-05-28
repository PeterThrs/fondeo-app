package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Empresa;

import java.util.List;

public interface IEmpresaService {
    public List<Empresa> listarEmpresas();
    public Empresa buscarEmpresaPorId(Integer idEmpresa);
    public Empresa guardarEmpresa(Empresa empresa);
    public void eliminarEmpresaPorId(Integer idEmpresa);
}

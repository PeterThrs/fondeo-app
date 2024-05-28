package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Empresa;
import com.fondeo.fondeo.repository.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpresaService implements IEmpresaService{

    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    @Override
    public List<Empresa> listarEmpresas() {
        return this.empresaRepositorio.findAll();
    }

    @Override
    public Empresa buscarEmpresaPorId(Integer idEmpresa) {
        return this.empresaRepositorio.findById(idEmpresa).orElse(null);
    }

    @Override
    public Empresa guardarEmpresa(Empresa empresa) {
        return this.empresaRepositorio.save(empresa);
    }

    @Override
    public void eliminarEmpresaPorId(Integer idEmpresa) {
        this.empresaRepositorio.deleteById(idEmpresa);
    }
}

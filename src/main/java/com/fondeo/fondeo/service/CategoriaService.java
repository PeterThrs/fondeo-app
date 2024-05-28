package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Categoria;
import com.fondeo.fondeo.repository.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService implements ICategoriaService{

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    @Override
    public List<Categoria> listarCategorias() {
        return this.categoriaRepositorio.findAll();
    }

    @Override
    public Categoria buscarCategoriaPorId(Integer idCategoria) {
        return this.categoriaRepositorio.findById(idCategoria).orElse(null);
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return this.categoriaRepositorio.save(categoria);
    }

    @Override
    public void eliminarCategoriaPorId(Integer idCategoria) {
        this.categoriaRepositorio.deleteById(idCategoria);
    }
}

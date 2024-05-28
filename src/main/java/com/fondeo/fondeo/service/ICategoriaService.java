package com.fondeo.fondeo.service;

import com.fondeo.fondeo.models.Categoria;

import java.util.List;

public interface ICategoriaService {
    public List<Categoria> listarCategorias();
    public Categoria buscarCategoriaPorId(Integer idCategoria);
    public Categoria guardarCategoria(Categoria categoria);
    public void eliminarCategoriaPorId(Integer idCategoria);
}

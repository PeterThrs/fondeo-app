package com.fondeo.fondeo.controllers;

import com.fondeo.fondeo.exceptions.RecursoNoEncontradoException;
import com.fondeo.fondeo.models.Categoria;
import com.fondeo.fondeo.service.CategoriaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("fondeo-app")
@CrossOrigin(value="http://localhost:4200")
public class CategoriaControlador {
    private static final Logger logger = LoggerFactory.getLogger(CategoriaControlador.class);

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<Categoria> obtenerCategorias(){
        logger.info("Entramos a obtener categorias: ");
        List<Categoria> categorias = this.categoriaService.listarCategorias();
        logger.info("Categorias obtenidos: ");
        categorias.forEach( categoria -> logger.info(categoria.toString()));
        return categorias;
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaPorId(@PathVariable int id){
        Categoria categoria = this.categoriaService.buscarCategoriaPorId(id);
        if(categoria != null) {
            return ResponseEntity.ok(categoria);
        } else {
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
    }

    @PostMapping(path = "/categorias")
    public ResponseEntity<Categoria> agregarDepartamento(@RequestBody Categoria categoria){
        logger.info("Departamento a agregar: " + categoria);
        return ResponseEntity.ok(this.categoriaService.guardarCategoria(categoria));
    }

    @PutMapping(path = "/categorias/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable int id, @RequestBody Categoria categoriaRecibida){
        Categoria categoria = this.categoriaService.buscarCategoriaPorId(id);
        if(categoria == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        categoria.setNombre(categoriaRecibida.getNombre());

        this.categoriaService.guardarCategoria(categoria);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCategoria(@PathVariable int id){
        Categoria categoria = this.categoriaService.buscarCategoriaPorId(id);
        if(categoria == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        this.categoriaService.eliminarCategoriaPorId(categoria.getIdCategoria());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }
}

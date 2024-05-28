package com.fondeo.fondeo.controllers;

import com.fondeo.fondeo.exceptions.RecursoNoEncontradoException;
import com.fondeo.fondeo.models.Estado;
import com.fondeo.fondeo.service.EstadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//http:/localhost:8080/fondeo-app
@RequestMapping("fondeo-app")
//configuramos para que angular pueda realizar peticiones a nuestro backend
@CrossOrigin(value="http://localhost:4200")
public class EstadoControlador {

    private static final Logger logger = LoggerFactory.getLogger(EstadoControlador.class);

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/estados")
    public List<Estado> obtenerUsuarios(){
        List<Estado> estados = this.estadoService.listarEstados();
        logger.info("Estados obtenidos: ");
        estados.forEach( estado -> logger.info(estado.toString()));
        return estados;
    }

    @GetMapping("/estados/{id}")
    public ResponseEntity<Estado> obtenerDepartamentoPorId(@PathVariable int id){
        Estado estado = this.estadoService.buscarEstadoPorId(id);
        if(estado != null) {
            return ResponseEntity.ok(estado);
        } else {
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
    }

    @PostMapping(path = "/estados", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estado> agregarDepartamento(@RequestBody Estado departamento){
        logger.info("Departamento a agregar: " + departamento);
        return ResponseEntity.ok(this.estadoService.guardarEstado(departamento));
    }

    @PutMapping(path = "/estados/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Estado> actualizarDepartamento(@PathVariable int id, @RequestBody Estado estadoRecibido){
        Estado estado = this.estadoService.buscarEstadoPorId(id);
        if(estado == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        estado.setNombre(estadoRecibido.getNombre());

        this.estadoService.guardarEstado(estado);
        return ResponseEntity.ok(estado);
    }

    @DeleteMapping("/estados/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarDepartamento(@PathVariable int id){
        Estado estado = this.estadoService.buscarEstadoPorId(id);
        if(estado == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        this.estadoService.eliminarEstadoPorId(estado.getIdEstado());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

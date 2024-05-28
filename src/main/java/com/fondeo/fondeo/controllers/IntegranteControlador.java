package com.fondeo.fondeo.controllers;

import com.fondeo.fondeo.exceptions.RecursoNoEncontradoException;
import com.fondeo.fondeo.models.Estado;
import com.fondeo.fondeo.models.Integrante;
import com.fondeo.fondeo.service.EstadoService;
import com.fondeo.fondeo.service.IntegranteService;
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
public class IntegranteControlador {

    private static final Logger logger = LoggerFactory.getLogger(IntegranteControlador.class);

    @Autowired
    private IntegranteService integranteService;

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/integrantes")
    public List<Integrante> obtenerIntegrantes(){
        logger.info("Entramos a obtener categorias: ");
        List<Integrante> integrantes = this.integranteService.listarIntegrantes();
        logger.info("Categorias obtenidos: ");
        integrantes.forEach( integrante -> logger.info(integrante.toString()));
        return integrantes;
    }

    @GetMapping("/integrantes/{id}")
    public ResponseEntity<Integrante> obtenerIntegrantePorId(@PathVariable int id){
        Integrante integrante = this.integranteService.buscarIntegrantePorId(id);
        if(integrante != null) {
            return ResponseEntity.ok(integrante);
        } else {
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
    }

    @PostMapping(path = "/integrantes")
    public ResponseEntity<Integrante> agregarIntegrante(@RequestBody Integrante integrante){
        logger.info("Departamento a agregar: " + integrante);
        return ResponseEntity.ok(this.integranteService.guardarIntegrante(integrante));
    }

    @PutMapping(path = "/integrantes/{id}")
    public ResponseEntity<Integrante> actualizarIntegrante(@PathVariable int id, @RequestBody Integrante integranteRecibido){
        Integrante integrante = this.integranteService.buscarIntegrantePorId(id);
        if(integrante == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        integrante.setNombre(integranteRecibido.getNombre());
        integrante.setContrasenia(integranteRecibido.getContrasenia());
        integrante.setEmail(integranteRecibido.getEmail());
        integrante.setTelefono(integranteRecibido.getTelefono());
        integrante.setCurp(integranteRecibido.getCurp());
        Estado estado = estadoService.buscarEstadoPorId(integranteRecibido.getEstado().getIdEstado());
        if(estado != null) integrante.setEstado(integranteRecibido.getEstado());
        integrante.setEstado(integranteRecibido.getEstado());

        this.integranteService.guardarIntegrante(integrante);
        return ResponseEntity.ok(integrante);
    }

    @DeleteMapping("/integrantes/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarIntegrante(@PathVariable int id){
        Integrante integrante = this.integranteService.buscarIntegrantePorId(id);
        if(integrante == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        this.integranteService.eliminarIntegrantePorId(integrante.getIdUsuario());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

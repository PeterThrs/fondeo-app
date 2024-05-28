package com.fondeo.fondeo.controllers;

import com.fondeo.fondeo.exceptions.RecursoNoEncontradoException;
import com.fondeo.fondeo.models.Equipo;
import com.fondeo.fondeo.models.Integrante;
import com.fondeo.fondeo.service.EquipoService;
import com.fondeo.fondeo.service.IntegranteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("fondeo-app")
@CrossOrigin(value="http://localhost:4200")
public class EquipoControlador {

    private static final Logger logger = LoggerFactory.getLogger(EstadoControlador.class);

    @Autowired
    private EquipoService equipoService;

    @Autowired
    private IntegranteService integranteService;


    @GetMapping("/equipos")
    public List<Equipo> obtenerEquipos(){
        logger.info("Entramos a obtener empresas: ");
        List<Equipo> equipos = this.equipoService.listarEquipos();
        logger.info("Equipoas obtenidos: ");
        equipos.forEach( equipo -> logger.info(equipo.toString()));
        return equipos;
    }

    @GetMapping("/equipos/{id}")
    public ResponseEntity<Equipo> obtenerEquipoPorId(@PathVariable int id){
        Equipo equipo = this.equipoService.buscarEquipoPorId(id);
        if(equipo != null) {
            return ResponseEntity.ok(equipo);
        } else {
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
    }

    @PostMapping(path = "/equipos")
    public ResponseEntity<Equipo> agregarEquipo(@RequestBody Equipo equipoRecibido){
        logger.info("Departamento a agregar: " + equipoRecibido);
        Set<Integrante> int_equipo= equipoRecibido.getIntegrantes();
        List<Integrante> inte_activos = this.integranteService.listarIntegrantes();

        Set<Integrante> activosSet = new HashSet<>(inte_activos);
        // Usamos un iterador para eliminar elementos mientras iteramos
        int_equipo.removeIf(integrante -> !activosSet.contains(integrante));
        //puros integrantes dados de alta
        equipoRecibido.setIntegrantes(int_equipo);
        return ResponseEntity.ok(this.equipoService.guardarEquipo(equipoRecibido));
    }

    @PutMapping(path = "/equipos/{id}")
    public ResponseEntity<Equipo> actualizarEquipo(@PathVariable int id, @RequestBody Equipo equipoRecibido){
        Equipo equipo = this.equipoService.buscarEquipoPorId(id);
        if(equipo == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        equipo.setNombre(equipoRecibido.getNombre());
        Set<Integrante> int_equipo= equipoRecibido.getIntegrantes();
        List<Integrante> inte_activos = this.integranteService.listarIntegrantes();

        Set<Integrante> activosSet = new HashSet<>(inte_activos);
        // Usamos un iterador para eliminar elementos mientras iteramos
        int_equipo.removeIf(integrante -> !activosSet.contains(integrante));
        //puros integrantes dados de alta
        equipo.setIntegrantes(int_equipo);

        this.equipoService.guardarEquipo(equipo);
        return ResponseEntity.ok(equipo);
    }

    @DeleteMapping("/equipos/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEquipo(@PathVariable int id){
        Equipo equipo = this.equipoService.buscarEquipoPorId(id);
        if(equipo == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        this.equipoService.eliminarEquipoPorId(equipo.getIdEquipo());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

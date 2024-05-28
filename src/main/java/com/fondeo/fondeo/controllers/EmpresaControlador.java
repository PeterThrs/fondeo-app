package com.fondeo.fondeo.controllers;

import com.fondeo.fondeo.exceptions.RecursoNoEncontradoException;
import com.fondeo.fondeo.models.Empresa;
import com.fondeo.fondeo.models.Estado;
import com.fondeo.fondeo.service.EmpresaService;
import com.fondeo.fondeo.service.EstadoService;
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
public class EmpresaControlador {

    private static final Logger logger = LoggerFactory.getLogger(EstadoControlador.class);

    @Autowired
    private EmpresaService empresaService;

    @Autowired
    private EstadoService estadoService;

    @GetMapping("/empresas")
    public List<Empresa> obtenerEmpresas(){
        logger.info("Entramos a obtener empresas: ");
        List<Empresa> empresas = this.empresaService.listarEmpresas();
        logger.info("Empresas obtenidos: ");
        empresas.forEach( emp -> logger.info(emp.toString()));
        return empresas;
    }

    @GetMapping("/empresas/{id}")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable int id){
        Empresa empresa = this.empresaService.buscarEmpresaPorId(id);
        if(empresa != null) {
            return ResponseEntity.ok(empresa);
        } else {
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
    }

    @PostMapping(path = "/empresas")
    public ResponseEntity<Empresa> agregarEmpresa(@RequestBody Empresa empresa){
        logger.info("Departamento a agregar: " + empresa);
        return ResponseEntity.ok(this.empresaService.guardarEmpresa(empresa));
    }

    @PutMapping(path = "/empresas/{id}")
    public ResponseEntity<Empresa> actualizarEmpresa(@PathVariable int id, @RequestBody Empresa empresaRecibida){
        Empresa empresa = this.empresaService.buscarEmpresaPorId(id);
        if(empresa == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        empresa.setNombre(empresaRecibida.getNombre());
        empresa.setContrasenia(empresaRecibida.getContrasenia());
        empresa.setEmail(empresaRecibida.getEmail());
        empresa.setTelefono(empresaRecibida.getTelefono());
        Estado estado = estadoService.buscarEstadoPorId(empresaRecibida.getEstado().getIdEstado());
        if(estado != null) empresa.setEstado(empresaRecibida.getEstado());
        empresa.setRfc(empresaRecibida.getRfc());

        this.empresaService.guardarEmpresa(empresa);
        return ResponseEntity.ok(empresa);
    }

    @DeleteMapping("/empresas/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarEmpresa(@PathVariable int id){
        Empresa empresa = this.empresaService.buscarEmpresaPorId(id);
        if(empresa == null){
            throw new RecursoNoEncontradoException("No se encontro el id: " + id);
        }
        this.empresaService.eliminarEmpresaPorId(empresa.getIdUsuario());
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminado", Boolean.TRUE);
        return ResponseEntity.ok(respuesta);
    }

}

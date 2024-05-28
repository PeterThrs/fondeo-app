package com.fondeo.fondeo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "idUsuario")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Integrante extends Usuario{

    private String curp;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "integrantes", cascade = CascadeType.MERGE)
    private Set<Equipo> equipos = new HashSet<>();

}

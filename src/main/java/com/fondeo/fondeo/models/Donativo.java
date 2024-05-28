package com.fondeo.fondeo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDonativo;

    private Date fecha;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_usuario", referencedColumnName = "idUsuario")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_fondeo", referencedColumnName = "idFondeo")
    private Fondeo fondeo;
    private Double cantidad;


}

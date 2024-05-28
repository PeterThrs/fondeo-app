package com.fondeo.fondeo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Blob;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;
    private String nombre;
    private String contrasenia;
    private String email;
    private String telefono;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_estado", referencedColumnName = "idEstado")
    private Estado estado;

    @Lob
    private Blob imgUsuario;


}

package com.fondeo.fondeo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fondeo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFondeo;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_categoria", referencedColumnName = "idCategoria")
    private Categoria categoria;

}

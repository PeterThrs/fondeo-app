package com.fondeo.fondeo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estado {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstado;
    private String nombre;

}

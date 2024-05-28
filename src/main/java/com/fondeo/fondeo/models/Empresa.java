package com.fondeo.fondeo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@PrimaryKeyJoinColumn(name = "idUsuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends Usuario{
    private String rfc;
}

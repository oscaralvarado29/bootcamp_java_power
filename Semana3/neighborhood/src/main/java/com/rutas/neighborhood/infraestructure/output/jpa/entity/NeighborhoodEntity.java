package com.rutas.neighborhood.infraestructure.output.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "neighborhood")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NeighborhoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long neighborhoodId;
    private String neighborhoodName;
    private String neighborhoodDescription;
}

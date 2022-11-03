package com.rutas.conductor.creacion_de_rutas.infraestructure.output.jpa.entity;

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
@Table(name = "routeneighborhood")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteNeighborhoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeNeighborhoodId;
    private Long routeId;
    private Long neighborhoodId;
    private String meetingPoint;
    private Integer position;
}

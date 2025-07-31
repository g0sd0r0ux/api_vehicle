package com.prueba.vehicle.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder(value={"id", "licensePlate", "model", "delivering", "capacityKg", "trouble", "shipments", "actions"})
public class VehicleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licensePlate;
    private String model;
    private Integer capacityKg; // Capacidad en kilogramos
    private Boolean delivering;
    private Boolean trouble;
    
    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"vehicle"})
    private Set<ActionModel> actions = new HashSet<>();

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = {"vehicle"})
    private Set<ShipmentModel> shipments = new HashSet<>();

}

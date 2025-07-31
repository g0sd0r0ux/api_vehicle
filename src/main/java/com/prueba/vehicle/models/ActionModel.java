package com.prueba.vehicle.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shipmentId;
    private String type;
    private String description;
    private LocalDateTime startedDate;
    
    // No sería tan necesario agregar un fetch type, ya que, no obtiene una lista de objetos, sino que es un único objeto
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"actions"})
    private UserModel user;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @JsonIgnoreProperties(value = {"actions"})
    private VehicleModel vehicle;


}

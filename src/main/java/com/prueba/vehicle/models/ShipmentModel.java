package com.prueba.vehicle.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "shipments")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String trackerNumber;
    private String origin;
    private String destination;
    private Double weight;
    private LocalDateTime startedDate;
    private LocalDateTime estimatedDate;
    private LocalDateTime arrivalDate;
    private ShipmentStatus status;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    @JsonIgnoreProperties(value = {"sh"})
    private VehicleModel vehicle;

    @OneToMany(mappedBy = "shipment", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("shipment")
    private Set<ReviewModel> reviews = new HashSet<>();

    public enum ShipmentStatus {
        PENDING, IN_TRANSIT, DELIVERED, CANCELLED 
    }

}

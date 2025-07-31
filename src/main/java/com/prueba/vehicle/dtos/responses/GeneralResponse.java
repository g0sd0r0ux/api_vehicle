package com.prueba.vehicle.dtos.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = {"message", "status", "data"})
public record GeneralResponse(
    String message,
    int status,
    Object data
) {

}

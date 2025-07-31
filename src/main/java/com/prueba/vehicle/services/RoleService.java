package com.prueba.vehicle.services;

import org.springframework.http.ResponseEntity;

import com.prueba.vehicle.dtos.request.RoleRequest;
import com.prueba.vehicle.dtos.responses.GeneralResponse;

public interface RoleService {

    ResponseEntity<GeneralResponse> createRole(RoleRequest role);

}

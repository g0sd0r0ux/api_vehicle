package com.prueba.vehicle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.vehicle.dtos.request.RoleRequest;
import com.prueba.vehicle.helpers.ResponseHelper;
import com.prueba.vehicle.services.RoleService;

@RestController
@RequestMapping(value = "/v1/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;    

    @PostMapping(value = "/create")
    public ResponseEntity<?> createRole(@RequestBody RoleRequest role, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return ResponseHelper.badRequest("There are errors in the request", ResponseHelper.buildErrorFields(bindingResult));
        }
        return roleService.createRole(role);
    }

}

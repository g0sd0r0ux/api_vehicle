package com.prueba.vehicle.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.vehicle.dtos.request.RoleRequest;
import com.prueba.vehicle.dtos.responses.GeneralResponse;
import com.prueba.vehicle.helpers.ResponseHelper;
import com.prueba.vehicle.models.RoleModel;
import com.prueba.vehicle.repositories.RoleRepository;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public ResponseEntity<GeneralResponse> createRole(RoleRequest role) {
        String roleName = role.getName();
        Optional<RoleModel> roleOptional = roleRepository.findByName(roleName);
        if(roleOptional.isPresent()) {
            return ResponseHelper.badRequest("The role already exists", null);
        }
        // Guardamos el role en caso de que no exista
        RoleModel createRole = new RoleModel();
        createRole.setName(roleName);
        createRole = roleRepository.save(createRole);
        return ResponseHelper.ok("The role has been created", createRole);
    }

}

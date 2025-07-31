package com.prueba.vehicle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prueba.vehicle.models.RoleModel;
import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long> {
    
    // Creamos consultas personalizadas
    Optional<RoleModel> findByName(String name);

}

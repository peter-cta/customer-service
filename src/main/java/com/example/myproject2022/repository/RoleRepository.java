package com.example.myproject2022.repository;

import com.example.myproject2022.entity.RolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RolesEntity, Integer> {

    RolesEntity findByName(String name);
}
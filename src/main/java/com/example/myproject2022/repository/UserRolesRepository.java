package com.example.myproject2022.repository;

import com.example.myproject2022.entity.UsersRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRolesRepository extends JpaRepository<UsersRoleEntity, Integer> {
}

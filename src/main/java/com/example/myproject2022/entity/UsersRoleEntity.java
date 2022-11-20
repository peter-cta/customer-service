package com.example.myproject2022.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "users_role", schema = "example", catalog = "")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "role_id")
    private int roleId;
    @Basic
    @Column(name = "user_id")
    private int userId;
}

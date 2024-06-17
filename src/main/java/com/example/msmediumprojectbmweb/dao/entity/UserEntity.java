package com.example.msmediumprojectbmweb.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String mail;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="profile_id")
    private ProfileEntity profile;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<BlogEntity> blogs;
}

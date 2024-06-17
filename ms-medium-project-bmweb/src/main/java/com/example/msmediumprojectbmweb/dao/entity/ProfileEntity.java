package com.example.msmediumprojectbmweb.dao.entity;

import com.example.msmediumprojectbmweb.enums.Profession;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "profiles")
public class ProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String surname;
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Profession profession;

//    @OneToOne(mappedBy = "profile")
//    private UserEntity user;

}

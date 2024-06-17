package com.example.msmediumprojectbmweb.model;

import com.example.msmediumprojectbmweb.enums.Profession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequestDto {

    private String id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private Profession profession;

}

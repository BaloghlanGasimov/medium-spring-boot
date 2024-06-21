package com.example.msmediumprojectbmweb.model;

import com.example.msmediumprojectbmweb.enums.Profession;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponseDto {

    private String id;
    private String name;
    private String surname;
    private Integer age;
    private Profession profession;

}

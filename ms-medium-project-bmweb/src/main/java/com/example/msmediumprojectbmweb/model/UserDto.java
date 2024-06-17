package com.example.msmediumprojectbmweb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String id;
    private String mail;
    private String password;
    private ProfileResponseDto profile;

}

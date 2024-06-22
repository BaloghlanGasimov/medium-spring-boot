package com.example.msmediumprojectbmweb.model;

import com.example.msmediumprojectbmweb.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private String id;
    private CategoryType category;
    private String description;

}

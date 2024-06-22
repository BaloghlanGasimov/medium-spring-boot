package com.example.msmediumprojectbmweb.dao.entity;

import com.example.msmediumprojectbmweb.enums.CategoryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private CategoryType category;
    private String description;

}

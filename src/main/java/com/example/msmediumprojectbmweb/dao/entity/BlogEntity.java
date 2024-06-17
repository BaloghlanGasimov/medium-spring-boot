package com.example.msmediumprojectbmweb.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "blog")
public class BlogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String title;
    private Integer views;

}

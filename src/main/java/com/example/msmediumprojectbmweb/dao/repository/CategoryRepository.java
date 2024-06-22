package com.example.msmediumprojectbmweb.dao.repository;

import com.example.msmediumprojectbmweb.dao.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,String> {
}

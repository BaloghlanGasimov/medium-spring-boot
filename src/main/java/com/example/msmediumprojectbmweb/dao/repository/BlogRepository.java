package com.example.msmediumprojectbmweb.dao.repository;

import com.example.msmediumprojectbmweb.dao.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity,String> {
}

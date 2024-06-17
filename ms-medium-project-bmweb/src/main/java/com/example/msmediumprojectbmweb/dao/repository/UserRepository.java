package com.example.msmediumprojectbmweb.dao.repository;

import com.example.msmediumprojectbmweb.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,String> {
}

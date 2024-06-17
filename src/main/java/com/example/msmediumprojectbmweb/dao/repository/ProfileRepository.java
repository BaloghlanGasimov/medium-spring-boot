package com.example.msmediumprojectbmweb.dao.repository;

import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity,String> {
}

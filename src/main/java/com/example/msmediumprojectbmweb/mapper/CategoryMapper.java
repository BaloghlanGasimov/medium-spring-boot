package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.CategoryEntity;
import com.example.msmediumprojectbmweb.model.CategoryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryEntity mapToEntity(CategoryDto categoryDto);
    CategoryDto mapToDto(CategoryEntity categoryEntity);

}

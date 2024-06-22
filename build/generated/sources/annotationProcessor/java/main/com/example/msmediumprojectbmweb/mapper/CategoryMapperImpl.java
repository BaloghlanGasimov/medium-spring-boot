package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.CategoryEntity;
import com.example.msmediumprojectbmweb.model.CategoryDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-22T14:33:01+0400",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2.1 (Amazon.com Inc.)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryEntity mapToEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( categoryDto.getId() );
        categoryEntity.setCategory( categoryDto.getCategory() );
        categoryEntity.setDescription( categoryDto.getDescription() );

        return categoryEntity;
    }

    @Override
    public CategoryDto mapToDto(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( categoryEntity.getId() );
        categoryDto.setCategory( categoryEntity.getCategory() );
        categoryDto.setDescription( categoryEntity.getDescription() );

        return categoryDto;
    }
}

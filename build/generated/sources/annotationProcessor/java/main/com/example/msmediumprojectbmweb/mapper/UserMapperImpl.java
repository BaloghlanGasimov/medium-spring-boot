package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.BlogEntity;
import com.example.msmediumprojectbmweb.dao.entity.CategoryEntity;
import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import com.example.msmediumprojectbmweb.dao.entity.UserEntity;
import com.example.msmediumprojectbmweb.model.BlogDto;
import com.example.msmediumprojectbmweb.model.CategoryDto;
import com.example.msmediumprojectbmweb.model.ProfileRequestDto;
import com.example.msmediumprojectbmweb.model.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-22T14:33:01+0400",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2.1 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity mapToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( userDto.getId() );
        userEntity.setMail( userDto.getMail() );
        userEntity.setPassword( userDto.getPassword() );
        userEntity.setProfile( profileRequestDtoToProfileEntity( userDto.getProfile() ) );
        userEntity.setCategories( categoryDtoListToCategoryEntityList( userDto.getCategories() ) );
        userEntity.setBlogs( blogDtoListToBlogEntityList( userDto.getBlogs() ) );

        return userEntity;
    }

    @Override
    public UserDto mapToDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( userEntity.getId() );
        userDto.setMail( userEntity.getMail() );
        userDto.setPassword( userEntity.getPassword() );
        userDto.setProfile( profileEntityToProfileRequestDto( userEntity.getProfile() ) );
        userDto.setCategories( categoryEntityListToCategoryDtoList( userEntity.getCategories() ) );
        userDto.setBlogs( blogEntityListToBlogDtoList( userEntity.getBlogs() ) );

        return userDto;
    }

    protected ProfileEntity profileRequestDtoToProfileEntity(ProfileRequestDto profileRequestDto) {
        if ( profileRequestDto == null ) {
            return null;
        }

        ProfileEntity profileEntity = new ProfileEntity();

        profileEntity.setId( profileRequestDto.getId() );
        profileEntity.setName( profileRequestDto.getName() );
        profileEntity.setSurname( profileRequestDto.getSurname() );
        profileEntity.setBirthDate( profileRequestDto.getBirthDate() );
        profileEntity.setProfession( profileRequestDto.getProfession() );

        return profileEntity;
    }

    protected CategoryEntity categoryDtoToCategoryEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        CategoryEntity categoryEntity = new CategoryEntity();

        categoryEntity.setId( categoryDto.getId() );
        categoryEntity.setCategory( categoryDto.getCategory() );
        categoryEntity.setDescription( categoryDto.getDescription() );

        return categoryEntity;
    }

    protected List<CategoryEntity> categoryDtoListToCategoryEntityList(List<CategoryDto> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryEntity> list1 = new ArrayList<CategoryEntity>( list.size() );
        for ( CategoryDto categoryDto : list ) {
            list1.add( categoryDtoToCategoryEntity( categoryDto ) );
        }

        return list1;
    }

    protected BlogEntity blogDtoToBlogEntity(BlogDto blogDto) {
        if ( blogDto == null ) {
            return null;
        }

        BlogEntity blogEntity = new BlogEntity();

        blogEntity.setId( blogDto.getId() );
        blogEntity.setTitle( blogDto.getTitle() );
        blogEntity.setViews( blogDto.getViews() );

        return blogEntity;
    }

    protected List<BlogEntity> blogDtoListToBlogEntityList(List<BlogDto> list) {
        if ( list == null ) {
            return null;
        }

        List<BlogEntity> list1 = new ArrayList<BlogEntity>( list.size() );
        for ( BlogDto blogDto : list ) {
            list1.add( blogDtoToBlogEntity( blogDto ) );
        }

        return list1;
    }

    protected ProfileRequestDto profileEntityToProfileRequestDto(ProfileEntity profileEntity) {
        if ( profileEntity == null ) {
            return null;
        }

        ProfileRequestDto profileRequestDto = new ProfileRequestDto();

        profileRequestDto.setId( profileEntity.getId() );
        profileRequestDto.setName( profileEntity.getName() );
        profileRequestDto.setSurname( profileEntity.getSurname() );
        profileRequestDto.setBirthDate( profileEntity.getBirthDate() );
        profileRequestDto.setProfession( profileEntity.getProfession() );

        return profileRequestDto;
    }

    protected CategoryDto categoryEntityToCategoryDto(CategoryEntity categoryEntity) {
        if ( categoryEntity == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setId( categoryEntity.getId() );
        categoryDto.setCategory( categoryEntity.getCategory() );
        categoryDto.setDescription( categoryEntity.getDescription() );

        return categoryDto;
    }

    protected List<CategoryDto> categoryEntityListToCategoryDtoList(List<CategoryEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryDto> list1 = new ArrayList<CategoryDto>( list.size() );
        for ( CategoryEntity categoryEntity : list ) {
            list1.add( categoryEntityToCategoryDto( categoryEntity ) );
        }

        return list1;
    }

    protected BlogDto blogEntityToBlogDto(BlogEntity blogEntity) {
        if ( blogEntity == null ) {
            return null;
        }

        BlogDto blogDto = new BlogDto();

        blogDto.setId( blogEntity.getId() );
        blogDto.setTitle( blogEntity.getTitle() );
        blogDto.setViews( blogEntity.getViews() );

        return blogDto;
    }

    protected List<BlogDto> blogEntityListToBlogDtoList(List<BlogEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<BlogDto> list1 = new ArrayList<BlogDto>( list.size() );
        for ( BlogEntity blogEntity : list ) {
            list1.add( blogEntityToBlogDto( blogEntity ) );
        }

        return list1;
    }
}

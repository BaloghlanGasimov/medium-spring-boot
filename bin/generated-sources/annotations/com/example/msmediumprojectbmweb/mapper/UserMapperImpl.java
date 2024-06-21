package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.BlogEntity;
import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import com.example.msmediumprojectbmweb.dao.entity.UserEntity;
import com.example.msmediumprojectbmweb.model.BlogDto;
import com.example.msmediumprojectbmweb.model.ProfileRequestDto;
import com.example.msmediumprojectbmweb.model.UserDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T16:06:52+0400",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserEntity mapToEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setBlogs( blogDtoListToBlogEntityList( userDto.getBlogs() ) );
        userEntity.setId( userDto.getId() );
        userEntity.setMail( userDto.getMail() );
        userEntity.setPassword( userDto.getPassword() );
        userEntity.setProfile( profileRequestDtoToProfileEntity( userDto.getProfile() ) );

        return userEntity;
    }

    @Override
    public UserDto mapToDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setBlogs( blogEntityListToBlogDtoList( userEntity.getBlogs() ) );
        userDto.setId( userEntity.getId() );
        userDto.setMail( userEntity.getMail() );
        userDto.setPassword( userEntity.getPassword() );
        userDto.setProfile( profileEntityToProfileRequestDto( userEntity.getProfile() ) );

        return userDto;
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

    protected ProfileEntity profileRequestDtoToProfileEntity(ProfileRequestDto profileRequestDto) {
        if ( profileRequestDto == null ) {
            return null;
        }

        ProfileEntity profileEntity = new ProfileEntity();

        profileEntity.setBirthDate( profileRequestDto.getBirthDate() );
        profileEntity.setId( profileRequestDto.getId() );
        profileEntity.setName( profileRequestDto.getName() );
        profileEntity.setProfession( profileRequestDto.getProfession() );
        profileEntity.setSurname( profileRequestDto.getSurname() );

        return profileEntity;
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

    protected ProfileRequestDto profileEntityToProfileRequestDto(ProfileEntity profileEntity) {
        if ( profileEntity == null ) {
            return null;
        }

        ProfileRequestDto profileRequestDto = new ProfileRequestDto();

        profileRequestDto.setBirthDate( profileEntity.getBirthDate() );
        profileRequestDto.setId( profileEntity.getId() );
        profileRequestDto.setName( profileEntity.getName() );
        profileRequestDto.setProfession( profileEntity.getProfession() );
        profileRequestDto.setSurname( profileEntity.getSurname() );

        return profileRequestDto;
    }
}

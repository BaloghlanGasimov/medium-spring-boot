package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import com.example.msmediumprojectbmweb.dao.entity.UserEntity;
import com.example.msmediumprojectbmweb.model.ProfileResponseDto;
import com.example.msmediumprojectbmweb.model.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T17:21:09+0400",
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
        userEntity.setProfile( profileResponseDtoToProfileEntity( userDto.getProfile() ) );

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
        userDto.setProfile( profileEntityToProfileResponseDto( userEntity.getProfile() ) );

        return userDto;
    }

    protected ProfileEntity profileResponseDtoToProfileEntity(ProfileResponseDto profileResponseDto) {
        if ( profileResponseDto == null ) {
            return null;
        }

        ProfileEntity profileEntity = new ProfileEntity();

        profileEntity.setId( profileResponseDto.getId() );
        profileEntity.setName( profileResponseDto.getName() );
        profileEntity.setSurname( profileResponseDto.getSurname() );
        profileEntity.setProfession( profileResponseDto.getProfession() );

        return profileEntity;
    }

    protected ProfileResponseDto profileEntityToProfileResponseDto(ProfileEntity profileEntity) {
        if ( profileEntity == null ) {
            return null;
        }

        ProfileResponseDto profileResponseDto = new ProfileResponseDto();

        profileResponseDto.setId( profileEntity.getId() );
        profileResponseDto.setName( profileEntity.getName() );
        profileResponseDto.setSurname( profileEntity.getSurname() );
        profileResponseDto.setProfession( profileEntity.getProfession() );

        return profileResponseDto;
    }
}

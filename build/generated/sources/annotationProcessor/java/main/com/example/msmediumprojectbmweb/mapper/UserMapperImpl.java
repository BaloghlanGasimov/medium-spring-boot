package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import com.example.msmediumprojectbmweb.dao.entity.UserEntity;
import com.example.msmediumprojectbmweb.model.ProfileRequestDto;
import com.example.msmediumprojectbmweb.model.UserDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T14:20:53+0400",
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
}

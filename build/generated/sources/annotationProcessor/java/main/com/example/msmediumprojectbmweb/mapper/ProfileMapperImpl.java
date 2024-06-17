package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import com.example.msmediumprojectbmweb.model.ProfileRequestDto;
import com.example.msmediumprojectbmweb.model.ProfileResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-17T17:21:09+0400",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2.1 (Amazon.com Inc.)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public ProfileEntity mapToEntity(ProfileResponseDto profileResponseDto) {
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

    @Override
    public ProfileEntity mapToEntity(ProfileRequestDto profileRequestDto) {
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

    @Override
    public ProfileRequestDto mapToReqDto(ProfileEntity profileEntity) {
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

    @Override
    public ProfileResponseDto mapToRespDto(ProfileEntity profileEntity) {
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

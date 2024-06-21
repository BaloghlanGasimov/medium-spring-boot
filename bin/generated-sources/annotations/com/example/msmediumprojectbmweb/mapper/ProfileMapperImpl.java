package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import com.example.msmediumprojectbmweb.model.ProfileRequestDto;
import com.example.msmediumprojectbmweb.model.ProfileResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T16:06:52+0400",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
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
        profileEntity.setProfession( profileResponseDto.getProfession() );
        profileEntity.setSurname( profileResponseDto.getSurname() );

        return profileEntity;
    }

    @Override
    public ProfileEntity mapToEntity(ProfileRequestDto profileRequestDto) {
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

    @Override
    public ProfileRequestDto mapToReqDto(ProfileEntity profileEntity) {
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

    @Override
    public ProfileResponseDto mapToRespDto(ProfileEntity profileEntity) {
        if ( profileEntity == null ) {
            return null;
        }

        ProfileResponseDto profileResponseDto = new ProfileResponseDto();

        profileResponseDto.setAge( dateToAge( profileEntity ) );
        profileResponseDto.setId( profileEntity.getId() );
        profileResponseDto.setName( profileEntity.getName() );
        profileResponseDto.setProfession( profileEntity.getProfession() );
        profileResponseDto.setSurname( profileEntity.getSurname() );

        return profileResponseDto;
    }
}

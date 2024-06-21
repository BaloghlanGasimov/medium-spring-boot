package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import com.example.msmediumprojectbmweb.model.ProfileRequestDto;
import com.example.msmediumprojectbmweb.model.ProfileResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.Period;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileEntity mapToEntity(ProfileResponseDto profileResponseDto);

    //    @Mapping(source = "age")
    ProfileEntity mapToEntity(ProfileRequestDto profileRequestDto);

    ProfileRequestDto mapToReqDto(ProfileEntity profileEntity);

    @Mapping(target = "age", source = "profileEntity", qualifiedByName = "dateToAge")
    ProfileResponseDto mapToRespDto(ProfileEntity profileEntity);

    @Named("dateToAge")
    default Integer dateToAge(ProfileEntity profileEntity) {
        LocalDate currLocalDate = LocalDate.now();
        Integer findedAge = Period.between(profileEntity.getBirthDate(),currLocalDate).getYears();
        return findedAge;
    }

}

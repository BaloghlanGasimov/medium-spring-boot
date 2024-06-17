package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import com.example.msmediumprojectbmweb.model.ProfileRequestDto;
import com.example.msmediumprojectbmweb.model.ProfileResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileEntity mapToEntity (ProfileResponseDto profileResponseDto);
    ProfileEntity mapToEntity (ProfileRequestDto profileRequestDto);
    ProfileRequestDto mapToReqDto (ProfileEntity profileEntity);
    ProfileResponseDto mapToRespDto (ProfileEntity profileEntity);

}

package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.UserEntity;
import com.example.msmediumprojectbmweb.model.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity mapToEntity (UserDto userDto);
    UserDto mapToDto (UserEntity userEntity);

}

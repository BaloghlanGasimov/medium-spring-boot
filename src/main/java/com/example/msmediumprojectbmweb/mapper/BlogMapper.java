package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.BlogEntity;
import com.example.msmediumprojectbmweb.model.BlogDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogMapper {

    BlogDto mapToDto(BlogEntity blogEntity);
    BlogEntity mapToEntity(BlogDto blogDto);

}

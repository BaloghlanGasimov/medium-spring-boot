package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.BlogEntity;
import com.example.msmediumprojectbmweb.model.BlogDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T16:06:52+0400",
    comments = "version: 1.5.2.Final, compiler: Eclipse JDT (IDE) 3.38.0.v20240524-2033, environment: Java 17.0.11 (Eclipse Adoptium)"
)
@Component
public class BlogMapperImpl implements BlogMapper {

    @Override
    public BlogDto mapToDto(BlogEntity blogEntity) {
        if ( blogEntity == null ) {
            return null;
        }

        BlogDto blogDto = new BlogDto();

        blogDto.setId( blogEntity.getId() );
        blogDto.setTitle( blogEntity.getTitle() );
        blogDto.setViews( blogEntity.getViews() );

        return blogDto;
    }

    @Override
    public BlogEntity mapToEntity(BlogDto blogDto) {
        if ( blogDto == null ) {
            return null;
        }

        BlogEntity blogEntity = new BlogEntity();

        blogEntity.setId( blogDto.getId() );
        blogEntity.setTitle( blogDto.getTitle() );
        blogEntity.setViews( blogDto.getViews() );

        return blogEntity;
    }
}

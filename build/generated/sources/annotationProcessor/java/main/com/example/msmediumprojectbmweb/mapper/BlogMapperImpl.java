package com.example.msmediumprojectbmweb.mapper;

import com.example.msmediumprojectbmweb.dao.entity.BlogEntity;
import com.example.msmediumprojectbmweb.model.BlogDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-21T16:08:25+0400",
    comments = "version: 1.5.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.3.jar, environment: Java 20.0.2.1 (Amazon.com Inc.)"
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

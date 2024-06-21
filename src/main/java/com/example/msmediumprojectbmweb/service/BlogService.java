package com.example.msmediumprojectbmweb.service;

import com.example.msmediumprojectbmweb.dao.entity.BlogEntity;
import com.example.msmediumprojectbmweb.dao.repository.BlogRepository;
import com.example.msmediumprojectbmweb.exceptions.NotFound;
import com.example.msmediumprojectbmweb.mapper.BlogMapper;
import com.example.msmediumprojectbmweb.model.BlogDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    public List<BlogDto> getAllBlogs(){
        log.info("ActionLog.getAllBlogs.start");

        List<BlogEntity> blogEntities = blogRepository.findAll();
        List<BlogDto> blogDtos = blogEntities.stream().map(blogMapper::mapToDto).toList();

        log.info("ActionLog.getAllBlogs.end");

        return blogDtos;
    }

    public BlogDto getBlogById(String blogId){
        log.info("ActionLog.getBlogById.start blogId:{}",blogId);

        BlogEntity blogEntity = findBlogById(blogId);
        BlogDto blogDto = blogMapper.mapToDto(blogEntity);

        log.info("ActionLog.getBlogById.end blogId:{}",blogId);

        return blogDto;
    }

    public void saveBlog(BlogDto blogDto){
        log.info("ActionLog.saveBlog.start");

        BlogEntity blogEntity = blogMapper.mapToEntity(blogDto);
        blogRepository.save(blogEntity);

        log.info("ActionLog.saveBlog.end");
    }

    public void editBlog(String blogId,BlogDto blogDto){
        log.info("ActionLog.editBlog.start blogId:{}",blogId);

        BlogEntity blogEntity = findBlogById(blogId);

        if(blogDto.getTitle()!=null){
            blogEntity.setTitle(blogDto.getTitle());
        }
        if(blogDto.getViews()!=null){
            blogEntity.setViews(blogDto.getViews());
        }
        blogRepository.save(blogEntity);

        log.info("ActionLog.editBlog.end blogId:{}",blogId);
    }

    public BlogDto deleteBlog(String blogId){
        log.info("ActionLog.deleteBlog.start blogId:{}",blogId);

        BlogEntity blogEntity = findBlogById(blogId);
        BlogDto blogDto = blogMapper.mapToDto(blogEntity);
        blogRepository.deleteById(blogId);

        log.info("ActionLog.deleteBlog.end blogId:{}",blogId);
        return blogDto;
    }

    private BlogEntity findBlogById(String blogId){
        BlogEntity blogEntity = blogRepository.findById(blogId)
                .orElseThrow(()->new NotFound("BLOG_NOT_FOUND","ERROR ActionLog.findBlogById blogId:{"+blogId+"}"));
        return blogEntity;
    }

}

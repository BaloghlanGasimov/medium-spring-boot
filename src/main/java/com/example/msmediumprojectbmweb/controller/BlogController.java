package com.example.msmediumprojectbmweb.controller;

import com.example.msmediumprojectbmweb.model.BlogDto;
import com.example.msmediumprojectbmweb.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogService blogService;

    @GetMapping
    public List<BlogDto> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    @GetMapping("/{blogId}")
    public BlogDto getBlogById(@PathVariable String blogId){
        return blogService.getBlogById(blogId);
    }

    @PutMapping("/{blogId}")
    public void editBlog(@PathVariable String blogId,@RequestBody BlogDto blogDto){
        blogService.editBlog(blogId,blogDto);
    }

    @PostMapping
    public void saveBlog(@RequestBody BlogDto blogDto){
        blogService.saveBlog(blogDto);
    }

    @DeleteMapping("/{blogId}")
    public BlogDto deleteBlog(@PathVariable String blogId){
        return blogService.deleteBlog(blogId);
    }

}

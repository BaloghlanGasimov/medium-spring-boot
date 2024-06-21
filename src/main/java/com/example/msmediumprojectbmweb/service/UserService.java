package com.example.msmediumprojectbmweb.service;

import com.example.msmediumprojectbmweb.dao.entity.BlogEntity;
import com.example.msmediumprojectbmweb.dao.entity.UserEntity;
import com.example.msmediumprojectbmweb.dao.repository.BlogRepository;
import com.example.msmediumprojectbmweb.dao.repository.UserRepository;
import com.example.msmediumprojectbmweb.exceptions.NotFound;
import com.example.msmediumprojectbmweb.mapper.UserMapper;
import com.example.msmediumprojectbmweb.model.BlogDto;
import com.example.msmediumprojectbmweb.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final BlogRepository blogRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers() {

        log.info("ActionLog.getAllUsers.start");

        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtos = userEntities.stream().map(userMapper::mapToDto).toList();

        log.info("ActionLog.getAllUsers.end");
        return userDtos;
    }

    public UserDto getUserById(String userId) {

        log.info("ActionLog.getAllUsers.getUserById.start id:{} ", userId);

        UserEntity userEntity = findUserById(userId);

        UserDto userDto = userMapper.mapToDto(userEntity);

        log.info("ActionLog.getAllUsers.getUserById.end id:{} ", userId);

        return userDto;
    }

    public void saveUser(UserDto userDto) {
        log.info("ActionLog.saveUser.start");
        UserEntity userEntity = userMapper.mapToEntity(userDto);

        System.out.println(userEntity.getProfile());

        userRepository.save(userEntity);
        log.info("ActionLog.saveUser.end");
    }

    public void editUserById(String userId, UserDto userDto) {
        log.info("ActionLog.editUserById.start id:{}", userId);
        UserEntity userEntity = findUserById(userId);

        if (userDto.getMail() != null) {
            userEntity.setMail(userDto.getMail());
        }
        if (userDto.getPassword() != null) {
            userEntity.setMail(userDto.getPassword());
        }

        log.info("ActionLog.editUserById.end id:{}", userId);
        userRepository.save(userEntity);
    }

    public UserDto deleteById(String userId) {
        log.info("ActionLog.deleteById.start id:{}", userId);

        UserEntity userEntity = findUserById(userId);
        userRepository.deleteById(userId);

        log.info("ActionLog.deleteById.end id:{}", userId);

        return userMapper.mapToDto(userEntity);
    }

    public void editBlogOfUserById(String userId, String blogId, BlogDto blogDto) {
        log.info("ActionLog.editBlogOfUserById.start userId:{} blogId:{}",userId,blogId);
        UserEntity userEntity = findUserById(userId);
        BlogEntity blogEntity = findBlogById(blogId);

        if(blogDto.getViews()!=null){
            blogEntity.setViews(blogDto.getViews());
        }
        if(blogDto.getTitle()!=null){
            blogEntity.setTitle(blogDto.getTitle());
        }

        blogRepository.save(blogEntity);

        log.info("ActionLog.editBlogOfUserById.end userId:{} blogId:{}",userId,blogId);
    }

    public void assignBlogToUser(String userId,String blogId){
        log.info("ActionLog.assignBlogToUser.start userId:{} blogId:{}",userId,blogId);

        UserEntity userEntity = findUserById(userId);
        BlogEntity blogEntity = findBlogById(blogId);

        List<BlogEntity> blogEntities = userEntity.getBlogs();
        blogEntities.add(blogEntity);

        userEntity.setBlogs(blogEntities);
        userRepository.save(userEntity);

        log.info("ActionLog.assignBlogToUser.end userId:{} blogId:{}",userId,blogId);
    }

    private UserEntity findUserById(String userId){
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(()->new NotFound("USER_NOT_FOUND","ERROR ActionLog.findUser id:{" + userId + "}"));
        return userEntity;
    }
    private BlogEntity findBlogById(String blogId){
        BlogEntity blogEntity = blogRepository.findById(blogId)
                .orElseThrow(()->new NotFound("BLOG_NOT_FOUND","ERROR ActionLog.findBlogById blogId:{"+blogId+"}"));
        return blogEntity;
    }


}


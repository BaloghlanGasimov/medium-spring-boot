package com.example.msmediumprojectbmweb.service;

import com.example.msmediumprojectbmweb.dao.entity.UserEntity;
import com.example.msmediumprojectbmweb.dao.repository.UserRepository;
import com.example.msmediumprojectbmweb.exceptions.NotFound;
import com.example.msmediumprojectbmweb.mapper.UserMapper;
import com.example.msmediumprojectbmweb.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getAllUsers (){

        log.info("ActionLog.getAllUsers.start");

        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtos = userEntities.stream().map(userMapper::mapToDto).toList();

        log.info("ActionLog.getAllUsers.end");
        return  userDtos;
    }

    public UserDto getUserById (String userId){

        log.info("ActionLog.getAllUsers.getUserById.start id:{} ",userId);

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(()->  new NotFound("NOT_FOUND","ERROR ActionLog.getAllUsers.getUserById id:{"+userId+"}"));

        UserDto userDto = userMapper.mapToDto(userEntity);

        log.info("ActionLog.getAllUsers.getUserById.end id:{} ",userId);

        return userDto;
    }

    public void saveUser(UserDto userDto){
        log.info("ActionLog.saveUser.start");
        UserEntity userEntity = userMapper.mapToEntity(userDto);

        System.out.println(userEntity.getProfile());

        userRepository.save(userEntity);
        log.info("ActionLog.saveUser.end");
    }

    public void editUserById(String userId,UserDto userDto){
        log.info("ActionLog.editUserById.start id:{}",userId);
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(()->  new NotFound("NOT_FOUND","ERROR ActionLog.getAllUsers.getUserById id:{"+userId+"}"));

        if(userDto.getMail()!=null){
            userEntity.setMail(userDto.getMail());
        }
        if(userDto.getPassword()!=null){
            userEntity.setMail(userDto.getPassword());
        }

        log.info("ActionLog.editUserById.end id:{}",userId);
        userRepository.save(userEntity);
    }

    public UserDto deleteById(String userId){
        log.info("ActionLog.deleteById.start id:{}",userId);

        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(()->  new NotFound("NOT_FOUND","ERROR ActionLog.deleteById id:{"+userId+"}"));
        userRepository.deleteById(userId);

        log.info("ActionLog.deleteById.end id:{}",userId);

        return userMapper.mapToDto(userEntity);
    }

}


package com.example.msmediumprojectbmweb.controller;

import com.example.msmediumprojectbmweb.model.BlogDto;
import com.example.msmediumprojectbmweb.model.UserDto;
import com.example.msmediumprojectbmweb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable String userId){
        return userService.getUserById(userId);
    }

    @PostMapping
    public void saveUser(@RequestBody UserDto userDto){
        userService.saveUser(userDto);
    }

    @PutMapping("/{userId}")
    public void editUserById(@PathVariable String userId, @RequestBody UserDto userDto){
        userService.editUserById(userId,userDto);
    }

    @DeleteMapping("/{userId}")
    public UserDto deleteUserById(@PathVariable String userId){
        return userService.deleteById(userId);
    }

    @PutMapping("/{userId}/blogs/{blogId}")
    public void editBlogOfUserById(@PathVariable String userId, @PathVariable String blogId, @RequestBody BlogDto blogDto){
        userService.editBlogOfUserById(userId,blogId,blogDto);
    }

    @PatchMapping("/{userId}/blogs/{blogId}")
    public void assignBlogToUser(@PathVariable String userId,@PathVariable String blogId){
        userService.assignBlogToUser(userId,blogId);
    }
}

package com.example.msmediumprojectbmweb.controller;

import com.example.msmediumprojectbmweb.model.ProfileRequestDto;
import com.example.msmediumprojectbmweb.model.ProfileResponseDto;
import com.example.msmediumprojectbmweb.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;
    @GetMapping
    public List<ProfileResponseDto> getAllProfiles(){
        return profileService.getAllProfiles();
    }

    @GetMapping("/{profileId}")
    public ProfileResponseDto getProfileById(@PathVariable String profileId){
        return profileService.getProfileById(profileId);
    }

    @PostMapping
    public void saveProfile (@RequestBody ProfileRequestDto profileRequestDto){
        profileService.saveProfile(profileRequestDto);
    }

    @PutMapping("/{profileId}")
    public void editProfileById(@PathVariable String profileId,@RequestBody ProfileRequestDto profileRequestDto){
        profileService.editProfileById(profileId,profileRequestDto);
    }

    @DeleteMapping("/{profileId}")
    public ProfileResponseDto deleteById(@PathVariable String profileId){
        return profileService.deleteById(profileId);
    }

}

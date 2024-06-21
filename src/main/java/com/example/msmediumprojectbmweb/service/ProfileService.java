package com.example.msmediumprojectbmweb.service;

import com.example.msmediumprojectbmweb.dao.entity.ProfileEntity;
import com.example.msmediumprojectbmweb.dao.repository.ProfileRepository;
import com.example.msmediumprojectbmweb.exceptions.NotFound;
import com.example.msmediumprojectbmweb.mapper.ProfileMapper;
import com.example.msmediumprojectbmweb.model.ProfileRequestDto;
import com.example.msmediumprojectbmweb.model.ProfileResponseDto;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final ProfileMapper profileMapper;

    public List<ProfileResponseDto> getAllProfiles() {
        log.info("ActionLog.getAllProfiles.start");

        List<ProfileEntity> profileEntities = profileRepository.findAll();
        List<ProfileResponseDto> profileResponseDtos = profileEntities.stream().map(profileMapper::mapToRespDto).toList();

        log.info("ActionLog.getAllProfiles.end");

        return profileResponseDtos;
    }

    public ProfileResponseDto getProfileById(String profileId) {
        log.info("ActionLog.getProfileById.start id:{}", profileId);

        ProfileEntity profileEntity = findProfileEntityById(profileId);
        ProfileResponseDto profileResponseDto = profileMapper.mapToRespDto(profileEntity);

        log.info("ActionLog.getProfileById.end id:{}", profileId);
        return profileResponseDto;
    }

    public void saveProfile(ProfileRequestDto profileRequestDto) {
        log.info("ActionLog.saveProfile.start");

        ProfileEntity profileEntity = profileMapper.mapToEntity(profileRequestDto);
        profileRepository.save(profileEntity);

        log.info("ActionLog.saveProfile.end");
    }

    public void editProfileById(String profileId, ProfileRequestDto profileRequestDto) {
        log.info("ActionLog.editProfileById.start id:{}", profileId);

        ProfileEntity profileEntity = findProfileEntityById(profileId);
        if (profileRequestDto.getName() != null) {
            profileEntity.setName(profileRequestDto.getName());
        }
        if (profileRequestDto.getSurname() != null) {
            profileEntity.setSurname(profileRequestDto.getSurname());
        }
        if (profileRequestDto.getProfession() != null) {
            profileEntity.setProfession(profileRequestDto.getProfession());
        }
        if (profileRequestDto.getBirthDate() != null) {
            profileEntity.setBirthDate(profileRequestDto.getBirthDate());
        }

        profileRepository.save(profileEntity);
        log.info("ActionLog.editProfileById.end id:{}", profileId);
    }

    public ProfileResponseDto deleteById(String profileId){
        log.info("ActionLog.deleteById.start id:{}",profileId);

        ProfileEntity profileEntity = findProfileEntityById(profileId);
        ProfileResponseDto profileResponseDto = profileMapper.mapToRespDto(profileEntity);
        profileRepository.deleteById(profileId);

        log.info("ActionLog.deleteById.end id:{}",profileId);
        return profileResponseDto;
    }

    private ProfileEntity findProfileEntityById(String profileId){
        ProfileEntity profileEntity = profileRepository.findById(profileId)
                .orElseThrow(() -> new NotFound("PROFILE_NOT_FOUND", "ActionLog.getProfileById.start id:{" + profileId + "}"));
        return profileEntity;
    }

}

package com.example.api.services.impl;

import com.example.api.dtos.AnimalDto;
import com.example.api.model.AnimalEntity;
import com.example.api.model.UserEntity;
import com.example.api.repository.AnimalRepository;
import com.example.api.services.AnimalService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public AnimalDto createAnimal(AnimalDto animalDto) {
        AnimalEntity animal = new AnimalEntity();
        BeanUtils.copyProperties(animalDto,animal);
        animal.setAdopted(false);
        UserEntity user = new UserEntity();
        user.setId(animalDto.getUserId());
        animal.setUserEntity(user);
        AnimalEntity animalResponse = animalRepository.save(animal);
        AnimalDto animalDtoResponse = new AnimalDto();
        BeanUtils.copyProperties(animalResponse,animalDtoResponse);
        return animalDtoResponse;
    }

    @Override
    public AnimalEntity findById(Long id) {
        return animalRepository.findById(id).orElseThrow(()-> new RuntimeException("animla does id "+id+" not found"));
    }

    @Override
    public List<AnimalDto> getAllAnimalByUser(UserEntity userEntity) {
        List<AnimalEntity> animalEntity = animalRepository.findByUserEntity(userEntity);
        List<AnimalDto> animalDtos = new ArrayList<>();
        animalEntity.stream().map(element->{
            AnimalDto animalDto = new AnimalDto();
            BeanUtils.copyProperties(element,animalDto);
            animalDtos.add(animalDto);
            return null;
        }).collect(Collectors.toList());
        return animalDtos;
    }
}

package com.example.api.services;

import com.example.api.dtos.AnimalDto;
import com.example.api.model.AnimalEntity;
import com.example.api.model.UserEntity;

import java.util.List;

public interface AnimalService {

    AnimalDto createAnimal(AnimalDto animalDto);

    AnimalEntity findById(Long id);

    List<AnimalDto> getAllAnimalByUser(UserEntity userEntity);


}

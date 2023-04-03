package com.example.api.dtos;

import com.example.api.model.AnimalEntity;
import com.example.api.model.UserEntity;
import lombok.Data;

import java.util.List;

@Data
public class PostApplyDto {

    private AnimalEntity animalEntity;

    private List<UserEntity> userEntityList;

}

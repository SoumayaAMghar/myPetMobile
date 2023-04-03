package com.example.api.dtos;

import com.example.api.model.AnimalEntity;
import com.example.api.model.CommentEntity;
import com.example.api.model.UserEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class PublicationDto {

    private Long id;

    private String city;

    private int nbJ;

    private float price;

    private UserEntity userEntity;

    private Long idAnimal;

    private AnimalEntity animalEntity;

    private List<CommentEntity> commentEntities;

}

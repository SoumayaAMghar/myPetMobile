package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "publication")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class PublicationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private int nbJ;

    private float price;

    @OneToOne
    private UserEntity userEntity;

    @OneToOne
    private AnimalEntity animalEntity;

    @OneToMany(mappedBy = "publicationEntity")
    private List<CommentEntity> commentEntities;



}

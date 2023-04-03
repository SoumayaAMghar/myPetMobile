package com.example.api.model;

import com.example.api.model.enums.AnimalKind;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "animal")
@Data
public class AnimalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private AnimalKind animalKind;

    private Date birthday;

    private String name;

    private Boolean adopted;

    private String description;

    @Column(columnDefinition="TEXT", length = 2048)
    private String picture;

    @ManyToOne
    private UserEntity userEntity;



}

package com.example.api.dtos;

import com.example.api.model.enums.AnimalKind;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AnimalDto {

    private Long id;

    private AnimalKind animalKind;

    private Date birthday;

    private String name;

    private String description;

    @Column(columnDefinition="TEXT", length = 2048)
    private String picture;

    private Long userId;

}

package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "comment")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private Date createdAt;

    @ManyToOne
    private PublicationEntity publicationEntity;

    @ManyToOne
    private UserEntity userEntity;

}

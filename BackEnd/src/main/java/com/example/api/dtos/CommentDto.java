package com.example.api.dtos;

import com.example.api.model.UserEntity;
import lombok.Data;

@Data
public class CommentDto {

    private String message;

    private Long idPub;

}

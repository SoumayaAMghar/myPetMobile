package com.example.api.services;

import com.example.api.dtos.CommentDto;
import com.example.api.model.CommentEntity;

public interface CommentService {
    CommentDto createComment(CommentEntity commentEntity);
}

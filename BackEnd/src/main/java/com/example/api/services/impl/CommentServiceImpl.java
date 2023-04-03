package com.example.api.services.impl;

import com.example.api.dtos.CommentDto;
import com.example.api.model.CommentEntity;
import com.example.api.repository.CommentRepository;
import com.example.api.services.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public CommentDto createComment(CommentEntity commentEntity) {
        CommentEntity comment= commentRepository.save(commentEntity);
        CommentDto commentDto = new CommentDto();
        BeanUtils.copyProperties(comment,commentDto);
        return commentDto;
    }
}

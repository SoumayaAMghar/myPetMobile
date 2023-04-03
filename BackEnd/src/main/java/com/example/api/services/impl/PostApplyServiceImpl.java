package com.example.api.services.impl;

import com.example.api.dtos.PostApplyDto;
import com.example.api.model.PostApplyEntity;
import com.example.api.repository.PostApplyRepository;
import com.example.api.services.PostApplyService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostApplyServiceImpl implements PostApplyService {

    private final PostApplyRepository postApplyRepository;
    @Autowired
    public PostApplyServiceImpl(PostApplyRepository postApplyRepository) {
        this.postApplyRepository = postApplyRepository;
    }


    @Override
    public PostApplyDto applyToPost(PostApplyDto postApplyDto) {
        PostApplyEntity postApplyEntityRequest = new PostApplyEntity();
        BeanUtils.copyProperties(postApplyDto,postApplyEntityRequest);
        PostApplyEntity postApplyEntityResponse = postApplyRepository.save(postApplyEntityRequest);
        PostApplyDto postApplyDtoResponse = new PostApplyDto();
        BeanUtils.copyProperties(postApplyEntityResponse,postApplyDtoResponse);
        return postApplyDtoResponse;
    }

    @Override
    public List<PostApplyEntity> postAppl() {
        return postApplyRepository.findAll();
    }
}

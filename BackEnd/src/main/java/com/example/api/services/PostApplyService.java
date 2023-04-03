package com.example.api.services;


import com.example.api.dtos.PostApplyDto;
import com.example.api.model.PostApplyEntity;

import java.util.List;

public interface PostApplyService {

    PostApplyDto applyToPost(PostApplyDto postApplyDto);

    List<PostApplyEntity> postAppl();

}

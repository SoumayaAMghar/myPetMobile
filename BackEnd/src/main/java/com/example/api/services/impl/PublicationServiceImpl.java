package com.example.api.services.impl;

import com.example.api.dtos.PublicationDto;
import com.example.api.model.PublicationEntity;
import com.example.api.repository.PublicationRepository;
import com.example.api.services.PublicationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationServiceImpl implements PublicationService {

    private final PublicationRepository publicationRepository;

    @Autowired
    public PublicationServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public PublicationDto createPublication(PublicationDto publicationDto) {
        PublicationEntity publicationRequest = new PublicationEntity();
        BeanUtils.copyProperties(publicationDto,publicationRequest);
        PublicationEntity PublicationResponse = publicationRepository.save(publicationRequest);
        PublicationDto publicationDtoResponse = new PublicationDto();
        BeanUtils.copyProperties(PublicationResponse,publicationDtoResponse);
        return publicationDtoResponse;
    }

    @Override
    public List<PublicationDto> getAllPublication() {
        List<PublicationEntity> publicationEntities = publicationRepository.findAll();
        List<PublicationDto> publicationDtos = new ArrayList<>();
        publicationEntities.stream().map(element ->{
            PublicationDto publicationDto = new PublicationDto();
            BeanUtils.copyProperties(element,publicationDto);
            publicationDtos.add(publicationDto);
            return null;
        }).collect(Collectors.toList());
        return publicationDtos;
    }


}

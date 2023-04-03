package com.example.api.services;

import com.example.api.dtos.PublicationDto;

import java.util.List;

public interface PublicationService {

    PublicationDto createPublication(PublicationDto publicationDto);

    List<PublicationDto> getAllPublication();

}

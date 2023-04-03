package com.example.api.repository;

import com.example.api.model.AnimalEntity;
import com.example.api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<AnimalEntity, Long> {

    List<AnimalEntity> findByUserEntity(UserEntity userEntity);
}
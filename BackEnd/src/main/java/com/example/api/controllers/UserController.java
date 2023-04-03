package com.example.api.controllers;

import com.example.api.dtos.AnimalDto;
import com.example.api.dtos.CommentDto;
import com.example.api.dtos.PostApplyDto;
import com.example.api.dtos.PublicationDto;
import com.example.api.model.*;
import com.example.api.security.SecurityConstants;
import com.example.api.services.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final AnimalService animalService;
    private final PublicationService publicationService;
    private final UserService userService;
    private final CommentService commentService;
    private final PostApplyService postApplyService;

    @Autowired
    public UserController(AnimalService animalService, UserService userService, PublicationService publicationService, CommentService commentService, PostApplyService postApplyService) {
        this.animalService = animalService;
        this.userService = userService;
        this.publicationService = publicationService;
        this.commentService = commentService;
        this.postApplyService = postApplyService;
    }

    @PostMapping("create_animal")
    public ResponseEntity<AnimalDto> createAnimal(@RequestBody AnimalDto animalDto,HttpServletRequest request){
        //get user logeed by token from client
        UserEntity userRequest = getUserByEmail(request);
        animalDto.setUserId(userRequest.getId());
        return new ResponseEntity<>(animalService.createAnimal(animalDto), HttpStatus.CREATED);
    }

    @PostMapping("create_comment")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,HttpServletRequest request){
        UserEntity user = getUserByEmail(request);
        PublicationEntity publication = new PublicationEntity();
        publication.setId(commentDto.getIdPub());
        CommentEntity comment = new CommentEntity();
        BeanUtils.copyProperties(commentDto,comment);
        comment.setCreatedAt(new Date());
        comment.setPublicationEntity(publication);
        comment.setUserEntity(user);
        System.out.println(comment.toString());
        return new ResponseEntity<>(commentService.createComment(comment),HttpStatus.CREATED);
    }

    @PostMapping("create_publication")
    public ResponseEntity<PublicationDto> createPublication(@RequestBody PublicationDto publicationDto,HttpServletRequest request){
        //get user logeed by token from client
        UserEntity userRequest = getUserByEmail(request);
        //get animal by id from client
        AnimalEntity animalEntity = animalService.findById(publicationDto.getIdAnimal());
        publicationDto.setAnimalEntity(animalEntity);
        publicationDto.setUserEntity(userRequest);
        PublicationEntity publication = new PublicationEntity();
        BeanUtils.copyProperties(publicationDto,publication);
        PublicationDto publicationDto1 = publicationService.createPublication(publicationDto);
        return new ResponseEntity<>(publicationDto1,HttpStatus.OK);
    }

    @GetMapping("publications")
    public List<PublicationDto> publicationDtos(){
        return publicationService.getAllPublication();
    }

    @GetMapping("animals")
    public List<AnimalDto> getAllAnimals(HttpServletRequest request){
        //get user logeed by token from client
        UserEntity userRequest = getUserByEmail(request);
        return animalService.getAllAnimalByUser(userRequest);
    }

    @PostMapping("apply")
    public PostApplyDto applyToPublication(@RequestBody PostApplyDto postApplyDto){
//        System.out.println("animal id : "+postApplyDto.getAnimalEntity().getId());
//        System.out.println("user : "+postApplyDto.getUserEntityList().get(0).getId());
//        return null;
        return postApplyService.applyToPost(postApplyDto);
    }

    @GetMapping("get")
    public List<PostApplyEntity> getAll(){
        return postApplyService.postAppl();
    }


    //Get JWT From request of client
    private String getJWTFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7,bearerToken.length());
        }
        return null;
    }

    //Get user logeed by token
    public String getUsernameFromJWT(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public UserEntity getUserByEmail(HttpServletRequest request){
        //return token
        String token = getJWTFromRequest(request);
        //return email from token
        String email = getUsernameFromJWT(token);
        //
        Optional<UserEntity> userEntity = userService.findByEmail(email);
        UserEntity userResponse = new UserEntity();
        userResponse.setId(userEntity.get().getId());
        return userResponse;
    }

}

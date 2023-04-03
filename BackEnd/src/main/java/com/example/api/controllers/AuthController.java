package com.example.api.controllers;

import com.example.api.dtos.AuthResponseDto;
import com.example.api.dtos.LoginDto;
import com.example.api.dtos.RegisterDto;
import com.example.api.model.RoleEntity;
import com.example.api.model.UserEntity;
import com.example.api.repository.RoleRepository;
import com.example.api.repository.UserRepository;
import com.example.api.security.JWTGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JWTGenerator jwtGenerator;



    @Autowired
    public AuthController(AuthenticationManager authenticationManager, UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail().toLowerCase(),loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDto(token),HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto){
        if(userRepository.existsByEmail(registerDto.getEmail())){
            return new ResponseEntity<>("Email is taken", HttpStatus.BAD_REQUEST);
        }
        UserEntity user = new UserEntity();
        BeanUtils.copyProperties(registerDto,user);
        user.setEmail(registerDto.getEmail().toLowerCase());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        RoleEntity role = roleRepository.findByName("ROLE_USER").get();
        user.setRoleEntities(Collections.singletonList(role));
        userRepository.save(user);
        return new ResponseEntity<>("User registred success",HttpStatus.OK);
    }

}

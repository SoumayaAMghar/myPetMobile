package com.example.api.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class RegisterDto {

    private String first_name;

    private String last_name;

    private String email;

    private String password;

    private String adresse;

    private String numberPhone;


}

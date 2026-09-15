package com.auragestao.dto;

import lombok.Data;

@Data
public class UserRequestDTO {

    private String name;
    private String phone;
    private String cpf;
    private Integer typeUser;
}
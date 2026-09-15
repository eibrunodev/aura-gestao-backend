package com.auragestao.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String phone;
    private String cpf;
    private Integer typeUser;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}

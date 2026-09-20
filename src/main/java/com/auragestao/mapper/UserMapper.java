package com.auragestao.mapper;

import com.auragestao.dto.UserRequestDTO;
import com.auragestao.dto.UserResponseDTO;
import com.auragestao.entity.User;

public class UserMapper {

    public static User toEntity(UserRequestDTO dto) {
        User user = new User();

        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setCpf(dto.getCpf());
        user.setTypeUser(dto.getTypeUser());

        return user;
    }

    public static UserResponseDTO toResponse(User user) {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setPhone(user.getPhone());
        dto.setCpf(user.getCpf());
        dto.setTypeUser(user.getTypeUser());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setUpdatedAt(user.getUpdatedAt());

        return dto;
    }
}

package com.auragestao.controller;

import com.auragestao.dto.UserRequestDTO;
import com.auragestao.dto.UserResponseDTO;
import com.auragestao.entity.User;
import com.auragestao.mapper.UserMapper;
import com.auragestao.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO){
        User user = UserMapper.toEntity(userRequestDTO);

        User saveUser = userService.createUser(user);

        return UserMapper.toResponse(saveUser);
    }

    @GetMapping
    public List<UserResponseDTO> userListAll(){

        List<User> users = userService.findAllUsers();

        return users.stream()
                .map(UserMapper::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public UserResponseDTO searchID(@PathVariable Long id) {
        User user = userService.findUserById(id);

        return UserMapper.toResponse(user);
    }

    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){

        User user = UserMapper.toEntity(userRequestDTO);

        User updatedUser = userService.updateUser(id, user);

        return UserMapper.toResponse(updatedUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.delete(id);
    }
}
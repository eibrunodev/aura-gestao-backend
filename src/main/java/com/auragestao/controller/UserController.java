package com.auragestao.controller;

import com.auragestao.dto.UserRequestDTO;
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
    public User createUser(@RequestBody UserRequestDTO userRequestDTO){
        User user = UserMapper.toEntity(userRequestDTO);

        return userService.createUser(user);
    }

    @GetMapping
    public List<User> userListAll(){
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public User searchID(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){

        User user = UserMapper.toEntity(userRequestDTO);

        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser (@PathVariable Long id) {
        userService.delete(id);
    }
}

package com.auragestao.service;

import com.auragestao.entity.User;
import com.auragestao.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuario não encontrado"
                ));
    }

    public User updateUser(Long id, User user) {
        User userExisting = findUserById(id);

        userExisting.setName(user.getName());
        userExisting.setCpf(user.getCpf());
        userExisting.setPhone(user.getPhone());
        userExisting.setTypeUser(user.getTypeUser());

        return userRepository.save(userExisting);
    }

    public void delete( Long id ){
        User userExisting = findUserById(id);

        userRepository.delete(userExisting);
    }
}
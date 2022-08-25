package com.example.patscars.service;

import com.example.patscars.model.User;
import com.example.patscars.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    public final UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll();}


    public void addUser(User user) {
        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashedPassword);
        userRepository.save(user);
    }

    public void updateUser(User user, Integer id) {
        User oldUser = userRepository.getById(id);
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
    }

    public void deleteUser(Integer id) {
        User oldUser = userRepository.getById(id);
        userRepository.delete(oldUser);
    }
}
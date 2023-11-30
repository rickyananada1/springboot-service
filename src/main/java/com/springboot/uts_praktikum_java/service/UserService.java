package com.springboot.uts_praktikum_java.service;

import com.springboot.uts_praktikum_java.model.User;
import com.springboot.uts_praktikum_java.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser) {
        User existingUser = getUserById(id);
        updatedUser.setId(existingUser.getId()); // Pastikan ID tidak berubah
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

//    make search
    public User search(String keyword) {
        return userRepository.findByUsername(keyword);
    }
}
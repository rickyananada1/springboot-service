package com.springboot.uts_praktikum_java.controller;

import com.springboot.uts_praktikum_java.model.User;
import com.springboot.uts_praktikum_java.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public List<User> list() {
        return userService.getAllUsers(); // Mengganti userService.listAllUser() dengan userService.getAllUsers()
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Long id) { // Menggunakan tipe data Long yang sesuai dengan ID pada model
        try {
            User user = userService.getUserById(id);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody User user) {
        userService.createUser(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id) { // Menggunakan tipe data Long yang sesuai dengan ID pada model
        try {
            User existUser = userService.getUserById(id);
            user.setId(id);
            userService.updateUser(id, user); // Menggunakan userService.updateUser(id, user) untuk mengupdate pengguna yang ada
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { // Menggunakan tipe data Long yang sesuai dengan ID pada model
        userService.deleteUser(id);
    }

    @GetMapping("/search/{keyword}")
    public List<User> search(@PathVariable String keyword) {
        return Collections.singletonList(userService.search(keyword));
    }


}
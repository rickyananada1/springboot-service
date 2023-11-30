package com.springboot.uts_praktikum_java.controller;

import com.springboot.uts_praktikum_java.model.Menu;
import com.springboot.uts_praktikum_java.model.User;
import com.springboot.uts_praktikum_java.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/menus")
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping("")
    public List<Menu> list() {
        return menuService.getAllMenus();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Menu> get(@PathVariable Long id) {
        try {
            Menu menu = menuService.getMenuById(id);
            return new ResponseEntity<>(menu, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Menu menu) {
        menuService.createMenu(menu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Menu menu, @PathVariable Long id) {
        try {
            Menu existingMenu = menuService.getMenuById(id);
            menu.setId(id);
            menuService.updateMenu(id, menu);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        menuService.deleteMenu(id);
    }

    @GetMapping("/search/{keyword}")
    public List<Menu> search(@PathVariable String keyword) {
        return Collections.singletonList(menuService.search(keyword));
    }
}


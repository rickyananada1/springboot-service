package com.springboot.uts_praktikum_java.service;


import com.springboot.uts_praktikum_java.model.Menu;
import com.springboot.uts_praktikum_java.model.User;
import com.springboot.uts_praktikum_java.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    public Menu getMenuById(Long id) {
        return menuRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public Menu createMenu(Menu menu) {
        return menuRepository.save(menu);
    }

    public Menu updateMenu(Long id, Menu updatedMenu) {
        Menu existingMenu = getMenuById(id);
        updatedMenu.setId(existingMenu.getId()); // Pastikan ID tidak berubah
        return menuRepository.save(updatedMenu);
    }

    public void deleteMenu(Long id) {
        menuRepository.deleteById(id);
    }

    public Menu search(String keyword) {
        return menuRepository.findByNamaMenu(keyword);
    }
}

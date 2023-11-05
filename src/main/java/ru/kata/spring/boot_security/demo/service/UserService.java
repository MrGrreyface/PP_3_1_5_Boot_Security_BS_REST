package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User findById(Long id);

    void saveUser(User user);

    void updateUser(User user);

    void deleteById(long id);

    User findByUsername(String username);
}

package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("user", user);
        List<User> userList = userService.getAll();
        model.addAttribute("userList", userList);
        return "users";
    }

    @GetMapping("/newUser")
    public String createNewUser(Model model) {
        User user = new User();
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "user-form";
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute("user") User user, @RequestParam("roles") List<Role> roles) {
        user.setRoles(roles.stream().collect(Collectors.toSet()));
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/update")
    public String updateUserForm(Model model, @PathVariable("id") Long id) {
        User user = userService.findById(id);
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "edit-form";
    }

    @PostMapping("/{id}/update")
    public String updateUser(@ModelAttribute("user") User user, @RequestParam("id") Long id) {

        userService.update(user);
        return "redirect:/admin";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/admin";
    }
}

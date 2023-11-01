package org.iitc.ams_demo.controller;

import org.iitc.ams_demo.DTO.UserDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<UserDTO> getAllUsers() {
        return userService.getUsers();
    }

    @GetMapping("/user/{id}")
    public UserDTO getspecificUsers(@PathVariable Long id) throws ResourceNotFoundException {
        return userService.getUserDetails(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody UserDTO user) {
        userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public void changeUserDetails(@PathVariable(value = "id") Long id,
                                  @RequestBody UserDTO user) throws ResourceNotFoundException {
        userService.updateUser(user, id);
    }

    @DeleteMapping("/user/{id}")
    public void removeUserDetails(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        userService.deleteUser(id);
    }
}

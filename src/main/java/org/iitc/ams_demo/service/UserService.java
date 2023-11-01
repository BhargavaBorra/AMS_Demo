package org.iitc.ams_demo.service;

import org.iitc.ams_demo.DTO.UserDTO;
import org.iitc.ams_demo.exceptions.ResourceNotFoundException;
import org.iitc.ams_demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getUsers() {
        List<UserDTO> Users = new ArrayList<>();
        userRepository.findAll().forEach(Users::add);
        return Users;
    }

    public void addUser(UserDTO user) {
        userRepository.save(user);
    }

    public void updateUser(UserDTO user, Long id) throws ResourceNotFoundException {
        UserDTO existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        if (user.getAddress() != null)
            existingUser.setAddress(user.getAddress());
        if (user.getEmail() != null)
            existingUser.setEmail(user.getEmail());
        if (user.getAge() != null)
            existingUser.setAge(user.getAge());
        if (user.getPhoneNumber() != null)
            existingUser.setPhoneNumber(user.getPhoneNumber());
        if (user.getGender() != null)
            existingUser.setGender(user.getGender());
        if (user.getFirstName() != null)
            existingUser.setFirstName(user.getFirstName());
        if (user.getLastName() != null)
            existingUser.setLastName(user.getLastName());
        if (user.getDateOfBirth() != null)
            existingUser.setDateOfBirth(user.getDateOfBirth());
        userRepository.save(existingUser);
    }

    public void deleteUser(Long id) throws ResourceNotFoundException {
        UserDTO existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
        userRepository.delete(existingUser);
    }

    public UserDTO getUserDetails(Long id) throws ResourceNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + id));
    }
}

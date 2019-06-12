package com.uipurpose.detailsapp.services;

import com.uipurpose.detailsapp.entities.UserDetails;
import com.uipurpose.detailsapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void addUser(UserDetails ud)
    {
        userRepository.save(ud);
    }

    public List<UserDetails> getUsers() {
        return userRepository.findAll();
    }

    public UserDetails getUserById(long id) {
        return userRepository.findById(id).get();
        
    }

    public List<UserDetails> deleteSUserById(long id) {
        userRepository.deleteById(id);
        return userRepository.findAll();
    }


    public Optional<UserDetails> updateUser(UserDetails ud) {
        userRepository.save(ud);
        
        return userRepository.findById(ud.getId());
    }


}

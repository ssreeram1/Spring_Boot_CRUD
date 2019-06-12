package com.uipurpose.detailsapp.controllers;

import com.uipurpose.detailsapp.entities.UserDetails;
import com.uipurpose.detailsapp.repositories.UserRepository;
import com.uipurpose.detailsapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Details")
@ComponentScan("com.uipurpose.detailsapp.entities")
@Configuration
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepo;

    @CrossOrigin
    @RequestMapping(value = "/Users", method = RequestMethod.POST)

    @ResponseBody
    public List<UserDetails> addUser(@RequestBody UserDetails u){
        userService.addUser(u);
        return userService.getUsers();
    }

    @CrossOrigin

    @RequestMapping(value = "/Users", method = RequestMethod.GET)
 
    public List<UserDetails> getUsers() {
    	return userService.getUsers();
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/Users/{id}", method = RequestMethod.GET)
    public UserDetails getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }


    @CrossOrigin
    @RequestMapping(value = "/Users/{id}", method = RequestMethod.DELETE)
    public List<UserDetails> DeleteUserById(@PathVariable("id") Long id) {
        
        
        return userService.deleteSUserById(id);
    }

    @CrossOrigin
    @RequestMapping(value = "/Users/{id}", method = RequestMethod.PUT)
    public Optional<UserDetails> updateUser(@RequestBody UserDetails u,@PathVariable("id") Long id ) {
       System.out.println(u.getEmail()+"--"+u.getFirstName()+"--"+u.getLastName()+"--"+u.getId());
       u.setId(id);
      
        
        return userService.updateUser(u);
    }

}

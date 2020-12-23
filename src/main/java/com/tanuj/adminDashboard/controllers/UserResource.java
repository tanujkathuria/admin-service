package com.tanuj.adminDashboard.controllers;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import com.tanuj.adminDashboard.exceptions.UserNotFoundException;
import com.tanuj.adminDashboard.model.User;
import com.tanuj.adminDashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserResource {


    @Autowired
    UserRepository userRepository;

    //retrieve all users
    @RequestMapping(method = RequestMethod.GET, path = "/users")
    public List<User> retrieveUsers(){

        return userRepository.findAll();
    }

    // retrieve user based on id

    //retrieve all users
    @RequestMapping(method = RequestMethod.GET, path = "/users/{id}")
    public EntityModel<User>  retrieveUsers(@PathVariable int id){
        User user =  userRepository.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id");
        }

        EntityModel<User> resource = EntityModel.of(user);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveUsers());

        resource.add(linkTo.withRel("all-users"));

//        return user;
        return resource;
    }

    @PostMapping(path = "/users")
    public User createUser(@Valid @RequestBody User user){
        return userRepository.save(user);
    }


    @DeleteMapping(path = "/users/{id}")
    public void deleteById(@PathVariable  int id){
        User user =  userRepository.deleteById(id);
        if(user == null)
        {
            throw new UserNotFoundException("id");
        }
    }

}

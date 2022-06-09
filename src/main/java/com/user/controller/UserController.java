package com.user.controller;

import com.user.Service.UserService;
import com.user.entity.Contact;
import com.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        User user=this.userService.getUser(userId);
//        http://localhost:9002/contact/user/2

     List contacts=   this.restTemplate.getForObject("http://contectservice/contact/users/"+user.getUserId(), List.class);
     user.setContacts( contacts);
     return user;
    }


    @GetMapping("/demo")
    public String display(){
        return "Hello World";
    }


}
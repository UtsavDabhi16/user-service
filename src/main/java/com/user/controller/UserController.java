package com.user.controller;

import com.user.Service.UserService;
import com.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${user.msg}")
    private String message;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") Long userId){
        User user=this.userService.getUser(userId);
//        http://localhost:9002/contact/user/2

     List contacts=   this.restTemplate.getForObject("http://contectservice/contact/users/"+user.getUserId(), List.class);
     user.setContacts( contacts);
     return user;
    }



    @GetMapping("/message")
    public String getMessage(){
        System.out.println("Inside get message method !!!!");
        return message;
    }

}
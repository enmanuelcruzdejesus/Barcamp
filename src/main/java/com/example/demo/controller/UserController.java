package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService service;




    @RequestMapping(path="user/getAll",method = RequestMethod.GET)
    public List<User> getUsers(HttpServletRequest request){

        List<User> Users = new ArrayList<User>();

        Users = service.fetchUsers();
        return Users;

    }

    @GetMapping("user/getById/{id}")
    public User getUserById(@PathVariable int id){
        return service.getUserById(id).get();
    }

    @RequestMapping(path="user/save",method = RequestMethod.POST)
    public  User saveUser (@RequestBody User User){
        return  service.saveUser(User);
    }

    @RequestMapping(path="user/login",method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody User user){
        User u = this.service.login(user.getUsername(),user.getPassword());
        if(u == null)
            return new ResponseEntity("invalid credentials", HttpStatus.UNAUTHORIZED);

        return new ResponseEntity(u, HttpStatus.OK);
    }


}

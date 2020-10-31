package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    public UserService(){

    }

    public List<User> fetchUsers(){
        return  repo.findAll();
    }

    public Optional<User> getUserById(int id){
        return repo.findById(id);
    }

    public User saveUser(User u){
        return repo.save(u);
    }

    public void deleteUser(int id){
        this.repo.deleteById(id);
    }

    public User login(String userName, String password){
        User user =   this.repo.login(userName,password);
        return user;
    }
}

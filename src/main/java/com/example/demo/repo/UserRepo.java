package com.example.demo.repo;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User, Integer> {

    @Query("SELECT u from User u WHERE u.username =:username and u.password=:password")
    public User login(@Param("username") String username, @Param("password") String password);
}

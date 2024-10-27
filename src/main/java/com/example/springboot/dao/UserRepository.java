package com.example.springboot.dao;

import com.example.springboot.entity.User;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface UserRepository extends Repository<User, Long> {

    void saveUser(User user);

    User findUserByUserName(String userName);

    long updateUser(User user);

    void deleteUserById(Long id);

    List<User> findByEmailAddressAndLastname(String emailAddress, String lastname);
}

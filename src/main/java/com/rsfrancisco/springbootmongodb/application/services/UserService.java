package com.rsfrancisco.springbootmongodb.application.services;


import com.rsfrancisco.springbootmongodb.domain.entities.User;
import com.rsfrancisco.springbootmongodb.domain.interfaces.repositories.IUserRepository;
import com.rsfrancisco.springbootmongodb.domain.interfaces.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository _userRepository;


    @Override
    public List<User> findAll() {
        return _userRepository.findAll();
    }
}

package com.rsfrancisco.springbootmongodb.domain.interfaces.services;

import com.rsfrancisco.springbootmongodb.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    /**
     * Obter todos os usuarios
     * @return uma coleção de usuarios
     */
    List<User> findAll();
}

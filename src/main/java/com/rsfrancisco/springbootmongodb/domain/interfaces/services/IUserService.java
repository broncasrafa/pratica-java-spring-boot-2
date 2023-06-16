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

    /**
     * Obter um usuario pelo seu identificador (id)
     * @param userId identificador (id) do usuario
     * @return um objeto do tipo usuario
     */
    User findById(String userId);

    /**
     * Inserir um novo usuario
     * @param user objeto do tipo usuario
     * @return um objeto do tipo usuario
     */
    User insert(User user);

    /**
     * Remover um usuario pelo seu identificador (id)
     * @param userId identificador (id) do usuario
     */
    void delete(String userId);

    /**
     * Atualizar os dados do usuario
     * @param user objeto do tipo usuario
     * @return um objeto atualizado do tipo usuario
     */
    User update(User user);
}

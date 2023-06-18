package com.rsfrancisco.springbootmongodb.domain.interfaces.services;

import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import org.springframework.stereotype.Service;

@Service
public interface IPostService {

    /**
     * Obter um post por seu identificador (id)
     * @param postId identificador (id) do post
     * @return objeto do tipo Post
     */
    Post findById(String postId);
}

package com.rsfrancisco.springbootmongodb.application.services;

import com.rsfrancisco.springbootmongodb.application.exceptions.ObjectNotFoundException;
import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import com.rsfrancisco.springbootmongodb.domain.interfaces.repositories.IPostRepository;
import com.rsfrancisco.springbootmongodb.domain.interfaces.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired private IPostRepository _postRepository;



    @Override
    public Post findById(String postId) {
        Optional<Post> obj = _postRepository.findById(postId);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }
}
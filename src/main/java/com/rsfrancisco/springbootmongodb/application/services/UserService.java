package com.rsfrancisco.springbootmongodb.application.services;


import com.rsfrancisco.springbootmongodb.application.exceptions.ObjectNotFoundException;
import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import com.rsfrancisco.springbootmongodb.domain.entities.User;
import com.rsfrancisco.springbootmongodb.domain.interfaces.repositories.IPostRepository;
import com.rsfrancisco.springbootmongodb.domain.interfaces.repositories.IUserRepository;
import com.rsfrancisco.springbootmongodb.domain.interfaces.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository _userRepository;
    @Autowired
    private IPostRepository _postRepository;

    @Override
    public List<User> findAll() {
        return _userRepository.findAll();
    }

    @Override
    public User findById(String userId) {
        Optional<User> obj = _userRepository.findById(userId);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public User insert(User user) {
        return _userRepository.insert(user);
    }

    @Override
    public User update(User user) {
        User newUser = findById(user.getId());
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        _userRepository.save(newUser);
        return newUser;
    }

    @Override
    public void delete(String userId) {
        findById(userId);
        _userRepository.deleteById(userId);
    }

    @Override
    public List<Post> getUserPosts(String userId) {
        User user = findById(userId);
        return user.getPosts();
    }

    @Override
    public boolean insertPost(String userId, Post post) {
        _postRepository.insert(post);

        User user = findById(userId);
        user.getPosts().add(post);
        _userRepository.save(user);
        return true;
    }
}

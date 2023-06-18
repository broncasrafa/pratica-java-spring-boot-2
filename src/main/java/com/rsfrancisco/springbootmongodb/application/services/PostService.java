package com.rsfrancisco.springbootmongodb.application.services;

import com.rsfrancisco.springbootmongodb.application.dto.CommentDTO;
import com.rsfrancisco.springbootmongodb.application.exceptions.ObjectNotFoundException;
import com.rsfrancisco.springbootmongodb.domain.entities.Comment;
import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import com.rsfrancisco.springbootmongodb.domain.interfaces.repositories.IPostRepository;
import com.rsfrancisco.springbootmongodb.domain.interfaces.services.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService implements IPostService {
    @Autowired private IPostRepository _postRepository;



    @Override
    public Post findById(String postId) {
        Optional<Post> obj = _postRepository.findById(postId);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    @Override
    public List<Post> findByTitle(String term) {
        List<Post> posts = _postRepository.findByTitleContainingIgnoreCase(term);
        return posts;
    }

    @Override
    public List<Post> searchByTitle(String term) {
        List<Post> posts = _postRepository.findByTitle(term);
        return posts;
    }

    @Override
    public List<Post> findByAnyTextAndDate(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        List<Post> posts = _postRepository.findByAnyTextAndDate(text, minDate, maxDate);
        return posts;
    }

    @Override
    public boolean insertCommentByPostId(String postId, Comment comment) {
        Post post = findById(postId);
        post.getComments().add(comment);
        _postRepository.save(post);
        return true;
    }
}
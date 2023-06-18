package com.rsfrancisco.springbootmongodb.application.dto;

import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import com.rsfrancisco.springbootmongodb.domain.entities.User;

import java.time.Instant;
import java.util.List;

public class PostDTO {
    private String id;
    private Instant createdAt;
    private String title;
    private String body;
    private AuthorDTO author;

    public PostDTO(String id, Instant createdAt, String title, String body, AuthorDTO author) {
        this.id = id;
        this.createdAt = createdAt;
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public AuthorDTO getAuthor() {
        return author;
    }
    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public static Post map(PostDTO dto) {
        return new Post(dto.getTitle(), dto.getBody(), dto.getAuthor());
    }

    public static PostDTO map(Post post) {
        return new PostDTO(post.getId(), post.getCreatedAt(), post.getTitle(), post.getBody(), post.getAuthor());
    }
    public static List<PostDTO> map(List<Post> posts) {
        return posts
                .stream()
                .map(c -> map(c))
                .toList();
    }
}

package com.rsfrancisco.springbootmongodb.domain.entities;

import com.rsfrancisco.springbootmongodb.application.dto.AuthorDTO;
import com.rsfrancisco.springbootmongodb.application.dto.CommentDTO;
import com.rsfrancisco.springbootmongodb.domain.utils.Helpers;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "posts")
public class Post implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Instant createdAt;
    private String title;
    private String body;
    private AuthorDTO author;


    private List<CommentDTO> comments = new ArrayList<>();



    public Post() {
        this.createdAt = Helpers.getDateTimeNow();
    }

    public Post(String id, String title, String body, AuthorDTO author) {
        this.id = id;
        this.createdAt = Helpers.getDateTimeNow();
        this.title = title;
        this.body = body;
        this.author = author;
    }

    public Post(String title, String body, AuthorDTO author) {
        this.createdAt = Helpers.getDateTimeNow();
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

    public List<CommentDTO> getComments() {
        return comments;
    }
    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

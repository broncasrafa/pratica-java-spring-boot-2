package com.rsfrancisco.springbootmongodb.domain.entities;

import com.rsfrancisco.springbootmongodb.application.dto.AuthorDTO;
import com.rsfrancisco.springbootmongodb.domain.utils.Helpers;

import java.io.Serializable;
import java.time.Instant;

public class Comment implements Serializable {

    private String id;
    private String text;
    private Instant createdAt;
    private Author author;

    public Comment() {
        this.createdAt = Helpers.getDateTimeNow();
    }

    public Comment(String id, String text, Author author) {
        this.id = id;
        this.text = text;
        this.createdAt = Helpers.getDateTimeNow();
        this.author = author;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
}

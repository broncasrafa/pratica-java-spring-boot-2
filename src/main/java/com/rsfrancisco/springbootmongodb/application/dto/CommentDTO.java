package com.rsfrancisco.springbootmongodb.application.dto;

import com.rsfrancisco.springbootmongodb.domain.Utils.Helpers;
import com.rsfrancisco.springbootmongodb.domain.entities.Comment;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.time.Instant;

public class CommentDTO implements Serializable {

    private String id;
    private String text;
    private Instant createdAt;
    private AuthorDTO author;

    public CommentDTO() {
        this.id = ObjectId.get().toString();
        this.createdAt = Helpers.getDateTimeNow();
    }

    public CommentDTO(String text, AuthorDTO author) {
        this.id = ObjectId.get().toString();
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

    public AuthorDTO getAuthor() {
        return author;
    }
    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public static Comment map(CommentDTO dto) {
        return new Comment(dto.getId(), dto.getText(), dto.getAuthor());
    }
}

package com.rsfrancisco.springbootmongodb.application.dto;

import com.rsfrancisco.springbootmongodb.domain.utils.Helpers;
import com.rsfrancisco.springbootmongodb.domain.entities.Comment;
import org.bson.types.ObjectId;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

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

    public CommentDTO(String id, String text, Instant createdAt, AuthorDTO author) {
        this.id = id;
        this.text = text;
        this.createdAt = createdAt;
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
        return new Comment(dto.getId(), dto.getText(), AuthorDTO.map(dto.getAuthor()));
    }
    public static CommentDTO map(Comment comment) {
        return new CommentDTO(comment.getId(), comment.getText(), comment.getCreatedAt(), AuthorDTO.map(comment.getAuthor()));
    }
    public static List<CommentDTO> map(List<Comment> comments) {
        return comments.stream()
                .map(c -> map(c))
                .toList();
    }
}

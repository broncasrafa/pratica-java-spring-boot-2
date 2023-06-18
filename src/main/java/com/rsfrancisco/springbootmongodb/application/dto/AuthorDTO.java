package com.rsfrancisco.springbootmongodb.application.dto;

import com.rsfrancisco.springbootmongodb.domain.entities.Author;
import com.rsfrancisco.springbootmongodb.domain.entities.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public AuthorDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public static Author map(AuthorDTO dto) {
        return new Author(dto.getId(), dto.getName());
    }
    public static AuthorDTO map(Author author) {
        return new AuthorDTO(author.getId(), author.getName());
    }
}

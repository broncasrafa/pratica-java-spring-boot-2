package com.rsfrancisco.springbootmongodb.domain.interfaces.services;

import com.rsfrancisco.springbootmongodb.application.dto.CommentDTO;
import com.rsfrancisco.springbootmongodb.domain.entities.Comment;
import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface IPostService {

    /**
     * Obter um post por seu identificador (id)
     * @param postId identificador (id) do post
     * @return objeto do tipo Post
     */
    Post findById(String postId);

    /**
     * Obter os posts cujo o titulo CONTENHA o termo especificado
     * @param term criterio de pesquisa nos posts
     * @return lista de post que contenha o criterio de pesquisa
     */
    List<Post> findByTitle(String term);

    List<Post> searchByTitle(String term);

    List<Post> findByAnyTextAndDate(String text, Date minDate, Date maxDate);

    /**
     * Inserir um comentario no post especificado pelo seu identificador (id)
     * @param postId identificador (id) do post
     * @param comment objeto do tipo CommentDTO
     * @return true para sucesso
     */
    boolean insertCommentByPostId(String postId, CommentDTO comment);


}

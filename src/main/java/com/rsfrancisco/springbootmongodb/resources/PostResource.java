package com.rsfrancisco.springbootmongodb.resources;


import com.rsfrancisco.springbootmongodb.application.dto.CommentDTO;
import com.rsfrancisco.springbootmongodb.application.dto.PostDTO;
import com.rsfrancisco.springbootmongodb.domain.entities.Comment;
import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import com.rsfrancisco.springbootmongodb.domain.interfaces.services.IPostService;
import com.rsfrancisco.springbootmongodb.resources.models.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/posts")
public class PostResource {
    @Autowired private IPostService _postService;


    @GetMapping(value="/{id}")
    public ResponseEntity<ApiResponse<PostDTO>> findById(@PathVariable String id) {
        Post post = _postService.findById(id);
        PostDTO result = PostDTO.map(post);
        return ResponseEntity.ok().body(ApiResponse.success(result));
    }

    @PostMapping(value="/{id}/comments")
    public ResponseEntity<ApiResponse<Boolean>> postComment(@PathVariable String id, @RequestBody CommentDTO dto) {
        Comment comment = CommentDTO.map(dto);
        boolean result = _postService.insertCommentByPostId(id, dto);
        return ResponseEntity.ok().body(ApiResponse.success(result));
    }
}

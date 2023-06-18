package com.rsfrancisco.springbootmongodb.resources;

import com.rsfrancisco.springbootmongodb.application.dto.PostDTO;
import com.rsfrancisco.springbootmongodb.application.dto.UserDTO;
import com.rsfrancisco.springbootmongodb.domain.utils.Helpers;
import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import com.rsfrancisco.springbootmongodb.domain.entities.User;
import com.rsfrancisco.springbootmongodb.domain.interfaces.services.IUserService;
import com.rsfrancisco.springbootmongodb.resources.models.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserResource {

    @Autowired
    private IUserService _userService;

    @GetMapping
    //@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ApiResponse<List<UserDTO>>> findAll() {
        List<User> users = _userService.findAll();
        List<UserDTO> result = users.stream().map(c -> new UserDTO(c)).toList();
        return ResponseEntity.ok().body(ApiResponse.success(result));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> findById(@PathVariable String id) {
        User user = _userService.findById(id);
        UserDTO result = new UserDTO(user);
        return ResponseEntity.ok().body(ApiResponse.success(result));
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDTO dto) {
        User newUser = UserDTO.map(dto);
        newUser = _userService.insert(newUser);
        URI uri = Helpers.getURI("/{id}", newUser.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping
    public ResponseEntity<ApiResponse<User>> update(@RequestBody UserDTO dto) {
        User user = UserDTO.map(dto);
        user = _userService.update(user);
        return ResponseEntity.ok().body(ApiResponse.success(user));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        _userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<ApiResponse<List<PostDTO>>> findUserPostsById(@PathVariable String id) {
        List<Post> posts = _userService.getUserPosts(id);
        List<PostDTO> result = PostDTO.map(posts);
        return ResponseEntity.ok().body(ApiResponse.success(result));
    }

    @PostMapping(value="/{id}/posts")
    public ResponseEntity<Boolean> createUserPost(@PathVariable String id, @RequestBody PostDTO obj) {
        Post post = PostDTO.map(obj);
        boolean result = _userService.insertPost(id, post);
        URI uri = Helpers.getURI("/{id}", id);
        return ResponseEntity.created(uri).build();
    }

}
/*
*/
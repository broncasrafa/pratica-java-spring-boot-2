package com.rsfrancisco.springbootmongodb.resources;

import com.rsfrancisco.springbootmongodb.application.dto.UserDTO;
import com.rsfrancisco.springbootmongodb.domain.Utils.Helpers;
import com.rsfrancisco.springbootmongodb.domain.entities.User;
import com.rsfrancisco.springbootmongodb.domain.interfaces.services.IUserService;
import com.rsfrancisco.springbootmongodb.resources.models.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
}

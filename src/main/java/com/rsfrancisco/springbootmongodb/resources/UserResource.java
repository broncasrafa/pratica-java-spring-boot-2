package com.rsfrancisco.springbootmongodb.resources;

import com.rsfrancisco.springbootmongodb.application.dto.UserDTO;
import com.rsfrancisco.springbootmongodb.domain.entities.User;
import com.rsfrancisco.springbootmongodb.domain.interfaces.services.IUserService;
import com.rsfrancisco.springbootmongodb.resources.models.response.ApiResponse;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/api/v1/users")
public class UserResource {

    @Autowired
    private IUserService _userService;

    @GetMapping
    //@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> users = _userService.findAll();
        List<UserDTO> result = users.stream().map(c -> new UserDTO(c)).toList();
        return ResponseEntity.ok().body(result);
    }
}

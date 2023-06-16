package com.rsfrancisco.springbootmongodb.resources;

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

@RestController
@RequestMapping(value="/api/v1/users")
public class UserResource {

    @Autowired
    private IUserService _userService;

    @GetMapping
    //@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(_userService.findAll());
    }
}

package com.rsfrancisco.springbootmongodb.domain.interfaces.repositories;

import com.rsfrancisco.springbootmongodb.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends MongoRepository<User, String> {

}

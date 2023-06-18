package com.rsfrancisco.springbootmongodb.domain.interfaces.repositories;

import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import com.rsfrancisco.springbootmongodb.domain.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IPostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContainingIgnoreCase(String term);

    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> findByTitle(String term);

    @Query("{ $and: [ { 'createdAt': { $gte: { '$date': ?1} } }, { 'createdAt': { $lte: { '$date': ?2} } } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> findByAnyTextAndDate(String text, Date minDate, Date maxDate);
}

package com.rsfrancisco.springbootmongodb.application.configuration;

import com.rsfrancisco.springbootmongodb.application.dto.AuthorDTO;
import com.rsfrancisco.springbootmongodb.domain.entities.Post;
import com.rsfrancisco.springbootmongodb.domain.entities.User;
import com.rsfrancisco.springbootmongodb.domain.interfaces.repositories.IPostRepository;
import com.rsfrancisco.springbootmongodb.domain.interfaces.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SeedDatabaseConfiguration implements CommandLineRunner {

    @Autowired private IUserRepository _userRepository;
    @Autowired private IPostRepository _postRepository;


    @Override
    public void run(String... args) throws Exception {
//        _postRepository.deleteAll();
//        _userRepository.deleteAll();
//
//        User u1 = new User("Rafael Francisco", "rafael.francisco@test.com");
//        User u2 = new User("Isabella Francisco", "isabella.francisco@test.com");
//        _userRepository.saveAll(Arrays.asList(u1, u2));
//
//        Post p1 = new Post("Eu amo roblox", "Gente, eu fiz meu primeiro post!", new AuthorDTO(u2));
//        Post p2 = new Post("Dicas no Bloxburg", "Gente, nesse post eu vou dar varias dicas para o Bloxburg!", new AuthorDTO(u2));
//        Post p3 = new Post("Modric vai deitar", "Hj a grande final, vamos Modric estou torcendo por vc!", new AuthorDTO(u1));
//        _postRepository.saveAll(Arrays.asList(p1, p2, p3));
//
//        u2.getPosts().addAll(Arrays.asList(p1,p2));
//        _userRepository.save(u2);
//        u1.getPosts().addAll(Arrays.asList(p3));
//        _userRepository.save(u1);
    }
}

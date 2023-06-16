package com.rsfrancisco.springbootmongodb.application.configuration;

import com.rsfrancisco.springbootmongodb.domain.entities.User;
import com.rsfrancisco.springbootmongodb.domain.interfaces.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class SeedDatabaseConfiguration implements CommandLineRunner {

    @Autowired
    private IUserRepository _userRepository;

    @Override
    public void run(String... args) throws Exception {
        //_userRepository.deleteAll();
        User u1 = new User("Monica Mattos", "monica.mattos@test.com");
        User u2 = new User("Rugal Bernstein", "rugal.bernstein@test.com");
        User u3 = new User("Victoria Medeiros", "victoria.medeiros@test.com");
        User u4 = new User("Kesha Linn", "kesha_nyon_@test.com");
        User u5 = new User("Cibelly Ferreira", "cibellyferreiraprofessora_@test.com");
        User u6 = new User("Jennifer Lawrence", "jennifer_lawrence@test.com");
        //_userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
    }
}

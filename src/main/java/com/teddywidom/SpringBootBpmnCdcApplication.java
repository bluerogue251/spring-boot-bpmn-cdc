package com.teddywidom;

import com.teddywidom.model.User;
import com.teddywidom.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringBootBpmnCdcApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootBpmnCdcApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBpmnCdcApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repo) {
        return (args) -> {
            // TODO: use a better test data creation mechanism
            // Delete all users in the db to start fresh
            repo.deleteAll();

            // Create several standard users for dev data
            User jackBauer = new User("Jack", "Bauer", "jack@example.com", new BCryptPasswordEncoder().encode("blargh"));
            repo.save(jackBauer);
            repo.save(new User("Chloe", "O'Brian", "chloe@example.com", new BCryptPasswordEncoder().encode("blargh")));
            repo.save(new User("Kim", "Bauer", "kim@example.com", new BCryptPasswordEncoder().encode("blargh")));
            repo.save(new User("David", "Palmer", "david@example.com", new BCryptPasswordEncoder().encode("blargh")));
            repo.save(new User("Michelle", "Dessler", "michelle@example.com", new BCryptPasswordEncoder().encode("blargh")));
        };
    }
}

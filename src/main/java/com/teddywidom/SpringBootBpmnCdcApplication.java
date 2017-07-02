package com.teddywidom;

import com.teddywidom.model.User;
import com.teddywidom.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootBpmnCdcApplication {

    private static final Logger log = LoggerFactory.getLogger(SpringBootBpmnCdcApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBpmnCdcApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(UserRepository repo) {
        return (args) -> {
            // save a couple of customers
            User jackBauer = new User("Jack", "Bauer");
            repo.save(jackBauer);
            repo.save(new User("Chloe", "O'Brian"));
            repo.save(new User("Kim", "Bauer"));
            repo.save(new User("David", "Palmer"));
            repo.save(new User("Michelle", "Dessler"));

            // fetch all Users
            log.info("Users found with findAll():");
            log.info("-------------------------------");
            for (User User : repo.findAll()) {
                log.info(User.toString());
            }
            log.info("");
        };
    }
}
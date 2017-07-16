package com.teddywidom;

import com.teddywidom.model.Batch;
import com.teddywidom.model.User;
import com.teddywidom.repo.BatchRepository;
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

    // TODO understand how the application knows here how to instantiate the correct UserRepository implementation
    @Bean
    public CommandLineRunner demo(UserRepository userRepo, BatchRepository batchRepo) {
        return (args) -> {
            // TODO: use a better test data creation mechanism
            // Delete all records in the db to start fresh
            // Then create several standard records for dev data
            userRepo.deleteAll();
            userRepo.save(new User("Jack", "Bauer", "jack@example.com", new BCryptPasswordEncoder().encode("blargh")));
            userRepo.save(new User("Chloe", "O'Brian", "chloe@example.com", new BCryptPasswordEncoder().encode("blargh")));
            userRepo.save(new User("Kim", "Bauer", "kim@example.com", new BCryptPasswordEncoder().encode("blargh")));
            batchRepo.deleteAll();
            batchRepo.save(new Batch("1234567ghfds", "microarray"));
            batchRepo.save(new Batch("7654321bbrfb", "microarray"));
            batchRepo.save(new Batch("7654321bbrfb", "nextGenerationSequencing"));
            batchRepo.save(new Batch("9876234uhytr", "sangerSequencing"));
        };
    }
}

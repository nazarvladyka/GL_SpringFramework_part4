package com.nazarvladyka;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nazarvladyka.domain.Hero;
import com.nazarvladyka.service.HeroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class JsonDBApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonDBApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(HeroService heroService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Hero>> typeReference = new TypeReference<List<Hero>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/heroes.json");
            try {
                List<Hero> heroes = mapper.readValue(inputStream, typeReference);
//                List<User> users = mapper.readValue(inputStream,typeReference);
                heroService.save(heroes);
                System.out.println("Heroes Saved!");
            } catch (IOException e){
                System.out.println("Unable to save heroes: " + e.getMessage());
            }
        };
    }
}
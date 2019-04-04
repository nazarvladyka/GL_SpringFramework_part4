package com.nazarvladyka;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nazarvladyka.domain.Hero;
import com.nazarvladyka.service.HeroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//@SpringBootApplication
//public class JsonDBApplication {
//
//    public static void main(String[] args) {
//        SpringApplication.run(JsonDBApplication.class, args);
//    }
//
//    @Bean
//    CommandLineRunner runner(HeroService heroService) {
//        return args -> {
//            // read json and write to db
//            ObjectMapper mapper = new ObjectMapper();
//            TypeReference<List<Hero>> typeReference = new TypeReference<List<Hero>>(){};
//            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/heroes.json");
//            try {
//                List<Hero> heroes = mapper.readValue(inputStream, typeReference);
////                List<User> users = mapper.readValue(inputStream,typeReference);
//                heroService.save(heroes);
//                System.out.println("Heroes Saved!");
//            } catch (IOException e){
//                System.out.println("Unable to save heroes: " + e.getMessage());
//            }
//        };
//    }
//}

@SpringBootApplication
public class JsonDBApplication {

    public static void main(String args[]) {
        SpringApplication.run(JsonDBApplication.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(HeroService heroService) throws Exception {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
            Hero hero1 = restTemplate.getForObject(
                    "https://swapi.co/api/people/1", Hero.class);
            Hero hero2 = restTemplate.getForObject(
                    "https://swapi.co/api/people/2", Hero.class);
            heroService.save(hero1);
            heroService.save(hero2);

            System.out.println(hero1);
            System.out.println(hero2);
        };
    }
}
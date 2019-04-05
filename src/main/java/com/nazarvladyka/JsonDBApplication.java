package com.nazarvladyka;

//import com.nazarvladyka.domain.Hero;
//import com.nazarvladyka.domain.Search;
//import com.nazarvladyka.service.HeroService;
import com.nazarvladyka.domain.Hero;
import com.nazarvladyka.repository.HeroRepository;
import com.nazarvladyka.service.HeroService;
        import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
    public CommandLineRunner run(HeroService heroService) {
        return args -> {
            RestTemplate restTemplate = new RestTemplate();

            Hero hero;

            hero = restTemplate.getForObject("https://swapi.co/api/people/3", Hero.class);
            heroService.save(hero);

            System.out.println("all heroes saved");
        };
    }
}
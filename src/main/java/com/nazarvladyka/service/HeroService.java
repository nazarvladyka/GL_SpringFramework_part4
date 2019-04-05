package com.nazarvladyka.service;

import com.nazarvladyka.domain.Hero;
import com.nazarvladyka.repository.HeroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class HeroService {
    private HeroRepository heroRepository;
    private RestTemplate restTemplate = new RestTemplate();

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Iterable<Hero> list() {
        return heroRepository.findAll();
    }

    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    public Iterable<Hero> save(List<Hero> results) {
        return heroRepository.saveAll(results);
    }

    public Hero getHero(long id) {
        return heroRepository.findById(id).orElse(null);
    }

    public Hero addHero(long id) {
        Hero hero = restTemplate.getForObject("https://swapi.co/api/people/" + id, Hero.class);
        save(hero);
        return hero;
    }

    public boolean isTaller(long heroId1, long heroId2) {
        Hero hero1 = heroRepository.findById(heroId1).orElse(null);
        Hero hero2 = heroRepository.findById(heroId2).orElse(null);

        int height1 = Integer.parseInt(hero1.getHeight());
        int height2 = Integer.parseInt(hero2.getHeight());
        return height1 > height2;
    }
}
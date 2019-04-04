package com.nazarvladyka.service;

import com.nazarvladyka.domain.Hero;
import com.nazarvladyka.repository.HeroRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class HeroService {
    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public Iterable<Hero> list() {
        return heroRepository.findAll();
    }

    public Hero save(Hero hero) {
        return heroRepository.save(hero);
    }

    public Iterable<Hero> save(List<Hero> heroes) {
        return heroRepository.saveAll(heroes);
    }

    public Hero getHero(long id) {
        return heroRepository.findById(id).orElse(null);
    }

    public Hero getHeight(String name) {
        return heroRepository.getHeroByName(name);
    }
}
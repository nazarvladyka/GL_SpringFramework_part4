package com.nazarvladyka.controller;

import com.nazarvladyka.domain.Hero;
import com.nazarvladyka.service.HeroService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private HeroService heroService;

    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    @GetMapping("/list")
    public Iterable<Hero> list() {
        return heroService.list();
    }

    @GetMapping("/{id}")
    public Hero getHero(@PathVariable int id) {
        return heroService.getHero(id);
    }

    @PostMapping("/add/{heroId1}/{heroId2}")
    public List<Hero> create(
            @PathVariable long heroId1,
            @PathVariable long heroId2) {

        List<Hero> heroes = new ArrayList<>();
        heroes.add(heroService.addHero(heroId1));
        heroes.add(heroService.addHero(heroId2));

        return heroes;
    }

    @GetMapping("/{heroId1}/istaller/{heroId2}")
    public String whoTaller(
            @PathVariable long heroId1,
            @PathVariable long heroId2) {
        boolean isTaller = heroService.isTaller(heroId1, heroId2);

        Hero hero1 = heroService.getHero(heroId1);
        Hero hero2 = heroService.getHero(heroId2);

        if(isTaller) {
            return hero1.getName() + "(" + hero1.getHeight() + ")"
                    + " is taller than " +
                    hero2.getName() + "(" + hero2.getHeight() + ")";
        } else {
            return hero2.getName() + "(" + hero2.getHeight() + ")"
                    + " is taller than " +
                    hero1.getName() + "(" + hero1.getHeight() + ")";
        }
    }
}
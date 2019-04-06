package com.nazarvladyka.controller;

import com.nazarvladyka.domain.Hero;
import com.nazarvladyka.service.impl.HeroServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private HeroServiceImpl heroServiceImpl;

    public HeroController(HeroServiceImpl heroServiceImpl) {
        this.heroServiceImpl = heroServiceImpl;
    }

    //http://localhost:8080/heroes/list
    @GetMapping("/list")
    public Iterable<Hero> list() {
        return heroServiceImpl.list();
    }

    //http://localhost:8080/heroes/{id}
    @GetMapping("/{id}")
    public Hero getHero(@PathVariable int id) {
        return heroServiceImpl.getHero(id);
    }

    //http://localhost:8080/heroes/add/{heroId}
    @PostMapping("/add/{heroId}")
    public Hero save(@PathVariable long heroId) {
        return heroServiceImpl.save(heroId);
    }

    //http://localhost:8080/heroes/{heroId1}/istaller/{heroId2}
    @GetMapping("/{heroId1}/istaller/{heroId2}")
    public String whoTaller(
            @PathVariable long heroId1,
            @PathVariable long heroId2) {

        return heroServiceImpl.isTaller(heroId1, heroId2);
    }
}
package com.nazarvladyka.controller;

import com.nazarvladyka.domain.Hero;
import com.nazarvladyka.service.HeroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Hero getHero(@PathVariable long id) {
        return heroService.getHero(id);
    }

    @GetMapping("height/{name}")
    public Hero getHero(@PathVariable String name) {
        return heroService.getHeight(name);
    }
}
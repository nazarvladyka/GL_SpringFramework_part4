package com.nazarvladyka.service;

import com.nazarvladyka.domain.Hero;

public interface HeroService {
    Iterable<Hero> list();

    Hero getHero(long id);

    Hero save(long id);

    String isTaller(long heroId1, long heroId2);

    Iterable<Hero> findHeroesByHomeWorld(String url);

    int getAverageHeight(Iterable<Hero> heroes);

    void addHeight(int height);
}
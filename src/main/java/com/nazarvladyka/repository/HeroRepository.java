package com.nazarvladyka.repository;

import com.nazarvladyka.domain.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroRepository extends CrudRepository<Hero, Long> {
    Hero getHeroByName(String name);
}
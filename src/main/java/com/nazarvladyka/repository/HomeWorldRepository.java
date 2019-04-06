package com.nazarvladyka.repository;

import com.nazarvladyka.domain.HomeWorld;
import org.springframework.data.repository.CrudRepository;

public interface HomeWorldRepository extends CrudRepository<HomeWorld, Long> {
    HomeWorld findByUrlEquals(String url);
}
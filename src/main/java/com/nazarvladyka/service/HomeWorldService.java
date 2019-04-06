package com.nazarvladyka.service;

import com.nazarvladyka.domain.HomeWorld;

public interface HomeWorldService {

    HomeWorld save(String url);

    HomeWorld getHomeWorld(String homeUrl);
}

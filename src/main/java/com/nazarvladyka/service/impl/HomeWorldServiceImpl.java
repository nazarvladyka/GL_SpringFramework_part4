package com.nazarvladyka.service.impl;

import com.nazarvladyka.domain.HomeWorld;
import com.nazarvladyka.repository.HomeWorldRepository;
import com.nazarvladyka.service.HomeWorldService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HomeWorldServiceImpl implements HomeWorldService {
    private HomeWorldRepository homeWorldRepository;
    private RestTemplate restTemplate = new RestTemplate();

    public HomeWorldServiceImpl(HomeWorldRepository homeWorldRepository) {
        this.homeWorldRepository = homeWorldRepository;
    }

    @Override
    public HomeWorld save(String url) {
        HomeWorld homeWorld = restTemplate.getForObject(url, HomeWorld.class);
        return homeWorldRepository.save(homeWorld);
    }

    @Override
    public HomeWorld getHomeWorld(String homeUrl) {
        return homeWorldRepository.findByUrlEquals(homeUrl);
    }
}
package com.nazarvladyka.service.impl;

import com.nazarvladyka.domain.Hero;
import com.nazarvladyka.repository.HeroRepository;
import com.nazarvladyka.service.HeroService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HeroServiceImpl implements HeroService {

    private HomeWorldServiceImpl homeWorldServiceImpl;
    private HeroRepository heroRepository;
    private RestTemplate restTemplate = new RestTemplate();

    public HeroServiceImpl(HeroRepository heroRepository, HomeWorldServiceImpl homeWorldServiceImpl) {
        this.heroRepository = heroRepository;
        this.homeWorldServiceImpl = homeWorldServiceImpl;
    }

    @Override
    public Iterable<Hero> list() {
        return heroRepository.findAll();
    }

    @Override
    public Hero getHero(long id) {
        return heroRepository.findById(id).orElse(null);
    }

    @Override
    public Hero save(long id) {
        Hero hero = restTemplate.getForObject("https://swapi.co/api/people/" + id, Hero.class);
        return heroRepository.save(hero);
    }

    @Override
    public String isTaller(long heroId1, long heroId2) {
        Hero hero1 = heroRepository.findById(heroId1).orElse(null);
        Hero hero2 = heroRepository.findById(heroId2).orElse(null);

        Hero winner;
        Hero loser;

        int height1 = Integer.parseInt(hero1.getHeight());
        int height2 = Integer.parseInt(hero2.getHeight());

        boolean isTaller = height1 > height2;
        winner = isTaller ? hero1 : hero2;
        loser = !isTaller ? hero1 : hero2;

        String homeUrl = winner.getHomeworld();
        homeWorldServiceImpl.save(homeUrl);
        String homeName = homeWorldServiceImpl.getHomeWorld(homeUrl).getName();
        Iterable<Hero> fromOnePlanet = findHeroesByHomeWorld(homeUrl);

        String result = Integer.parseInt(winner.getHeight()) > getAverageHeight(fromOnePlanet) ? "taller" : "smaller";

        return winner.getName() + "(" + winner.getHeight() + ")"
                    + " is taller than " +
                    loser.getName() + "(" + loser.getHeight() + ")" + " and " + result + " than average hero living on " +
                homeName + "(" + getAverageHeight(fromOnePlanet) + ")";
    }

    @Override
    public Iterable<Hero> findHeroesByHomeWorld(String url) {
        return heroRepository.findHeroesByHomeworldEquals(url);
    }

    public static int sum = 0;
    public static int count = 0;

    @Override
    public int getAverageHeight(Iterable<Hero> heroes) {
        heroes.forEach(x -> addHeight(Integer.parseInt(x.getHeight())));
        return sum / count;
    }

    @Override
    public void addHeight(int height) {
        sum += height;
        count++;
    }
}
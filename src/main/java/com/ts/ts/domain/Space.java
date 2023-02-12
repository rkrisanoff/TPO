package com.ts.ts.domain;



import java.util.HashSet;
import java.util.Set;

public class Space {

    private final Set<Human> astronauts = new HashSet<>();

    public Set<Star> getStars() {
        return this.stars;
    }

    private final Set<Star> stars = new HashSet<>();

    public void addNewAstronaut(Human human) throws Exception{
        if (this.astronauts.contains(human)) throw new Exception("Этот человек уже летает в космосе!");
        this.astronauts.add(human);
    }

    public void addNewStar(Star star) throws Exception {
        if (this.stars.contains(star)) throw new Exception("Такая звезда уже существует!");
        this.stars.add(star);
    }


}

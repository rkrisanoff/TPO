package com.ts.ts.domain;

import lombok.Getter;

import java.util.Set;

@Getter
public class Rocket {

    private final Set<Human> team;
    private final Engine engine = new Engine();
    private Integer fuel = 100;
    private Integer speed = 0;

    public Rocket(Set<Human> team) {
        this.team = team;
    }

    // Совершить полет
    public void fly(int distance) throws Exception {
        if (distance <= 0) throw new Exception("Wrong distance");
        if (this.fuel - distance < 0) throw new Exception("The fuel is not enough to fly");
        this.increaseSpeed();
        this.fuel -= distance;
        this.decreaseSpeed();
    }

    //Увеличить скорость
    public void increaseSpeed() throws Exception {
        this.engine.increaseSound();
        this.speed += 100;
    }

    //Увеличить скорость
    public void decreaseSpeed() throws Exception {
        this.engine.decreaseSound();
        this.speed -= 100;
    }

    // Выбросить человека в космос
    public void throwHumanIntoTheSpace(String name, Space space) throws Exception {
        if (this.team.isEmpty()) throw new Exception("There are not a team in spaceship!");
        Human teammate = this.team.stream().filter(new Human(name)::equals).findAny()
                .orElseThrow(() -> new Exception("There is not a man in spaceship!"));
        space.addNewAstronaut(teammate);
        this.team.remove(teammate);
    }

}

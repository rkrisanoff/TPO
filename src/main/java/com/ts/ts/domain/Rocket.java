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
    public void fly(int value) throws Exception {
        if (value <= 0) throw new Exception("Нельзя пролететь отрицательное расстояние!");
        if (this.fuel - value < 0) throw new Exception("Топлива не хватит на осуществление полета!");
        this.increaseSpeed();
        this.fuel -= value;
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
        if (this.team.isEmpty()) throw new Exception("На корабле нет экипажа!");
        Human teammate = this.team.stream().filter(new Human(name)::equals).findAny()
                .orElseThrow(() -> new Exception("Такого человека нет на борту!"));
        space.addNewAstronaut(teammate);
        this.team.remove(teammate);
    }

}

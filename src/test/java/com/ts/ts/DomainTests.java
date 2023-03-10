package com.ts.ts;

import com.ts.ts.domain.*;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class DomainTests {
    @Nested
    class RocketTest {

        private Space space;
        private Set<Human> humans;
        private Rocket rocket;

        @BeforeEach
        void init() {
            space = new Space();
            humans = new HashSet<>(Arrays.asList(new Human("Форд"), new Human("Артур")));
            rocket = new Rocket(humans);
        }

        @Test
        @DisplayName("Check a really long flight")
        void checkTooBigValueToFly() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.fly(101));
            assertEquals("The fuel is not enough to fly", exception.getMessage());
        }

        @Test
        @DisplayName("Check negative value of flight")
        void checkNegativeValueOfFlight() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.fly(-1));
            assertEquals("Wrong distance", exception.getMessage());
        }

        @Test
        @DisplayName("Check zero value of flight")
        void checkZeroValueOfFlight() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.fly(0));
            assertEquals("Wrong distance", exception.getMessage());
        }

        @Test
        @DisplayName("Check normal values of flight")
        void checkNormalFlight() {
            assertAll(
                    () -> {
                        rocket.fly(7);
                        assertEquals(93, rocket.getFuel());
                    },
                    () -> {
                        rocket.fly(23);
                        assertEquals(70, rocket.getFuel());
                    },
                    () -> {
                        rocket.fly(70);
                        assertEquals(0, rocket.getFuel());
                    }
            );

            Throwable exception = assertThrows(Exception.class, () -> rocket.fly(0));
            assertEquals("Wrong distance", exception.getMessage());
        }

        @Test
        @DisplayName("Check max value of speed")
        @SneakyThrows
        void checkMaxSpeed() {
            for (int i = 0; i <= 3; i++) rocket.increaseSpeed();
            Throwable exception = assertThrows(Exception.class, () -> rocket.increaseSpeed());
            assertEquals("Incorrect level of volume", exception.getMessage());
        }

        @Test
        @DisplayName("Check min value of speed")
        void checkMinSpeed() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.decreaseSpeed());
            assertEquals("Incorrect level of volume", exception.getMessage());
        }

        @Test
        @DisplayName("Check different speed")
        @SneakyThrows
        void checkDifferentSpeed()  {
            rocket.increaseSpeed();
            rocket.increaseSpeed();
            rocket.increaseSpeed();
            rocket.decreaseSpeed();
            rocket.decreaseSpeed();
            assertEquals(100, rocket.getSpeed());
        }

        @Test
        @DisplayName("Check throw human into space")
        @SneakyThrows
        void checkThrowingHumanIntoTheSpace() {
            rocket.throwHumanIntoTheSpace("Форд", space);
            assertFalse(rocket.getTeam().contains(new Human("Форд")));
        }

        @Test
        @DisplayName("Check empty team")
        void checkEmptyTeam() {
            humans = new HashSet<>();
            rocket = new Rocket(humans);
            Throwable exception = assertThrows(Exception.class, () -> rocket.throwHumanIntoTheSpace("Елизавета", space));
            assertEquals("There are not a team in spaceship!", exception.getMessage());
        }

        @Test
        @DisplayName("Check no team member")
        void checkNoTeamMember() {
            Throwable exception = assertThrows(Exception.class, () -> rocket.throwHumanIntoTheSpace("Елизавета", space));
            assertEquals("There is not a man in spaceship!", exception.getMessage());
        }
    }

    @Nested
    class SpaceTest {

        private Space space;

        @BeforeEach
        void init() {
            space = new Space();
        }

        @Test
        @DisplayName("Check adding existing astronaut")
        @SneakyThrows
        void checkAddExistAstronaut() {
            space.addNewAstronaut(new Human("Лена"));
            Throwable exception = assertThrows(Exception.class, () -> space.addNewAstronaut(new Human("Лена")));
            assertEquals("This man is already exist!", exception.getMessage());
        }

        @Test
        @DisplayName("Check adding star")
        @SneakyThrows
        void checkAddStar() {
            space.addNewStar(new Star(Color.BLUE));
            space.addNewStar(new Star(Color.GREEN));
            space.addNewStar(new Star(Color.RED));
            assertEquals(3, space.getStars().size());
        }

        @Test
        @DisplayName("Check adding existing star")
        @SneakyThrows
        void checkAddExistStar()  {
            space.addNewStar(new Star(Color.BLUE));
            Throwable exception = assertThrows(Exception.class, () -> space.addNewStar(new Star(Color.BLUE)));
            assertEquals("This star is already exist!", exception.getMessage());
        }
    }


}

package com.example.runner_ensea;

import javafx.util.Duration;


public class Hero extends AnimatedThing {

    private double velocityY;
    private static final double GRAVITY = 300.0;
    private static final double JUMP_FORCE = -150.0;

    public Hero(double x, double y) {
        super(x, y, 0, "C:\\Users\\User\\Desktop\\Bureau\\2A ENSEA\\Cours\\JAVA\\TDs Project\\Ressources\\Ressources audio et image pour le runner-20231108\\img\\heros.png", 8, Duration.millis(100), 100, 0);
        velocityY = 0;
    }

    public boolean isOnRoad() {
        return getY() >= 150;
    }
    public void jump() {
        // Only allow jumping when the hero is on the road (y >= 150)
        if (isOnRoad()) {
            System.out.println("Jason is on road");
            velocityY = JUMP_FORCE;
        }
    }

    @Override
    public void update(long time) {
        super.update(time);

        // Apply gravity
        velocityY += GRAVITY * (time / 1_000_000_000.0);

        // Update position
        setY(getY() + velocityY * (time / 1_000_000_000.0));

        // To be sure that the hero stays above the road
        if (getY() < 150) {
            setY(150);
            velocityY = 0;
        }
    }
}

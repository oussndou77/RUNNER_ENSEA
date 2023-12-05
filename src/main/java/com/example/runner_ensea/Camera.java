package com.example.runner_ensea;
import javafx.animation.AnimationTimer;
import com.example.runner_ensea.Hero;


public class Camera {
    private Hero hero;
    private double x; // Camera position
    private double vx; // Camera velocity
    private double k = 0.2; // Spring constant
    private double m = 1.0; // Mass
    private double f = 0.5; // Damping factor

    public Camera(Hero hero, double initialOffsetX, double initialOffsetY) {
        this.hero = hero;
        // Set initial position of the camera slightly off from the hero
        this.x = hero.getX() + initialOffsetX;
        this.vx = 0;

        startTimer();
    }

    private void startTimer() {
        AnimationTimer timer = new AnimationTimer() {
            long lastTime = 0;

            @Override
            public void handle(long now) {
                if (lastTime == 0) {
                    lastTime = now;
                    return;
                }

                long deltaTime = now - lastTime;
                update(deltaTime / 1_000_000_000.0); // Convert nanoseconds to seconds
                lastTime = now;
            }
        };
        timer.start();
    }

    public void update(double deltaTime) {
        // Spring force equation
        double ax = k / m * (hero.getX() - x) + f / m * vx;

        // Update velocity and position
        double deltaVx = ax * deltaTime;
        vx += deltaVx;
        double deltaX = vx * deltaTime;
        x += deltaX;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        // Assuming the camera doesn't move vertically in this example
        return 0;
    }

    public void setX(double x) {
        this.x = x;
    }


}

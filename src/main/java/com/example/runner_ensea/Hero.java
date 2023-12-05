package com.example.runner_ensea;

import javafx.util.Duration;

public class Hero extends AnimatedThing {
    public Hero(double x, double y) {
        super(x, y, 0, "C:\\Users\\User\\Desktop\\Bureau\\2A ENSEA\\Cours\\JAVA\\TDs Project\\Ressources\\Ressources audio et image pour le runner-20231108\\img\\heros.png", 8, Duration.millis(100), 75, 100);
        // Adjust the parameters based on your actual spritesheet and requirements
    }
}
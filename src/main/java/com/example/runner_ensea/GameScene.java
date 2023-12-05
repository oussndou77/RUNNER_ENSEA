package com.example.runner_ensea;

import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.animation.AnimationTimer;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;




public class GameScene extends Scene {
    private Camera camera;
    private StaticThing backgroundLeft;
    private StaticThing backgroundRight;
    private int numberOfLives;
    private Heart[] hearts;
    private Hero hero;


    public GameScene(Camera camera) {
        super(new Group());
        this.camera = camera;
    }

    public Camera getGameCamera() {
        return camera;
    }

    // Inside the GameScene class, instanciate two StaticThing that displays the background
//(left and right) on the Scene. Create a render method in the GameScene that modify
//every position on the Scene according to the camera.
    public GameScene(Camera camera, StaticThing backgroundLeft, StaticThing backgroundRight, int numberOfLives) {
        super(new Pane());
        this.camera = camera;
        this.backgroundLeft = backgroundLeft;
        this.backgroundRight = backgroundRight;
        this.numberOfLives = numberOfLives;

        setOnMouseClicked(event -> {
            System.out.println("Jump");
            hero.jump();
        });

       /* // Add event handler for space bar press
        setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.SPACE) {
                hero.jump();
            }
        });*/

        hearts = new Heart[numberOfLives];
        for (int i = 0; i < numberOfLives; i++) {
            hearts[i] = new Heart(10 + i * 25, 10); // Adjust the positions accordingly
            ((Pane) getRoot()).getChildren().add(hearts[i].getImageView());
        }


        Pane root = (Pane) getRoot();
        root.getChildren().addAll(backgroundLeft.getImageView(), backgroundRight.getImageView());


        // Instantiate and display the Hero
        hero = new Hero(130, 500); // We can adjust the starting position as needed
        root.getChildren().add(hero.getImageView());

        camera.setX(hero.getX() - 75);


        // Start the AnimationTimer
        startTimer();

        render();

    }

    public void render() {
        double cameraX = camera.getX();
        double cameraY = camera.getY();

        backgroundLeft.getImageView().setLayoutX(cameraX);
        backgroundLeft.getImageView().setLayoutY(cameraY);
        backgroundRight.getImageView().setLayoutX(cameraX + backgroundLeft.getSizeX());
        backgroundRight.getImageView().setLayoutY(cameraY);

        // Update heart positions based on camera or any other logic
        for (int i = 0; i < numberOfLives; i++) {
            hearts[i].getImageView().setLayoutX(10 + i * 25); // Adjust the positions accordingly
            hearts[i].getImageView().setLayoutY(10);
        }

        // Update Hero position based on camera and other logic
        hero.getImageView().setLayoutX(hero.getX() - cameraX);
        hero.getImageView().setLayoutY(hero.getY() - cameraY);
    }

    private void startTimer() {
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long time) {
                hero.update(time);
                camera.update(time);
                update(time);
            }
        };
        timer.start();
    }

    public void update(long time) {
        // Update logic for the animated thing
        // You may add specific logic related to animation updates here
    }
}

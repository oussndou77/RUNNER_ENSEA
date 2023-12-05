package com.example.runner_ensea;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;


public class RunAppli extends Application {

/*
    private ImageView sprite;

    @Override
    public void start(Stage primaryStage) {
        Image spriteSheet = new Image("C:\\Users\\User\\Desktop\\Bureau\\2A ENSEA\\Cours\\JAVA\\TDs Project\\Ressources\\Ressources audio et image pour le runner-20231108\\img\\desert.png");
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(0, 0, spriteSheet.getWidth(), spriteSheet.getHeight()));
        // sprite.setViewport(new Rectangle2D(20,0,65,100)); // Celui qui a été donné en exemple dans le projet.
        sprite.setX(200);
        sprite.setY(300);

        Group root = new Group(sprite);
        Scene scene = new Scene(root, 1200, 1000);

        primaryStage.setTitle("Runner ENSEA");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.show();
    }*/


    @Override
    public void start(Stage primaryStage) {
        String background_left = "C:\\Users\\User\\Desktop\\Bureau\\2A ENSEA\\Cours\\JAVA\\TDs Project\\Ressources\\Ressources audio et image pour le runner-20231108\\img\\desert.png";
        String background_right = "C:\\Users\\User\\Desktop\\Bureau\\2A ENSEA\\Cours\\JAVA\\TDs Project\\Ressources\\Ressources audio et image pour le runner-20231108\\img\\desert.png";

        Camera camera = new Camera(20, 50); // Create a Camera object
        StaticThing backgroundLeft = new StaticThing(800, 600, background_left);
        StaticThing backgroundRight = new StaticThing(800, 600, background_right);

        GameScene gameScene = new GameScene(camera, backgroundLeft, backgroundRight, 3);
        primaryStage.setScene(gameScene);
        primaryStage.setTitle("Runner ENSEA");
        primaryStage.show();

        System.out.println( gameScene.getGameCamera());
    }


    public static void main(String[] args) {
        launch(args);
    }
}
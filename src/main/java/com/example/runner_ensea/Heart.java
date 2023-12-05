package com.example.runner_ensea;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Heart {
    private static final double HEART_SIZE = 20.0;
    private ImageView imageView;

    public Heart(double x, double y) {
        Image heartImage = new Image("C:\\Users\\User\\Desktop\\Bureau\\2A ENSEA\\Cours\\JAVA\\TDs Project\\Ressources\\Ressources audio et image pour le runner-20231108\\img\\heart.png");
        imageView = new ImageView(heartImage);
        imageView.setFitWidth(HEART_SIZE);
        imageView.setFitHeight(HEART_SIZE);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
    }

    public ImageView getImageView() {
        return imageView;
    }
}


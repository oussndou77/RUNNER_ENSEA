//Create a class ”StaticThing” that we’ll use to display static element (background or
//number of life). This class is defined by two double (sizeX,sizeY), one ImageView.
//• Create the constructor of this class. The constructor has many parameters, one of which
//is a String fileName to point to the Background.
//• Create a getter for the ImageView member of the class.
//• Add to the gameScene class two StaticThings for the BackGround, one left and one
//right.• Inside the GameScene class, instanciate two StaticThing that displays the background
//(left and right) on the Scene. Create a render method in the GameScene that modify
//every position on the Scene according to the camera.
//• Test your code with different value for the camera’s position.
package com.example.runner_ensea;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    private double sizeX;
    private double sizeY;
    private ImageView imageView;

    public StaticThing(double sizeX, double sizeY, String fileName) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        Image image = new Image(fileName);
        imageView = new ImageView(image);
        imageView.setFitWidth(sizeX);
        imageView.setFitHeight(sizeY);

    }

    public double getSizeX() {
        return sizeX;
    }
    public double getSizeY() {
        return sizeY;
    }

    public void setSizeX(double sizeX) {
        this.sizeX = sizeX;
    }
    public void setSizeY(double sizeY) {
        this.sizeY = sizeY;
    }

    public ImageView getImageView() {
        return imageView;
    }
}


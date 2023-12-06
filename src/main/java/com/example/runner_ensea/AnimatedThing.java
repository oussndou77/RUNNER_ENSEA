package com.example.runner_ensea;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private ImageView imageView;
    private int attitude;
    private int currentIndex;
    private Duration frameDuration;
    private int maxIndex;
    private int windowSize;
    private int frameOffset;
    private Timeline animation;

    public AnimatedThing(double x, double y, int attitude, String fileName, int maxIndex,
                         Duration frameDuration, int windowSize, int frameOffset) {
        this.x = x;
        this.y = y;
        this.attitude = attitude;
        this.maxIndex = maxIndex;
        this.frameDuration = frameDuration;
        this.windowSize = windowSize;
        this.frameOffset = frameOffset;

        Image spriteSheet = new Image(fileName);
        imageView = new ImageView(spriteSheet);
        imageView.setViewport(new Rectangle2D(75, 100, windowSize, windowSize));

        currentIndex = 0;


        animation = new Timeline(
                new KeyFrame(frameDuration, event -> {
                    currentIndex = (currentIndex +2) % maxIndex;
                    updateViewport();
                })
        );
        animation.setCycleCount(Animation.INDEFINITE);

        playAnimation();

    }

    private void updateViewport() {
        double offsetX = currentIndex * windowSize + attitude * frameOffset;
        imageView.setViewport(new Rectangle2D(offsetX, 0, windowSize, windowSize));
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void playAnimation() {
        animation.play();
    }

    public void stopAnimation() {
        animation.stop();
    }
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void update(long time) {
        double elapsedSeconds = time / 1_000_000_000.0; // Convert nanoseconds to seconds
        double speed = 100.0;

        double deltaX = speed * elapsedSeconds;
        setX(getX() + deltaX);

        // S'assurez-vous que le héros ne recule pas en ajustant la valeur de X
        if (getX() < 0) {
            setX(0);
        }
    }


}

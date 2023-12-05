package com.example.runner_ensea;

// Create ”Camera” class.

public class Camera {
    //• This very basic class (at first) is just two sets of coordinates (x and y), with getter
//methods.
//• The constructor of this class takes two Integer arguments.
//• Overload the ”toString” method to display x and y comma separated.
    private int x ;
    private int y ;
    // Getter methods.
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    // Constructor
    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // toString method.
    @Override
    public String toString() {
        return "Camera [x=" + x + ", y=" + y + "]";
    }

    public void update(long time) {
        // Update logic for the animated thing
        // You may add specific logic related to animation updates here
    }
}


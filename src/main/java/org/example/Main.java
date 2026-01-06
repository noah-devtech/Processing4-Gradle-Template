package org.example;

import processing.core.PApplet;


public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main(Main.class.getName());
    }

    @Override
    public void settings() {
        size(800, 600, P2D);
    }

    @Override
    public void setup() {
        background(0);
    }

    @Override
    public void draw() {
        stroke(255);
        line(mouseX, mouseY, pmouseX, pmouseY);
    }
}
package gameObjects.AlienObjects;

import interfaces.MovementBehavior;
import ui.ViewController;
import util.Image;
import java.util.Random;

import gameObjects.MovementBehavior.*;

public class UFO extends Alien {
    private static Image sprite = new Image("src/assets/UFO.png", 40, 40);
    private int speed;
    private MovementBehavior behavior;

    public UFO(int speed) {
        this(speed, initializeUFO(speed));
    }

    private UFO(int speed, UFOInitializationData initData) {
        super(initData.xPosition, 0, sprite, initData.scoreValue);
        this.speed = speed;
        this.behavior = initData.behavior;
    }

    private static UFOInitializationData initializeUFO(int speed) {
        Random rand = new Random();
        boolean startFromLeft = rand.nextBoolean();
        int screenWidth = ViewController.getWindowSize().width;
        int xPosition = startFromLeft ? 0 : screenWidth;
        int scoreValue = (int) (Math.random() * 100);
        MovementBehavior behavior = startFromLeft ? new LinearRight() : new LinearLeft();

        return new UFOInitializationData(xPosition, scoreValue, behavior);
    }

    // Call this method every frame to update the UFO's position
    public void update() {
        behavior.execute(this, speed);
    }

    public boolean isOutOfBounds() {
        int screenWidth = ViewController.getWindowSize().width;
        return getX() < 0 || getX() > screenWidth;
    }

    // Inner class to hold UFO initialization data
    private static class UFOInitializationData {
        int xPosition;
        int scoreValue;
        MovementBehavior behavior;

        UFOInitializationData(int xPosition, int scoreValue, MovementBehavior behavior) {
            this.xPosition = xPosition;
            this.scoreValue = scoreValue;
            this.behavior = behavior;
        }
    }
}

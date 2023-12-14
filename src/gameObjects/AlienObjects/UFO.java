package gameObjects.AlienObjects;

import interfaces.MovementBehavior;
import ui.ViewController;
import util.Image;
import java.util.Random;

import gameObjects.MovementBehavior.*;

/**
 * Represents a UFO object in the game, extending the Alien class.
 * The UFO has its own movement behavior and speed, and it can appear from either side of the screen.
 */
public class UFO extends Alien {
    private static Image sprite = new Image("src/assets/UFO.png", 40, 40);
    private int speed;
    private MovementBehavior behavior;

    /**
     * Constructor for UFO with a specified speed.
     *
     * @param speed the speed at which the UFO moves.
     */
    public UFO(int speed) {
        this(speed, initializeUFO(speed));
    }

    /**
     * Private constructor for UFO with speed and initialization data.
     *
     * @param speed the speed of the UFO.
     * @param initData the initialization data for the UFO.
     */
    private UFO(int speed, UFOInitializationData initData) {
        super(initData.xPosition, 0, sprite, initData.scoreValue);
        this.speed = speed;
        this.behavior = initData.behavior;
    }

    /**
     * Initializes a UFO object with random start position and behavior based on the speed.
     *
     * @param speed the speed of the UFO.
     * @return UFOInitializationData containing the initial setup data for the UFO.
     */
    private static UFOInitializationData initializeUFO(int speed) {
        Random rand = new Random();
        boolean startFromLeft = rand.nextBoolean();
        int screenWidth = ViewController.getWindowSize().width;
        int xPosition = startFromLeft ? 0 : screenWidth;
        int scoreValue = (int) (Math.random() * 100);
        MovementBehavior behavior = startFromLeft ? new LinearRight() : new LinearLeft();

        return new UFOInitializationData(xPosition, scoreValue, behavior);
    }

    /**
     * Updates the UFO's position based on its behavior and speed.
     * This method should be called every frame to move the UFO.
     */    public void update() {
        behavior.execute(this, speed);
    }

    /**
     * Checks if the UFO is out of the game screen bounds.
     *
     * @return true if the UFO is out of bounds, false otherwise.
     */
    public boolean isOutOfBounds() {
        int screenWidth = ViewController.getWindowSize().width;
        return getX() < 0 || getX() > screenWidth;
    }

    /**
     * Inner class for holding UFO initialization data.
     * This class encapsulates the position, score value, and movement behavior of a UFO.
     */
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

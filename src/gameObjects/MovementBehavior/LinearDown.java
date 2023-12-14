package gameObjects.MovementBehavior;

import interfaces.MovementBehavior;
import interfaces.Moving;

/**
 * Implements a linear downward movement behavior for game objects.
 * This class defines how a game object should move straight down.
 */
public class LinearDown implements MovementBehavior {

    /**
     * Executes the linear downward movement on a given object.
     * The object is moved downward by a distance proportional to the specified speed.
     *
     * @param object The object to be moved.
     * @param speed The speed at which the object should move downward.
     */
    @Override
    public void execute(Moving object, int speed) {
        object.translate(0, 1 * speed);
    }
}

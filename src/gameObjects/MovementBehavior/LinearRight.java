package gameObjects.MovementBehavior;

import interfaces.MovementBehavior;
import interfaces.Moving;

/**
 * Implements a linear rightward movement behavior for game objects.
 * This class defines how a game object should move straight to the right.
 */
public class LinearRight implements MovementBehavior {

    /**
     * Executes the linear rightward movement on a given object.
     * The object is moved to the right by a distance proportional to the specified speed.
     *
     * @param object The object to be moved.
     * @param speed The speed at which the object should move rightward.
     */
    @Override
    public void execute(Moving object, int speed) {
        object.translate(1 * speed, 0);
    }
}

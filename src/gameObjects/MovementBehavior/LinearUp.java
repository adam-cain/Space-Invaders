package gameObjects.MovementBehavior;

import interfaces.MovementBehavior;
import interfaces.Moving;

/**
 * Implements a linear upward movement behavior for game objects.
 * This class defines how a game object should move straight up.
 */
public class LinearUp implements MovementBehavior {

    /**
     * Executes the linear upward movement on a given object.
     * The object is moved upward by a distance proportional to the specified speed.
     *
     * @param object The object to be moved.
     * @param speed The speed at which the object should move upward.
     */
    @Override
    public void execute(Moving object, int speed) {
        object.translate(0, -1 * speed);
    }
}

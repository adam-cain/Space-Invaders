package gameObjects.MovementBehavior;

import interfaces.MovementBehavior;
import interfaces.Moving;

/**
 * Implements a linear leftward movement behavior for game objects.
 * This class defines how a game object should move straight to the left.
 */
public class LinearLeft implements MovementBehavior {

    /**
     * Executes the linear leftward movement on a given object.
     * The object is moved left by a distance proportional to the specified speed.
     *
     * @param object The object to be moved.
     * @param speed The speed at which the object should move leftward.
     */
    @Override
    public void execute(Moving object, int speed) {
        object.translate(-1 * speed, 0);
    }
}

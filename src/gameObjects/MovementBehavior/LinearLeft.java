package gameObjects.MovementBehavior;

import interfaces.MovementBehavior;
import interfaces.Moving;

public class LinearLeft implements MovementBehavior {
    @Override
    public void execute(Moving object, int speed) {
        object.translate(-1 * speed, 0);
    }
}
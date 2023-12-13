package gameObjects.MovementBehavior;

import interfaces.MovementBehavior;
import interfaces.Moving;

public class LinearUp implements MovementBehavior {
    @Override
    public void execute(Moving object, int speed) {
        object.translate(0, -1 * speed);
    }
}

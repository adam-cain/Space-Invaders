package handler.InputHandlers;

import gameObjects.Player;
import interfaces.Handler;

enum KeyCode{
    SPACE,
    A,
    D,
    ARROW_LEFT,
    ARROW_RIGHT,
}

public abstract class InputHandler implements Handler<KeyCode> {
    private Handler<KeyCode> next;
    protected Player player;

    public InputHandler(Player player) {
        this.player = player;
    }

    @Override
    public void setNext(Handler<KeyCode> next) {
        this.next = next;
    }

    @Override
    public Handler<KeyCode> getNext() {
        return next;
    }
}
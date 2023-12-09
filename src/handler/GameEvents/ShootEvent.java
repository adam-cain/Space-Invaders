package handler.GameEvents;

import interfaces.Shootable;

public class ShootEvent extends GameEvent {
    private Shootable source;

    public ShootEvent(Shootable source) {
        super(EventType.COLLISION);
        this.source = source;
    }

    public Shootable getSource() {
        return source;
    }
}

package gameObjects;

import interfaces.Collidable;
import interfaces.Movable;
import util.Image;
import util.ProjectileDirection;

public abstract class Projectile extends GameObject implements Movable, Collidable {
    private ProjectileDirection direction; 
    private static Image sprite = new Image("src/assets/missile.png", 10, 5);
    private int projectileSpeed;
    private GameObject shooter;

    public Projectile(int xPosition, int yPosition, int projectileSpeed, ProjectileDirection projectileDirection, GameObject shooter) {
        super(xPosition, yPosition, getSprite());
        this.direction = projectileDirection;
        this.projectileSpeed = projectileSpeed;
        this.shooter = shooter;
    }

    static Image getSprite() {
        
    }

    GameObject getThis() {
        return shooter;
    }

    public void update() {
        switch (direction) {
            case UP:
                translate(0, -1 * projectileSpeed);
                break;
            case DOWN:
                translate(0, 1 * projectileSpeed);
                break;
        }
    }
}

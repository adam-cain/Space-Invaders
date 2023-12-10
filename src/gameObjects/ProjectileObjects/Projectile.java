package gameObjects.ProjectileObjects;
import gameObjects.GameObject;
import interfaces.Moving;
import interfaces.ProjectileBehavior;
import util.Image;

public class Projectile extends GameObject implements Moving {

    private ProjectileBehavior behavior;
    private GameObject shooter;
    private int projectileSpeed;

    public Projectile(int xPosition, int yPosition, ProjectileBehavior behavior, int projectileSpeed,Image sprite, GameObject shooter) {
        super(xPosition, yPosition, sprite);
        this.behavior = behavior;
        this.shooter = shooter;
        this.projectileSpeed = projectileSpeed;
    }

    public void update() {
        behavior.execute(this, projectileSpeed);
    }

    public GameObject getShooter() {
        return shooter;
    }
}
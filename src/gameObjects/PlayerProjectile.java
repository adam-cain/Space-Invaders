package gameObjects;

import util.Image;
import util.ProjectileDirection;

public class PlayerProjectile extends Projectile {
    
    public PlayerProjectile(int xPosition, int yPosition, int projectileSpeed, GameObject shooter) {
        super(xPosition, yPosition, projectileSpeed, ProjectileDirection.UP, shooter);
        // You can set a different sprite for player projectiles if needed
        setSprite(new Image("src/assets/player_missile.png", 10, 5));
    }

    // You can override or add more methods specific to player projectiles if needed
}

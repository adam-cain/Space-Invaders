package gameObjects;

import util.Image;

public class Bunker extends GameObject {
    private static Image sprite = new Image("src/assets/Bunker.png", 40, 40);

    private int health = 100;

    public Bunker(int x, int y, Image sprite) {
        super(x, y, sprite);
    }
}

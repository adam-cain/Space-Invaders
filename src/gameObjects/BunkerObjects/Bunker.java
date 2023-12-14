package gameObjects.BunkerObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gameObjects.GameObject;
import gameObjects.Projectile;
import gameObjects.BunkerObjects.BunkerShapes.BunkerShape;
import interfaces.Collidable;
import util.Image;

public class Bunker {
    private List<BunkerCube> cubes;

    public Bunker(int x, int y, BunkerShape shape) {
        cubes = new ArrayList<>();
        createBunkerCubes(x, y, shape);
    }

    private void createBunkerCubes(int x, int y, BunkerShape shape) {
        int[][] shapeMatrix = shape.getShapeMatrix();
        int cubeSize = 10; // Assuming cube size to be 10
        for (int i = 0; i < shape.getShapeWidth(); i++) {
            for (int j = 0; j < shape.getShapeHeight(); j++) { // Assuming height is different from width
                if (shapeMatrix[i][j] == 1) {
                    BunkerCube cube = new BunkerCube(x + i * cubeSize, y + j * cubeSize);
                    cubes.add(cube);
                }
            }
        }
    }

    public boolean checkCollisions(Projectile projectile) {
        Iterator<BunkerCube> iterator = cubes.iterator();
        while (iterator.hasNext()) {
            BunkerCube bunkerCube = iterator.next();
            if (bunkerCube.collides(projectile)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void draw() {
        for (BunkerCube bunkerCube : cubes) {
            bunkerCube.draw();
        }
    }

    class BunkerCube extends GameObject implements Collidable {
        public BunkerCube(int x, int y) {
            super(x, y, new Image("src/assets/bunkerCube.png", 10, 10));
        }

        @Override
        public void handleCollision() {
            // Collision handling logic
        }
    }
}

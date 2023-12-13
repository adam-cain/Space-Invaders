package gameObjects.BunkerObjects;

import java.util.ArrayList;
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
        // Create individual bunker cubes and add them to the list
        int[][] shapeMatrix = shape.getShapeMatrix();
        for (int i = 0; i < shape.getShapeWidth(); i++) {
            for (int j = 0; j < shape.getShapeWidth(); j++) {
                if (shapeMatrix[i][j] == 1) {
                    BunkerCube cube = new BunkerCube(x + i + 10, y + j + 10);
                    cubes.add(cube);
                }
            }
        }
    }

    public void checkCollisions(Projectile projectile){
        for (BunkerCube bunkerCube : cubes) {
            if (bunkerCube.collides(projectile)) {
                cubes.remove(bunkerCube);
            }
        }
    }

    public void draw(){
        for (BunkerCube bunkerCube : cubes) {
            bunkerCube.draw();
        }
    }

    class BunkerCube extends GameObject implements Collidable{
        public BunkerCube(int x, int y) {
            super(x, y, new Image("src/assets/bunkerCube.png", 10, 10));
        }

        @Override
        public void handleCollision() {
            // Handled by superclass
        }
    }
}

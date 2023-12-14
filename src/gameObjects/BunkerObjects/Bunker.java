package gameObjects.BunkerObjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import gameObjects.GameObject;
import gameObjects.Projectile;
import gameObjects.BunkerObjects.BunkerShapes.BunkerShape;
import interfaces.Collidable;
import util.Image;

/**
 * Represents a bunker in the game, constructed from multiple BunkerCube objects.
 * The shape and size of the bunker are defined by BunkerShape.
 */
public class Bunker {
    private List<BunkerCube> cubes;

    /**
     * Constructor for Bunker.
     * Initializes the bunker with a specific position and shape.
     *
     * @param x the x-coordinate of the bunker's starting position.
     * @param y the y-coordinate of the bunker's starting position.
     * @param shape the shape of the bunker, defined by a BunkerShape object.
     */
    public Bunker(int x, int y, BunkerShape shape) {
        cubes = new ArrayList<>();
        createBunkerCubes(x, y, shape);
    }

    /**
     * Creates individual BunkerCube objects to form the shape of the bunker.
     *
     * @param x the starting x-coordinate for the bunker.
     * @param y the starting y-coordinate for the bunker.
     * @param shape the shape of the bunker as defined by a BunkerShape object.
     */
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

    /**
     * Checks for collisions between a projectile and any of the BunkerCubes.
     * Removes any BunkerCube that collides with a projectile.
     *
     * @param projectile the projectile to check collisions against.
     * @return true if a collision occurs, false otherwise.
     */
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

    /**
     * Draws the bunker by rendering each of its BunkerCubes.
     */
    public void draw() {
        for (BunkerCube bunkerCube : cubes) {
            bunkerCube.draw();
        }
    }

    /**
     * Inner class representing an individual cube of a bunker.
     * Each cube is a GameObject and implements Collidable for collision handling.
     */
    class BunkerCube extends GameObject implements Collidable {
        /**
         * Constructor for BunkerCube.
         * Initializes a bunker cube with a specific position.
         *
         * @param x the x-coordinate of the bunker cube.
         * @param y the y-coordinate of the bunker cube.
         */
        public BunkerCube(int x, int y) {
            super(x, y, new Image("src/assets/bunkerCube.png", 10, 10));
        }

        /**
         * Handles the collision logic for a BunkerCube.
         */
        @Override
        public void handleCollision() {
            // Collision handling logic
        }
    }
}

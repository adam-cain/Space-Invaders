package gameObjects.BunkerObjects.BunkerShapes;

/**
 * Represents a cube-shaped bunker in the game.
 * This class extends BunkerShape and defines a cube-like shape for a bunker using a 2D array of integers.
 */
public class CubeShape extends BunkerShape {
    
    /**
     * Constructor for CubeShape.
     * Initializes the shape of the bunker to a cube form.
     * The shape is defined as a 2D array of integers, where each cell contains 1, representing a solid part of the bunker.
     */
    public CubeShape() {
        super(new int[][] {
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}
        });
    }
}

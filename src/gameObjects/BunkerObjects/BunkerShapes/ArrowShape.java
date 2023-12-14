package gameObjects.BunkerObjects.BunkerShapes;

/**
 * Represents a bunker shape in the form of an arrow.
 * This class extends BunkerShape and defines a specific shape for a bunker in a 2D grid.
 */
public class ArrowShape extends BunkerShape {
    
    /**
     * Constructor for ArrowShape.
     * Initializes the shape of the bunker to represent an arrow.
     * The shape is defined as a 2D array of integers, where 1 represents a part of the bunker and 0 represents an empty space.
     */
    public ArrowShape() {
        super(new int[][] {
            {0, 0, 1, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1}
        });
    }
}

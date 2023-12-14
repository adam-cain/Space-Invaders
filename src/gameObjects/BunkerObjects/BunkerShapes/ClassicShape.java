package gameObjects.BunkerObjects.BunkerShapes;

/**
 * Represents a classic bunker shape in the game.
 * This class extends BunkerShape and defines a specific shape for a bunker using a 2D array of integers.
 */
public class ClassicShape extends BunkerShape {
    
    /**
     * Constructor for ClassicShape.
     * Initializes the shape of the bunker to a classic design.
     * The shape is defined as a 2D array of integers, where 1 represents a part of the bunker and 0 represents an empty space.
     */
    public ClassicShape() {
        super(new int[][] {
            {0, 1, 1, 1, 0},
            {0, 1, 1, 1, 0},
            {1, 1, 1, 1, 1},
            {1, 1, 0, 1, 1},
            {1, 1, 0, 1, 1}
        });
    }
}

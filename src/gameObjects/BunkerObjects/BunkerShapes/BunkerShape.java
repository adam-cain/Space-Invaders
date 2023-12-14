package gameObjects.BunkerObjects.BunkerShapes;

/**
 * Abstract class representing the shape of a bunker.
 * This class provides the basic structure and functionality for different bunker shapes.
 */
public abstract class BunkerShape {
    private int[][] shapeMatrix;

    /**
     * Constructor for BunkerShape.
     * Initializes the shape of the bunker based on a provided matrix.
     *
     * @param matrix The 2D array representing the bunker shape.
     * @throws IllegalArgumentException if the provided matrix rows and columns are not uniform in size.
     */
    public BunkerShape(int[][] matrix) {
        if (!isMatrixUniform(matrix)) {
            throw new IllegalArgumentException("Matrix rows and columns must be of uniform size.");
        }
        this.shapeMatrix = matrix;
    }

    /**
     * Retrieves the shape matrix of the bunker.
     *
     * @return A 2D array representing the shape of the bunker.
     */
    public int[][] getShapeMatrix() {
        return shapeMatrix;
    }

    /**
     * Gets the width of the bunker shape.
     *
     * @return The number of columns in the shape matrix.
     */
    public int getShapeWidth() {
        return shapeMatrix.length;
    }

    /**
     * Gets the height of the bunker shape.
     *
     * @return The number of rows in the shape matrix.
     */
    public int getShapeHeight() {
        return shapeMatrix[0].length;
    }

    /**
     * Checks if a given matrix has uniform row lengths.
     *
     * @param matrix The matrix to check.
     * @return true if all rows in the matrix have the same length, false otherwise.
     */
    private boolean isMatrixUniform(int[][] matrix) {
        if (matrix.length == 0) return true;

        int firstRowLength = matrix[0].length;
        for (int[] row : matrix) {
            if (row.length != firstRowLength) {
                return false;
            }
        }
        return true;
    }
}

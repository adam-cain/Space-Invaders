package interfaces;
public interface Collidable extends Positionable {
    default boolean collides(Collidable other) {
        // Check if the right edge of 'this' is left of the left edge of 'other'
        if (getX() + getWidth() <= other.getX()) {
            return false;
        }
    
        // Check if the left edge of 'this' is right of the right edge of 'other'
        if (getX() >= other.getX() + other.getWidth()) {
            return false;
        }
    
        // Check if the bottom edge of 'this' is above the top edge of 'other'
        if (getY() + getHeight() <= other.getY()) {
            return false;
        }
    
        // Check if the top edge of 'this' is below the bottom edge of 'other'
        if (getY() >= other.getY() + other.getHeight()) {
            return false;
        }
    
        // If none of the above, the objects intersect
        return true;
    }
}

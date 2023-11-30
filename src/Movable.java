public interface Movable {
    int getX();
    int getY();
    void setX(int x);
    void setY(int y);

    default void move(int deltaX, int deltaY){
        setX(getX() + deltaX);
        setY(getY() + deltaY);
    }
}

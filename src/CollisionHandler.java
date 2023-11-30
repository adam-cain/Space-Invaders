public class CollisionHandler {

    private static CollisionHandler instance;

    public static CollisionHandler getInstance() {
        if (instance == null) {
            instance = new CollisionHandler();
        }
        return instance;
    }
}

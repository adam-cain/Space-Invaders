import java.util.ArrayList;
import java.util.List;

public class GameController {
    private static GameController instance;
    private Player player;
    private AlienSwarm alienSwarm;
    private List<Projectile> projectiles;
    private Scoreboard scoreboard;
    private boolean isGameOver;
    private int currentLevel;
    private UFO ufo; // Assuming there's a UFO class.

    private CollisionHandler collisionHandler;

    private GameController() {
        this.player = new Player();
        this.currentLevel = 1;
        this.alienSwarm = new AlienSwarm(currentLevel);
        this.projectiles = new ArrayList<>();
        this.scoreboard = new Scoreboard();
        this.collisionHandler = CollisionHandler.getInstance();
        this.isGameOver = false;
        // Initialize shields, etc.
    }

    // Public static method to get the instance
    public static GameController getInstance() {
        if (instance == null) {
            instance = new GameController();
        }
        return instance;
    }


    public void startGame() {
        // Initialize or reset game components
        player.reset();
        alienSwarm.reset();
        projectiles.clear();
        scoreboard.reset();
        isGameOver = false;
        currentLevel = 1;
        
        // Start the main game loop
        mainGameLoop();
    }

    private void mainGameLoop() {
        while (!isGameOver) {
            // Game loop operations
            updateGameObjects();
            checkCollisions();
            handlePlayerInput(); // This would be linked to actual player input in the game framework
            renderDisplay();
            checkEndOfLevel();
            checkGameOver();
            // Add a sleep or delay based on your game framework to control the loop timing
        }
        endGame();
    }

    private void updateGameObjects() {
        // Update the player, aliens, and projectiles
        player.update();
        alienSwarm.update();
        projectiles.forEach(Projectile::update);
        // Remove projectiles that are out of bounds
        projectiles.removeIf(Projectile::isOutOfBounds);
    }

    private void checkCollisions() {
        // Handle collisions
        CollisionDetector.detectAndHandleCollisions(player, alienSwarm, shields, projectiles, scoreboard);
    }

    private void handlePlayerInput() {
        // This method should be connected to actual input handling in your game framework
        // For example: if the left arrow key is pressed, then player.moveLeft();
    }

    private void renderDisplay() {
        // This method should be tied to the actual rendering code in your game framework
        // Update the display with the current state of all game objects
    }

    private void checkEndOfLevel() {
        if (alienSwarm.allAliensDefeated()) {
            currentLevel++;
            startNextLevel();
        }
    }

    private void checkGameOver() {
        if (player.getLives() <= 0 || alienSwarm.hasReachedBase()) {
            isGameOver = true;
        }
    }

    private void startNextLevel() {
        // Prepare the game for the next level
        alienSwarm.reset();
        shields.forEach(Shield::repair);
        // More level initialization as needed
    }

    private void endGame() {
        // Display game over message and handle any cleanup
    }
}

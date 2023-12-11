package core;

import java.util.ArrayList;
import java.util.List;

import factory.GameObjectFactory;
import gameObjects.Player;
import gameObjects.AlienObjects.Alien;
import gameObjects.AlienObjects.UFO;
import gameObjects.BunkerObjects.Bunker;
import gameObjects.ProjectileObjects.Projectile;
import handler.CollisionHandler;
import handler.SoundManager;
import handler.InputHandlers.InputHandler;
import ui.Scoreboard;
import ui.ViewController;


public class Game {
    private static Game instance;

    //Game objects
    private Player player;
    private AlienSwarm alienSwarm;
    private List<Projectile> projectiles;
    private List<Bunker> bunkers;
    private UFO ufo;

    //Game states
    private boolean isGameOver;
    private int currentLevel;
    private int score;
    private int lives;

    //UI
    private ViewController viewController;
    private Scoreboard scoreboard;

    private CollisionHandler collisionHandler;

    private Game() {
        this.player = GameObjectFactory.createPlayer();
        this.alienSwarm = new AlienSwarm(currentLevel);
        this.projectiles = new ArrayList<>();
        this.scoreboard = new Scoreboard();
        this.currentLevel = 1;
        this.score = 0;
        this.lives = 3;
        this.isGameOver = false;
    }

    // Public static method to get the instance
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    public void startGame() {
        // Initialize or reset game components
        player.reset();
        alienSwarm = new AlienSwarm(currentLevel);
        projectiles.clear();
        isGameOver = false;
        currentLevel = 1;

        // Start the main game loop
        mainGameLoop();
    }

    private void mainGameLoop() {
        while (!isGameOver) {
            // Game loop operations
            //Update Objects
            updateGameObjects();
            checkCollisions();
            handlePlayerInput(); // This would be linked to actual player input in the game framework
            renderDisplay();
            checkEndOfLevel();
            checkGameOver();
            // Add a sleep or delay based on your game framework to control the loop timing
            //Clear Display
            viewController.clearDisplay();

            //Draw
            scoreboard.updateScoreboard(score, lives);

        }
        endGame();
    }

    private void renderDisplay() {
        // This method should be tied to the actual rendering code in your game
        // framework
        // Update the display with the current state of all game objects
    }

    private void checkEndOfLevel() {
        if (alienSwarm.allAliensDefeated()) {
            currentLevel++;
            startNextLevel();
        }
    }

    private void checkGameOver() {
        if (!player.isAlive() || alienSwarm.swarmReachedBottom()) {
            isGameOver = true;
        }
    }

    private void startNextLevel() {
        // Prepare the game for the next level
        alienSwarm = new AlienSwarm(currentLevel);
        //reset bunkers
        // More level initialization as needed
    }

    private void endGame() {
        // Display game over message and handle any cleanup
    }

    private void updateGameObjects() {
        // Update the player, aliens, and projectiles

        for (Projectile projectile : projectiles) {
            projectile.update();
        }
        alienSwarm.moveSwarm(); // Assuming there's an updateAliens() method in the AlienSwarm class
        projectiles.removeIf(projectile -> projectile.isOutOfBounds());
    }

    private void checkCollisions() {
        // Handle collisions
        //CollisionDetector.detectAndHandleCollisions(player, alienSwarm, projectiles, bunkers);
    }

    private void handlePlayerInput() {
        // This method should be connected to actual input handling in your game
        // framework
        // For example: if the left arrow key is pressed, then player.moveLeft();
    }
}
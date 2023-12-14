package core;

import java.util.ArrayList;
import java.util.List;

import factory.GameObjectFactory;
import gameObjects.Player;
import gameObjects.Projectile;
import gameObjects.AlienObjects.Alien;
import gameObjects.AlienObjects.UFO;
import gameObjects.BunkerObjects.Bunker;
import gameObjects.BunkerObjects.BunkerShapes.ClassicShape;
import handler.CollisionHandlers.*;
import handler.InputHandlers.*;
import handler.SoundHandler.Sound;
import handler.SoundHandler.SoundManager;
import interfaces.Collidable;
import ui.ScoreboardScene;
import ui.ViewController;

/**
 * The Game class is the central class of the game, responsible for managing the game loop,
 * game objects, state, and interactions between components.
 */
public class Game {
    private static Game instance;

    // Game objects
    private Player player;
    private AlienSwarm alienSwarm;
    private List<Projectile> projectiles;
    private List<Bunker> bunkers;
    private UFO ufo;

    // Game states
    private boolean isGameOver;
    private int currentLevel;
    private int score;
    private int lives;

    // UI
    private ViewController viewController;
    private ScoreboardScene scoreboard;

    // Handlers
    private CollisionHandler collisionHandler;
    private InputHandler inputHandler;

    private Game() {
        initializeHandlers();
    }

    /**
     * The getInstance() function returns the instance of the Game class, creating
     * it if it doesn't already exist.
     * 
     * @return The method is returning an instance of the Game class.
     */
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    /**
     * The function initializes collision handlers and input handlers, setting up a chain of
     * responsibility pattern for handling collisions and input events.
     */
    private void initializeHandlers() {
        // Initialize collision handlers
        AlienCollisionHandler alienCollisionHandler = new AlienCollisionHandler(this);
        BunkerCollisionHandler bunkerCollisionHandler = new BunkerCollisionHandler(this);
        PlayerCollisionHandler playerCollisionHandler = new PlayerCollisionHandler(this);

        collisionHandler = alienCollisionHandler;
        alienCollisionHandler.setNext(bunkerCollisionHandler);
        bunkerCollisionHandler.setNext(playerCollisionHandler);

        // Initialize input handlers
        ShootHandler shootHandler = new ShootHandler(player);
        MoveLeftHandler moveLeftHandler = new MoveLeftHandler(player);
        MoveRightHandler moveRightHandler = new MoveRightHandler(player);

        inputHandler = shootHandler;
        shootHandler.setNext(moveLeftHandler);
        moveLeftHandler.setNext(moveRightHandler);
    }

    /**
     * The addProjectile function adds a projectile to a list of projectiles.
     * 
     * @param projectile The "projectile" parameter is an object of the Projectile class.
     */
    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
    }

    /**
     * The removeProjectile function removes a given projectile from a list of
     * projectiles.
     * 
     * @param projectile The "projectile" parameter is an object of the Projectile class that you want
     * to remove from the "projectiles" collection.
     */
    public void removeProjectile(Projectile projectile) {
        projectiles.remove(projectile);
    }

    /**
     * The addPoints function adds a given score to the current score.
     * 
     * @param score The score parameter is an integer value representing the number
     *              of points to be
     *              added to the current score.
     */
    public void addPoints(int score) {
        this.score += score;
    }

    /**
     * The function removes one life from a player.
     */
    public void removeLife() {
        lives--;
    }

    /**
     * The startGame function initializes game components, sets game variables,
     * loads the scoreboard scene, starts the next level.
     * 
     * @return The method is returning an integer value, which is the score.
     */
    public int startGame() {
        initializeGameComponents();
        setGameVariables();
        viewController.loadScene(scoreboard);
        startNextLevel();
        SoundManager.playSound(Sound.EXPLOSION);
        return score;
    }

    /**
     * The function initializes the game components, including the player, scoreboard, projectiles, and
     * bunkers, and resets the player's position.
     */
    private void initializeGameComponents() {
        this.player = GameObjectFactory.createPlayer();
        this.scoreboard = new ScoreboardScene();
        this.projectiles = new ArrayList<>();
        this.bunkers = new ArrayList<>();
        player.resetPosition();
    }

    /**
     * The function sets the initial values for game variables such as currentLevel, score, lives, and
     * isGameOver.
     */
    private void setGameVariables() {
        this.currentLevel = 1;
        this.score = 0;
        this.lives = 3;
        this.isGameOver = false;
    }

    /**
     * The function starts the next level of the game and continues the main game loop if the game is
     * not over.
     */
    public void startNextLevel() {
        this.currentLevel++;
        setupLevel();
        if (!isGameOver) {
            mainGameLoop();
        }
    }

    /**
     * The function "setupLevel" initializes the game level by creating a new alien swarm, setting up
     * bunkers, clearing projectiles, and resetting the player's position.
     */
    private void setupLevel() {
        alienSwarm = new AlienSwarm(currentLevel);
        setupBunkers();
        projectiles.clear();
        player.resetPosition();
    }

/**
 * The function "setupBunkers" clears the "bunkers" list and adds three new bunkers to it with specific
 * positions and shapes.
 */
    private void setupBunkers() {
        bunkers.clear();
        bunkers.add(GameObjectFactory.createBunker(100, 500, new ClassicShape()));
        bunkers.add(GameObjectFactory.createBunker(300, 500, new ClassicShape()));
        bunkers.add(GameObjectFactory.createBunker(500, 500, new ClassicShape()));
    }

    /**
     * The mainGameLoop function runs a continuous loop that handles player input, updates game
     * objects, draws game objects, checks for collisions, updates the scoreboard, and checks for the
     * end of the level until the game is over.
     */
    private void mainGameLoop() {
        while (!isGameOver) {
            // Game loop operations
            handlePlayerInput();
            updateGameObjects();
            drawGameObjects();
            checkCollisions();
            viewController.clear();
            scoreboard.updateScoreboard(score, lives);
            checkEndOfLevel();
            if (!player.isAlive() || alienSwarm.swarmReachedBottom()) {
                isGameOver = true;
            }
        }
    }

    /**
     * The function checks if all aliens have been defeated and if so, it increments the current level
     * and starts the next level.
     */
    private void checkEndOfLevel() {
        if (alienSwarm.allAliensDefeated()) {
            currentLevel++;
            startNextLevel();
        }
    }

    /**
     * The function updates the game objects, including projectiles, UFOs, and aliens, by calling their
     * respective update methods and removing any objects that are out of bounds.
     */
    private void updateGameObjects() {
        // Update Projectiles
        for (Projectile projectile : projectiles) {
            projectile.update();
            if (projectile.isOutOfBounds()) {
                projectiles.remove(projectile);
            }
        }
        // Update UFO
        if (ufo != null) {
            ufo.update();
            if (ufo.isOutOfBounds()) {
                ufo = null;
            }
        } else {
            if (Math.random() < 0.05) {
                ufo = (UFO) GameObjectFactory.createUFO(currentLevel);
            }
        }
        // Update Aliens
        alienSwarm.update();
    }

    /**
     * The function draws various game objects such as projectiles, UFO, aliens, bunkers, and the
     * player.
     */
    private void drawGameObjects() {
        // Draw Projectiles
        for (Projectile projectile : projectiles) {
            projectile.draw();
        }
        // Draw UFO
        if (ufo != null) {
            ufo.draw();
        }
        // Draw Aliens
        for (Alien alien : alienSwarm.getAliens()) {
            alien.draw();
        }
        // Draw Bunkers
        for (Bunker bunker : bunkers) {
            bunker.draw();
        }
        // Draw Player
        player.draw();
    }

    /**
     * Handles collisions between game objects.
     */
    private void checkCollisions() {
        nestedLoop: for (Projectile projectile : projectiles) {
            for (Bunker bunker : bunkers) {
                CollisionPair input = new CollisionPair(projectile, (Collidable) bunker);
                if (collisionHandler.handleRequest(input)) {
                    break nestedLoop;
                }
            }
            for (Alien alien : alienSwarm.getAliens()) {
                CollisionPair input = new CollisionPair(projectile, (Collidable) alien);
                if (collisionHandler.handleRequest(input)) {
                    break nestedLoop;
                }
            }
            if (collisionHandler.handleRequest(new CollisionPair(projectile, (Collidable) player))) {
                break nestedLoop;
            }
        }
    }

    /**
     * Handles player input for game control.
     */
    private void handlePlayerInput() {
        KeyCode keyPressed = viewController.getKeyPressed();
        if (keyPressed != null) {
            inputHandler.handleRequest(keyPressed);
        }
        viewController.handleMouseClick();
    }

    /**
     * Adds a specified number of points to the current score.
     *
     * @param points the number of points to add.
     */
    public void addScore(int points) {
        score += points;
    }
}
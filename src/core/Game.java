package core;

import java.util.ArrayList;
import java.util.List;

import factory.GameObjectFactory;
import gameObjects.Player;
import gameObjects.Projectile;
import gameObjects.AlienObjects.Alien;
import gameObjects.AlienObjects.UFO;
import gameObjects.BunkerObjects.Bunker;
import handler.CollisionHandler;
import handler.InputHandlers.*;
import ui.ScoreboardScene;
import ui.ViewController;
import ui.GameOverScene;


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
    private ScoreboardScene scoreboard;

    //Handlers
    private CollisionHandler collisionHandler;
    private InputHandler inputHandler;

    private Game() {
        //Initialize game objects
        this.player = GameObjectFactory.createPlayer();
        this.alienSwarm = new AlienSwarm(currentLevel);
        this.projectiles = new ArrayList<>();
        this.scoreboard = new ScoreboardScene();
        //Set Game variables
        this.currentLevel = 1;
        this.score = 0;
        this.lives = 3;
        this.isGameOver = false;
        //Load game UI
        viewController.loadScene(scoreboard);

        //Initialize input handlers 
        ShootHandler shootHandler= new ShootHandler(player);
        MoveLeftHandler moveLeftHandler = new MoveLeftHandler(player);
        MoveRightHandler moveRightHandler = new MoveRightHandler(player);

        inputHandler = shootHandler;
        shootHandler.setNext(moveLeftHandler);
        moveLeftHandler.setNext(moveRightHandler);
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
        player.resetPosition();
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
            //Get player input
            // get input from the game framework
            KeyCode keyPressed = viewController.getKeyPressed();
            if(keyPressed != null){
                inputHandler.handleRequest(keyPressed);
            }
            //Update Objects
            handlePlayerInput(); // This would be linked to actual player input in the game framework
            updateGameObjects();
            drawGameObjects();

            
            checkCollisions();

            //Clear Display
            viewController.clear();

            //Draw
            scoreboard.updateScoreboard(score, lives);

            //Check game logic for 
            checkEndOfLevel();
            checkGameOver();
            // Add a sleep or delay based on your game framework to control the loop timing

        }
        endGame();
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
        viewController.loadScene(new GameOverScene(score));
    }

    private void updateGameObjects() {
        // Update Projectiles
        for (Projectile projectile : projectiles) {
            projectile.update();
            if(projectile.isOutOfBounds()){
                projectiles.remove(projectile);
            }
        }
        // Update UFO
        if (ufo != null) {
            ufo.update();
            if(ufo.isOutOfBounds()){
                ufo = null;
            }
        }else{
            if (Math.random() < 0.05) {
                ufo = (UFO) GameObjectFactory.createUFO(currentLevel);
            }
        }
        // Update Aliens
        alienSwarm.update();
    }

    private void drawGameObjects(){
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
package core;

import java.awt.Dimension;
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
import interfaces.Collidable;
import ui.ScoreboardScene;
import ui.ViewController;
import ui.interfaces.ClickListener;
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
        //Initialize collision handlers
        AlienCollisionHandler alienCollisionHandler = new AlienCollisionHandler(this);
        BunkerCollisionHandler bunkerCollisionHandler = new BunkerCollisionHandler(this);
        PlayerCollisionHandler playerCollisionHandler = new PlayerCollisionHandler(this);

        collisionHandler = alienCollisionHandler;
        alienCollisionHandler.setNext(bunkerCollisionHandler);
        bunkerCollisionHandler.setNext(playerCollisionHandler);

        //Initialize input handlers 
        ShootHandler shootHandler= new ShootHandler(player);
        MoveLeftHandler moveLeftHandler = new MoveLeftHandler(player);
        MoveRightHandler moveRightHandler = new MoveRightHandler(player);

        inputHandler = shootHandler;
        shootHandler.setNext(moveLeftHandler);
        moveLeftHandler.setNext(moveRightHandler);

        //UI object handler
        //TODO: Add UI object handler
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

    public void removeProjectile(Projectile projectile) {
        projectiles.remove(projectile);
    }

    public void addPoints(int score){
        this.score += score;
    }

    public void removeLife(){
        lives--;
    }

    public int startGame() {
        // Initialize or reset game components
        this.player = GameObjectFactory.createPlayer();
        this.scoreboard = new ScoreboardScene();
        this.projectiles = new ArrayList<>();
        this.bunkers = new ArrayList<>();
        
        // Set Game variables
        this.currentLevel = 1;
        this.score = 0;
        this.lives = 3;
        this.isGameOver = false;
    
        viewController.loadScene(scoreboard);
        player.resetPosition();
    
        // Start the first level
        startNextLevel();
        return score;
    }

    public void startNextLevel() {
        // Prepare the game for the next level
        alienSwarm = new AlienSwarm(currentLevel);
        bunkers.clear();
        bunkers.add(GameObjectFactory.createBunker(100, 500, new ClassicShape()));
        bunkers.add(GameObjectFactory.createBunker(300, 500, new ClassicShape()));
        bunkers.add(GameObjectFactory.createBunker(500, 500, new ClassicShape()));
        projectiles.clear();
    
        // Start or resume the main game loop
        if (!isGameOver) {
            mainGameLoop();
        }
    }
    

    private void mainGameLoop() {
        while (!isGameOver) {
            // Game loop operations
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
            if (!player.isAlive() || alienSwarm.swarmReachedBottom()) {
                break;
            }
        }
        isGameOver = false;
        return;
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
        nestedLoop:
        for (Projectile projectile : projectiles) {
            for (Bunker bunker : bunkers) {
                CollisionPair input = new CollisionPair         (projectile, (Collidable) bunker);
                if(collisionHandler.handleRequest(input)){
                    break nestedLoop;
                }
            }
            for (Alien alien : alienSwarm.getAliens()) {
                CollisionPair input = new CollisionPair(projectile, (Collidable) alien);
                if(collisionHandler.handleRequest(input)){
                    break nestedLoop;
                }
            }
            if(collisionHandler.handleRequest(new CollisionPair(projectile, (Collidable) player))){
                break nestedLoop;
            }
        }
    }

    private void handlePlayerInput() {
        KeyCode keyPressed = viewController.getKeyPressed();
        if(keyPressed != null){
            inputHandler.handleRequest(keyPressed);
        }
        viewController.handleMouseClick();
    }

    public void addScore(int points) {
        score += points;
    }
}
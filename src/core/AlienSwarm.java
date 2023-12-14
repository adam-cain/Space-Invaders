package core;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import factory.AlienSwarmFactory;
import factory.types.AlienType;
import gameObjects.AlienObjects.ShootingAlien;
import ui.ViewController;

/**
 * Represents a swarm of alien objects in the game.
 * Responsible for managing the positions, movements, and actions of the aliens.
 */
public class AlienSwarm {
    private static final int HORIZONTAL_SPACING = 20;
    private static final int VERTICAL_SPACING = 40;
    private static final int COLUMNS = 11;
    private static final int ROWS = 5;
    private static final int RIGHT_EDGE_MARGIN = 40;
    private static final int LEFT_EDGE_MARGIN = 40;
    private static final int BOTTOM_EDGE_MARGIN = 40;

    private List<ShootingAlien> aliens;
    private int currentLevel;

    // Swarm Edges
    private int leftEdgePos;
    private int rightEdgePos;
    private int bottomEdgePos;

    private int xDirection = 1;

    /**
     * Constructs an AlienSwarm for a specified level.
     *
     * @param currentLevel The level of the game for which the swarm is created.
     */
    public AlienSwarm(int currentLevel) {
        this.currentLevel = currentLevel;
        this.aliens = new ArrayList<>();
        buildSwarm();
    }

    /**
     * Retrieves the list of alien objects in the swarm.
     *
     * @return A list of ShootingAlien objects.
     */
    public List<ShootingAlien> getAliens() {
        return aliens;
    }

    private void buildSwarm() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                ShootingAlien alien = createAlienForRow(row, col * HORIZONTAL_SPACING, row * VERTICAL_SPACING);
                aliens.add(alien);
            }
        }
    }

    private ShootingAlien createAlienForRow(int row, int xPosition, int yPosition) {
        AlienType type = (row == 0) ? AlienType.SQUID : (row <= 2) ? AlienType.CRAB : AlienType.OCTOPUS;
        return (ShootingAlien) AlienSwarmFactory.createAlien(type, xPosition, yPosition);
    }

    /**
     * Updates the state of the alien swarm, including movement, edge updates, and random shooting actions.
     */
    public void update() {
        moveSwarm();
        updateSwarmEdges();
        randomShoot();
    }

    private void moveSwarm() {
        Dimension windowSize = ViewController.getWindowSize();
        int yDirection = 0;

        if (rightEdgePos >= windowSize.getWidth() - RIGHT_EDGE_MARGIN) {
            xDirection = -1;
            yDirection = VERTICAL_SPACING;
        } else if (leftEdgePos <= LEFT_EDGE_MARGIN) {
            xDirection = 1;
            yDirection = VERTICAL_SPACING;
        }

        for (ShootingAlien alien : aliens) {
            alien.translate(xDirection * currentLevel, yDirection);
        }
    }

    private void updateSwarmEdges() {
        leftEdgePos = aliens.stream().mapToInt(ShootingAlien::getX).min().orElse(Integer.MAX_VALUE);
        rightEdgePos = aliens.stream().mapToInt(ShootingAlien::getX).max().orElse(Integer.MIN_VALUE);
        bottomEdgePos = aliens.stream().mapToInt(ShootingAlien::getY).max().orElse(Integer.MIN_VALUE);
    }

    /**
     * Checks if all aliens in the swarm have been defeated.
     *
     * @return True if all aliens are defeated, false otherwise.
     */
    public boolean allAliensDefeated() {
        return aliens.isEmpty();
    }

    /**
     * Checks if the alien swarm has reached the bottom of the screen.
     *
     * @return True if the swarm has reached the bottom, false otherwise.
     */
    public boolean swarmReachedBottom() {
        int bottomEdge = (int) ViewController.getWindowSize().getHeight() - BOTTOM_EDGE_MARGIN;
        return bottomEdgePos >= bottomEdge;
    }

    /**
     * Makes the aliens in the swarm shoot randomly.
     */
    public void randomShoot() {
        Random random = new Random();
        int shootCount = random.nextInt(1 + currentLevel);
        for (int i = 0; i < shootCount; i++) {
            if (!aliens.isEmpty()) {
                shootAlien(random);
            }
        }
    }

    private void shootAlien(Random random) {
        int shooterIndex = random.nextInt(aliens.size());
        ShootingAlien alien = aliens.get(shooterIndex);
        alien.shoot();
    }
}

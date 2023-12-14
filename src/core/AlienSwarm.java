package core;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import factory.AlienSwarmFactory;
import factory.types.AlienType;
import gameObjects.AlienObjects.ShootingAlien;
import ui.ViewController;

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

    public AlienSwarm(int currentLevel) {
        this.currentLevel = currentLevel;
        this.aliens = new ArrayList<>();
        buildSwarm();
    }

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

    public boolean allAliensDefeated() {
        return aliens.isEmpty();
    }

    public boolean swarmReachedBottom() {
        int bottomEdge = (int) ViewController.getWindowSize().getHeight() - BOTTOM_EDGE_MARGIN;
        return bottomEdgePos >= bottomEdge;
    }

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

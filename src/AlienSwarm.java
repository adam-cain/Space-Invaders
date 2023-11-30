import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlienSwarm {
    private List<Alien> aliens;
    private int currentLevel;

    //Swarm Edges
    private int leftEdgeXPosition = Integer.MAX_VALUE;
    private int rightEdgeXPosition = Integer.MIN_VALUE;
    private int bottomEdgeYPosition = Integer.MIN_VALUE;

    public AlienSwarm(int currentLevel) {
        this.currentLevel = currentLevel;
        this.aliens = new ArrayList<>();
        buildSwarm();
    }

    private void buildSwarm() {
        int horizontalSpacing = 20;
        int verticalSpacing = 40;
        int columns = 11;
        int rows = 5;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                Alien alien;
                int xPosition = col * horizontalSpacing;
                int yPosition = row * verticalSpacing;

                if (row == 0) {
                    alien = new Squid(xPosition, yPosition);
                } else if (row == 1 || row == 2) {
                    alien = new Crab(xPosition, yPosition);
                } else {
                    alien = new Octopus(xPosition, yPosition);
                }

                aliens.add(alien);
            }
        }
    }



    public void moveSwarm() {
        int xDirection = 1;
        int yDirection = 0;

        if (rightXPosition >= 400) {
            xDirection = 0;
            yDirection = 1;
        } else if (leftXPosition <= 0) {
            xDirection = 0;
            yDirection = 1;
        }

        if 

        for (Alien alien : aliens) {
            alien.move(xDirection, yDirection);
        }
    }

    public int[] updateSwarmEdges() {
        for (Alien alien : aliens) {
            if (alien.xPosition < leftXPosition) {
                leftXPosition = alien.xPosition;
            }
            if (alien.xPosition > rightXPosition) {
                rightXPosition = alien.xPosition;
            }
            if (alien.yPosition > bottomYPosition) {
                bottomYPosition = alien.yPosition;
            }
        }

        return new int[] { leftXPosition, rightXPosition, bottomYPosition };
    }
    
    public Projectile randomshoot() {
        Random random = new Random();
        int shooterIndex = random.nextInt(aliens.size());
        Alien alien = aliens.get(shooterIndex);
        return new Projectile(alien.xPosition, alien.yPosition, alien.projectileSpeed); // Replace with actual Projectile creation logic
    }

    public void removeDeadAliens() {
        aliens.removeIf(Alien::isAlive);
        updateSwarmEdges();
    }
}

abstract class Alien {
    protected int xPosition;
    protected int yPosition;
    protected int points;
    protected int projectileSpeed;
    protected boolean isAlive;

    public Alien(int xPosition, int yPosition, int points, int projectileSpeed) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.points = points;
        this.projectileSpeed = projectileSpeed;
        this.isAlive = true;
    }

    public void move(int xDirection, int yDirection){
        this.xPosition += xDirection;
        this.yPosition += yDirection;
    }

    public void hit() {
        this.isAlive = false;
    }

    public int getPoints() {
        return points;
    }

    public boolean isAlive() {
        return isAlive;
    }
}

class Squid extends Alien {
    public Squid(int xPosition, int yPosition) {
        super(xPosition, yPosition, 40, 3);
    }
}

class Crab extends Alien {
    public Crab(int xPosition, int yPosition) {
        super(xPosition, yPosition, 20,2);
    }
}

class Octopus extends Alien {
    public Octopus(int xPosition, int yPosition) {
        super(xPosition, yPosition, 10, 1);
    }
}

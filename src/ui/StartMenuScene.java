package ui;

import java.awt.Dimension;

import ui.interfaces.ClickListener;
import ui.uiObjects.*;
import util.Image;

/**
 * The {@code StartMenuScene} class represents the start menu scene in the Space Invaders game.
 * This scene includes a start button, title image, background image, enemy images, and labels
 * to provide an engaging and informative start menu to the player.
 */
public class StartMenuScene extends Scene {
    private Button startButton;
    private UIImage titleImage;
    private UIImage backgroundImage;
    private UIImage squidImage;
    private UIImage crabImage;
    private UIImage octopusImage;
    private UIImage UFOImage;
    private Label squidLabel;
    private Label crabLabel;
    private Label octopusLabel;
    private Label UFOLabel;

    /**
     * Constructs a new {@code StartMenuScene} with a specified listener for the start button.
     * 
     * @param startButtonListener a {@code ClickListener} for handling the start button's click event
     */
    public StartMenuScene(ClickListener startButtonListener) {
        Dimension windowSize = ViewController.getWindowSize();

        startButton = new StartButton("startButton", 10, 10, 100, 20, "Start", startButtonListener);

        titleImage = new UIImage("titleImage", 10, 10, new Image("src/assests/title.png", 100, 40));
        backgroundImage = new UIImage("backgroundImage", 0, 0, new Image("src/assests/background.png",windowSize.width, windowSize.height));


        squidImage = new UIImage("squidImage", 10, 10, new Image("src/assests/squid.png", 40, 40));
        crabImage = new UIImage("crabImage", 10, 10, new Image("src/assests/crab.png", 40, 40));
        octopusImage = new UIImage("octopusImage", 10, 10, new Image("src/assests/octopus.png", 40, 40));
        UFOImage = new UIImage("UFOImage", 10, 10, new Image("src/assests/UFO.png", 40, 40));

        squidLabel = new Label("squidLabel", 10, 10, 100, 20, "= 10 points");
        crabLabel = new Label("crabLabel", 10, 10, 100, 20, "= 20 points");
        octopusLabel = new Label("octopusLabel", 10, 10, 100, 20, "= 40 points");
        UFOLabel = new Label("???", 10, 10, 100, 20, "UFO");

        addUIObject(startButton);
        addUIObject(titleImage);
        addUIObject(backgroundImage);
        addUIObject(squidImage);
        addUIObject(crabImage);
        addUIObject(octopusImage);
        addUIObject(UFOImage);
        addUIObject(squidLabel);
        addUIObject(crabLabel);
        addUIObject(octopusLabel);
        addUIObject(UFOLabel);
    }


    @Override
    public void update(Object... args) {
        // Update logic for the StartMenuScene can be implemented here if needed
    }
    
}

/**
 * A specialized button for starting the game.
 */
class StartButton extends Button {
    private ClickListener listener;

    /**
     * Constructs a new {@code StartButton} with specified parameters.
     * 
     * @param name     the name of the start button
     * @param x        the x-coordinate of the button's top-left corner
     * @param y        the y-coordinate of the button's top-left corner
     * @param width    the width of the button
     * @param height   the height of the button
     * @param text     the text to be displayed on the button
     * @param listener a {@code ClickListener} for handling click events
     */
    public StartButton(String name, int x, int y, int width, int height, String text, ClickListener listener) {
        super(name, x, y, width, height, text);
        this.listener = listener;
    }

    @Override
    public void onClick() {
        if (listener != null) {
            listener.onClick();
        }
    }
}


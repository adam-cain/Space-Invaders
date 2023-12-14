package handler.SoundHandler;

/**
 * Enum representing different sound effects in the game.
 * Each enum constant is associated with a specific sound file path.
 */
public enum Sound {
    /**
     * Sound effect for explosions.
     */
    EXPLOSION("src/assests/sound/explosion.wav"),

    /**
     * Sound effect for shooting actions.
     */
    SHOOT("src/assests/sound/shoot.wav"),

    /**
     * Sound effect for the game over event.
     */
    GAME_OVER("src/assests/sound/game_over.wav"),

    /**
     * Sound effect for movement actions.
     */
    MOVE("src/assests/sound/move.wav");

    private final String filePath;

    /**
     * Constructs a Sound enum constant with the specified file path.
     *
     * @param filePath The file path to the sound effect.
     */
    Sound(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Gets the file path of the sound effect.
     *
     * @return The file path associated with the sound effect.
     */
    public String getFilePath() {
        return filePath;
    }
}

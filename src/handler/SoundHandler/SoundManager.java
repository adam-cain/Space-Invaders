package handler.SoundHandler;

/**
 * Manages the playing of sound effects in the game.
 * This class provides a static method to play different predefined sounds.
 */
public class SoundManager {

    /**
     * Plays the specified sound effect.
     * This method selects the appropriate sound file based on the given Sound enum and plays it.
     *
     * @param sound The Sound enum constant representing the sound to be played.
     */
    public static void playSound(Sound sound) {
        switch (sound) {
            case EXPLOSION:
                play(sound.getFilePath());
                break;
            case SHOOT:
                play(sound.getFilePath());
                break;
            case GAME_OVER:
                play(sound.getFilePath());
                break;
            default:
                throw new IllegalArgumentException("Sound not found");
        }
    }

    /**
     * Plays a sound file from the given file path.
     * This is a simulated method for demonstration purposes. The actual implementation should involve audio playback logic.
     *
     * @param filePath The file path of the sound file to be played.
     */
    private static void play(String filePath) {
        // Simulate playing the sound file
        // Actual implementation would involve audio playback logic
    }
}

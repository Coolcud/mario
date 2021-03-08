package game;

import javax.sound.sampled.Clip;
import java.util.HashMap;
import java.util.Map;

/**
 * Manages playable sounds.
 * Created by Kneesnap on 3/7/2021.
 */
public class GameSoundManager {
    private final Map<String, GameSound> soundMap = new HashMap<>();

    /**
     * Gets a sound by its name. (Case-sensitive.)
     * @param soundName The name of the sound to get.
     * @return gameSound, or null, if the sound does not exist.
     */
    public GameSound getSound(String soundName) {
        return this.soundMap.get(soundName);
    }

    /**
     * Plays a sound.
     * @param soundName The name of the sound to play.
     */
    public void playSound(String soundName) {
        GameSound sound = getSound(soundName);
        if (sound == null)
            throw new NullPointerException("Could not play sound '" + soundName + "', because that sound is not loaded or does not exist.");
        sound.play();
    }

    /**
     * Loads a game sound by its file name.
     * @param soundFileName The sound which should be loaded.
     * @return loadedSound
     */
    public GameSound loadSound(String soundFileName) {
        if (!soundFileName.contains("."))
            soundFileName += ".wav";
        Clip loadedClip = GameSound.loadClipFromResource(soundFileName);

        String soundName = soundFileName.split("\\.")[0];
        GameSound newSound = new GameSound(soundName, loadedClip);
        this.soundMap.put(soundName, newSound);
        return newSound;
    }

}

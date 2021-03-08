package game;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Represents a sound which can be played.
 * Created by Kneesnap on 3/7/2021.
 */
public class GameSound {
    private final String name;
    private final Clip clip;

    public GameSound(String name, Clip clip) {
        this.name = name;
        this.clip = clip;
    }

    /**
     * Plays this sound, does not block.
     */
    public void play() {
        this.clip.setMicrosecondPosition(0);
        this.clip.start();
    }

    /**
     * Gets the name of the sound.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the audio clip.
     */
    public Clip getClip() {
        return this.clip;
    }

    public static Clip loadClipFromResource(String soundFileName) {
        try {
            InputStream inputStream = GameSound.class.getClassLoader().getResourceAsStream("sounds/" + soundFileName);
            if (inputStream == null) {
                System.err.println("Sound file '" + soundFileName + "' could not be found.");
                System.exit(1);
            }

            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new BufferedInputStream(inputStream)));
            return clip;
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException ex) {
            System.err.println("Failed to load sound file '" + soundFileName + "'.");
            ex.printStackTrace();
            System.exit(1);
            return null;
        }
    }
}

package game;

import java.awt.*;

/**
 * The start of the program.
 */
public class Main {
    public static void main(String[] args) {
        TextureRegistry.loadTextures();
        EventQueue.invokeLater(() -> {
            Game marioGame = new Game("Super Mario Bros.");
            marioGame.start();
        });
    }
}

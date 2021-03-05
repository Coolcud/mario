package game;

import game.TextureRegistry.TextureSource;
import game.TextureRegistry.TextureTheme;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents an image which can be used in the game.
 * Created by Kneesnap on 3/4/2021.
 */
public class GameTexture {
    private final String name;
    private final TextureSource source;
    public final Map<TextureTheme, BufferedImage> loadedImages = new HashMap<>();
    private final BufferedImage defaultImage;

    public GameTexture(String name, TextureSource source, BufferedImage image) {
        this.name = name;
        this.source = source;
        this.defaultImage = image;
    }

    /**
     * Gets the name of the texture.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the actual image.
     */
    public BufferedImage getImage() {
        return this.defaultImage;
    }

    /**
     * Adds an image to the texture options.
     * @param theme The theme to add the texture for.
     * @param image The image to add.
     */
    public void addImage(TextureTheme theme, BufferedImage image) {
        this.loadedImages.put(theme, image);
    }

    /**
     * Gets the image for a given texture theme.
     * @param theme The theme to get the image for.
     * @return image
     */
    public BufferedImage getImage(TextureTheme theme) {
        if (this.source == null || this.loadedImages.isEmpty())
            return this.defaultImage;

        BufferedImage image = this.loadedImages.get(theme);
        return image != null ? image : (this.source == theme.sourceType ? this.defaultImage : null);
    }
}

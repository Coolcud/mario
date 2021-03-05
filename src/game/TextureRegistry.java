package game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * Contains a registry of all textures.
 * TODO: Mario + Animation + Invincibility.
 * TODO: Enemies.
 * Created by Kneesnap on 3/4/2021.
 */
@SuppressWarnings("unused")
public class TextureRegistry {
    private static final BufferedImage TILE_SHEET = loadImage("tilesheet.png");
    private static final BufferedImage PLAYER_SHEET = loadImage("mario.png");
    private static final BufferedImage ENTITY_SHEET = loadImage("entity.png");
    private static final BufferedImage HUD_SHEET = loadImage("hud.png");

    public enum TextureSource {
        PLAYER,
        ENTITY,
        TILE,
        TILE_PALETTE
    }

    public enum TextureTheme {
        MARIO(TextureSource.PLAYER, 0, 0),
        LUIGI(TextureSource.PLAYER, 0, 65),
        FIRE(TextureSource.PLAYER, 0, 131),
        INVINCIBLE_OVERWORLD(TextureSource.PLAYER, 0, 0), // TODO: These need fixing.
        INVINCIBLE_UNDERGROUND(TextureSource.PLAYER, 0, 0),
        INVINCIBLE_UNDERWATER(TextureSource.PLAYER, 0, 0),
        INVINCIBLE_CASTLE(TextureSource.PLAYER, 0, 0),

        ENTITY_OVERWORLD(TextureSource.ENTITY, 0, 0),
        ENTITY_UNDERGROUND(TextureSource.ENTITY, 0, 46),
        ENTITY_UNDERWATER(TextureSource.ENTITY, 0, 92),
        ENTITY_CASTLE(TextureSource.ENTITY, 0, 138),

        TILE_OVERWORLD(TextureSource.TILE, 0, 0),
        TILE_UNDERGROUND(TextureSource.TILE, 274, 0),
        TILE_UNDERWATER(TextureSource.TILE, 548, 0),
        TILE_CASTLE(TextureSource.TILE, 0, 173),

        TILE_ALTERNATE_PALETTE1(TextureSource.TILE_PALETTE, 0, 0), // TODO: Special?
        TILE_ALTERNATE_PALETTE2(TextureSource.TILE_PALETTE, 0, 0);

        public final TextureSource sourceType;
        public final int xOffset;
        public final int yOffset;

        TextureTheme(TextureSource sourceType, int xOffset, int yOffset) {
            this.sourceType = sourceType;
            this.xOffset = xOffset;
            this.yOffset = yOffset;
        }
    }

    // Tiles:
    public static final GameTexture QUESTION_BLOCK_1 = loadTileFromSheet(TextureSource.TILE, "Question Block (Frame #1)", 1, 63);
    public static final GameTexture QUESTION_BLOCK_2 = loadTileFromSheet(TextureSource.TILE, "Question Block (Frame #2)", 18, 63);
    public static final GameTexture QUESTION_BLOCK_3 = loadTileFromSheet(TextureSource.TILE, "Question Block (Frame #3)", 35, 63);
    public static final GameTexture QUESTION_BLOCK_4 = loadTileFromSheet(TextureSource.TILE, "Question Block (Frame #4)", 52, 63);

    public static final GameTexture VINE_TOP = loadTileFromSheet(TextureSource.TILE, "Vine Top", 69, 29);
    public static final GameTexture VINE_BODY = loadTileFromSheet(TextureSource.TILE, "Vine Body", 69, 46);
    public static final GameTexture FLAG_POLE_TOP = loadTileFromSheet(TextureSource.TILE, "Flag Pole Top", 86, 29);
    public static final GameTexture FLAG_POLE_BODY = loadTileFromSheet(TextureSource.TILE, "Flag Pole", 86, 46);
    public static final GameTexture FLAG_POLE_FLAG = loadTileFromSheet(TextureSource.TILE, "Flag", 137, 46);

    public static final GameTexture USED_BRICK = loadTileFromSheet(TextureSource.TILE, "Used Brick", 69, 63);
    public static final GameTexture STAIRCASE_BLOCK = loadTileFromSheet(TextureSource.TILE, "Staircase Block", 86, 63);

    public static final GameTexture SMALL_CLOUD = loadTileFromSheet(TextureSource.TILE, "Lakitu Cloud", 1, 97);
    public static final GameTexture BREAKABLE_BRICK_1 = loadTileFromSheet(TextureSource.TILE, "Breakable Brick #1", 18, 97);
    public static final GameTexture BREAKABLE_BRICK_2 = loadTileFromSheet(TextureSource.TILE, "Breakable Brick #2", 35, 97);
    public static final GameTexture BREAKABLE_BRICK_PIECE = loadTileFromSheet(TextureSource.TILE, "Breakable Brick Piece", 52, 97);

    public static final GameTexture FENCE_BLOCK = loadTileFromSheet(TextureSource.TILE, "Fence Block", 1, 114);
    public static final GameTexture GROUND_BRICK = loadTileFromSheet(TextureSource.TILE, "Ground Brick", 1, 131);

    public static final GameTexture CASTLE_TOP = loadTileFromSheet(TextureSource.TILE, "Castle Flute Top", 69, 114);
    public static final GameTexture CASTLE_ENTRANCE_TOP = loadTileFromSheet(TextureSource.TILE, "Castle Entrance Top", 86, 114);
    public static final GameTexture CASTLE_MIDDLE = loadTileFromSheet(TextureSource.TILE, "Castle Flute Middle", 103, 114);
    public static final GameTexture CASTLE_ENTRANCE_LEFT = loadTileFromSheet(TextureSource.TILE, "Castle Entrance Left", 69, 131);
    public static final GameTexture CASTLE_ENTRANCE_MIDDLE = loadTileFromSheet(TextureSource.TILE, "Castle Entrance Middle", 86, 131);
    public static final GameTexture CASTLE_ENTRANCE_RIGHT = loadTileFromSheet(TextureSource.TILE, "Castle Entrance Right", 103, 131);

    public static final GameTexture UPRIGHT_PIPE_ENTRANCE_LEFT = loadTileFromSheet(TextureSource.TILE, "Upright Pipe Entrance Left", 103, 46);
    public static final GameTexture UPRIGHT_PIPE_ENTRANCE_RIGHT = loadTileFromSheet(TextureSource.TILE, "Upright Pipe Entrance Right", 120, 46);
    public static final GameTexture UPRIGHT_PIPE_BODY_LEFT = loadTileFromSheet(TextureSource.TILE, "Upright Pipe Body Left", 103, 63);
    public static final GameTexture UPRIGHT_PIPE_BODY_RIGHT = loadTileFromSheet(TextureSource.TILE, "Upright Pipe Body Right", 120, 63);

    public static final GameTexture SIDEWAYS_PIPE_ENTRANCE_LEFT = loadTileFromSheet(TextureSource.TILE, "Sideways Pipe Entrance Top", 69, 80);
    public static final GameTexture SIDEWAYS_PIPE_ENTRANCE_RIGHT = loadTileFromSheet(TextureSource.TILE, "Sideways Pipe Entrance Bottom", 69, 97);
    public static final GameTexture SIDEWAYS_PIPE_BODY_TOP = loadTileFromSheet(TextureSource.TILE, "Sideways Pipe Body Top", 86, 80);
    public static final GameTexture SIDEWAYS_PIPE_BODY_BOTTOM = loadTileFromSheet(TextureSource.TILE, "Sideways Pipe Body Bottom", 86, 97);
    public static final GameTexture SIDEWAYS_PIPE_CONNECTION_TOP = loadTileFromSheet(TextureSource.TILE, "Sideways Pipe Top Connection", 103, 80);

    public static final GameTexture SMOOTH_MUSHROOM_PLATFORM_LEFT = loadTileFromSheet(TextureSource.TILE, "Smooth Mushroom Platform (Left)", 137, 12);
    public static final GameTexture SMOOTH_MUSHROOM_PLATFORM_MIDDLE = loadTileFromSheet(TextureSource.TILE, "Smooth Mushroom Platform (Middle)", 154, 12);
    public static final GameTexture SMOOTH_MUSHROOM_PLATFORM_RIGHT = loadTileFromSheet(TextureSource.TILE, "Smooth Mushroom Platform (Right)", 171, 12);
    public static final GameTexture SMOOTH_MUSHROOM_BODY = loadTileFromSheet(TextureSource.TILE, "Smooth Mushroom Body", 154, 29);

    public static final GameTexture MUSHROOM_PLATFORM_LEFT = loadTileFromSheet(TextureSource.TILE, "Mushroom Platform (Left)", 188, 12);
    public static final GameTexture MUSHROOM_PLATFORM_MIDDLE = loadTileFromSheet(TextureSource.TILE, "Mushroom Platform (Middle)", 205, 12);
    public static final GameTexture MUSHROOM_PLATFORM_RIGHT = loadTileFromSheet(TextureSource.TILE, "Mushroom Platform (Right)", 222, 12);
    public static final GameTexture MUSHROOM_BODY1_BOTTOM = loadTileFromSheet(TextureSource.TILE, "Mushroom Body #1 (Bottom)", 188, 46);
    public static final GameTexture MUSHROOM_BODY1_TOP = loadTileFromSheet(TextureSource.TILE, "Mushroom Body #1 (Top)", 188, 29);
    public static final GameTexture MUSHROOM_BODY2_BOTTOM = loadTileFromSheet(TextureSource.TILE, "Mushroom Body #2 (Bottom)", 205, 46);
    public static final GameTexture MUSHROOM_BODY2_TOP = loadTileFromSheet(TextureSource.TILE, "Mushroom Body #2 (Top)", 205, 29);

    public static final GameTexture WATER_TOP = loadTileFromSheet(TextureSource.TILE, "Water/Lava (Top)", 171, 12);
    public static final GameTexture WATER_BODY = loadTileFromSheet(TextureSource.TILE, "Water/Lava (Body)", 171, 29);

    public static final GameTexture DECORATION_PLANT_BODY = loadTileFromSheet(TextureSource.TILE, "Plant Body", 222, 46);
    public static final GameTexture DECORATION_SMALL_PLANT_HEAD = loadTileFromSheet(TextureSource.TILE, "Small Plant Head", 222, 29);
    public static final GameTexture DECORATION_LARGE_PLANT_HEAD_TOP = loadTileFromSheet(TextureSource.TILE, "Large Plant Head (Top)", 239, 12);
    public static final GameTexture DECORATION_LARGE_PLANT_HEAD_BOTTOM = loadTileFromSheet(TextureSource.TILE, "Large Plant Head (Bottom)", 239, 29);

    public static final GameTexture DECORATION_BUSH_LEFT = loadTileFromSheet(TextureSource.TILE, "Bush (Left)", 222, 97);
    public static final GameTexture DECORATION_BUSH_MIDDLE = loadTileFromSheet(TextureSource.TILE, "Bush (Middle)", 239, 97);
    public static final GameTexture DECORATION_BUSH_RIGHT = loadTileFromSheet(TextureSource.TILE, "Bush (Right)", 256, 97);

    public static final GameTexture DECORATION_CLOUD_TOP_LEFT = loadTileFromSheet(TextureSource.TILE, "Cloud (Top Left)", 222, 63);
    public static final GameTexture DECORATION_CLOUD_TOP_MIDDLE = loadTileFromSheet(TextureSource.TILE, "Cloud (Top Middle)", 239, 63);
    public static final GameTexture DECORATION_CLOUD_TOP_RIGHT = loadTileFromSheet(TextureSource.TILE, "Cloud (Top Right)", 256, 63);
    public static final GameTexture DECORATION_CLOUD_BOTTOM_LEFT = loadTileFromSheet(TextureSource.TILE, "Cloud (Bottom Left)", 222, 80);
    public static final GameTexture DECORATION_CLOUD_BOTTOM_MIDDLE = loadTileFromSheet(TextureSource.TILE, "Cloud (Bottom Middle)", 239, 80);
    public static final GameTexture DECORATION_CLOUD_BOTTOM_RIGHT = loadTileFromSheet(TextureSource.TILE, "Cloud (Bottom Right)", 256, 80);

    public static final GameTexture DECORATION_HILL_TOP = loadTileFromSheet(TextureSource.TILE, "Hill (Top)", 171, 63);
    public static final GameTexture DECORATION_HILL_MIDDLE_LEFT = loadTileFromSheet(TextureSource.TILE, "Hill (Middle Left)", 154, 80);
    public static final GameTexture DECORATION_HILL_MIDDLE_MIDDLE = loadTileFromSheet(TextureSource.TILE, "Hill (Middle)", 171, 80);
    public static final GameTexture DECORATION_HILL_MIDDLE_RIGHT = loadTileFromSheet(TextureSource.TILE, "Hill (Middle Right)", 186, 80);
    public static final GameTexture DECORATION_HILL_BOTTOM_LEFTMOST = loadTileFromSheet(TextureSource.TILE, "Hill (Bottom Furthest Left)", 137, 97);
    public static final GameTexture DECORATION_HILL_BOTTOM_LEFT = loadTileFromSheet(TextureSource.TILE, "Hill (Bottom Left)", 154, 97);
    public static final GameTexture DECORATION_HILL_BOTTOM_MIDDLE = loadTileFromSheet(TextureSource.TILE, "Hill (Bottom Middle)", 171, 97);
    public static final GameTexture DECORATION_HILL_BOTTOM_RIGHT = loadTileFromSheet(TextureSource.TILE, "Hill (Bottom Middle Right)", 186, 97);
    public static final GameTexture DECORATION_HILL_BOTTOM_RIGHTMOST = loadTileFromSheet(TextureSource.TILE, "Hill (Middle Furthest Right)", 203, 97);

    // Entities:

    public static final GameTexture FIRE_BLAZE_1 = loadTileFromSheet(TILE_SHEET, "Fire Blaze (Frame #1)", 621, 202);
    public static final GameTexture FIRE_BLAZE_2 = loadTileFromSheet(TILE_SHEET, "Fire Blaze (Frame #2)", 638, 202);
    public static final GameTexture FIRE_BLAZE_3 = loadTileFromSheet(TILE_SHEET, "Fire Blaze (Frame #3)", 655, 202);

    public static final GameTexture TOAD = loadTextureFromSheet(TILE_SHEET, "Toad", 549, 219, 16, 32);
    public static final GameTexture PRINCESS_TOADSTOOL = loadTextureFromSheet(TILE_SHEET, "Princess Toadstool", 566, 219, 16, 32);

    public static final GameTexture METAL_PLATFORM_PIECE = loadTileFromSheet(TILE_SHEET, "Metal Platform Piece", 566, 185);
    public static final GameTexture METAL_CHAIN_PIECE = loadTileFromSheet(TILE_SHEET, "Chain Piece", 583, 185);
    public static final GameTexture FIREBALL = loadTileFromSheet(TILE_SHEET, "Fireball", 600, 185);
    public static final GameTexture WATER_BUBBLE = loadTileFromSheet(TILE_SHEET, "Bubble Particle", 617, 185);

    // Items:
    public static final GameTexture SUPER_MUSHROOM = loadTileFromSheet(TILE_SHEET, "Super Mushroom", 549, 185);
    public static final GameTexture MUSHROOM_EXTRA_LIFE = loadTileFromSheet(TextureSource.TILE, "1-UP Mushroom", 69, 12);

    public static final GameTexture FIRE_FLOWER_1 = loadTileFromSheet(TextureSource.TILE, "Fire Flower (Frame #1)", 1, 12);
    public static final GameTexture FIRE_FLOWER_2 = loadTileFromSheet(TextureSource.TILE, "Fire Flower (Frame #2)", 18, 12);
    public static final GameTexture FIRE_FLOWER_3 = loadTileFromSheet(TextureSource.TILE, "Fire Flower (Frame #3)", 35, 12);
    public static final GameTexture FIRE_FLOWER_4 = loadTileFromSheet(TextureSource.TILE, "Fire Flower (Frame #4)", 52, 12);

    public static final GameTexture STAR_1 = loadTileFromSheet(TextureSource.TILE, "Invincibility Star (Frame #1)", 1, 29);
    public static final GameTexture STAR_2 = loadTileFromSheet(TextureSource.TILE, "Invincibility Star (Frame #2)", 18, 29);
    public static final GameTexture STAR_3 = loadTileFromSheet(TextureSource.TILE, "Invincibility Star (Frame #3)", 35, 29);
    public static final GameTexture STAR_4 = loadTileFromSheet(TextureSource.TILE, "Invincibility Star (Frame #4)", 52, 29);

    public static final GameTexture COIN_1 = loadTileFromSheet(TextureSource.TILE, "Coin (Frame #1)", 1, 46);
    public static final GameTexture COIN_2 = loadTileFromSheet(TextureSource.TILE, "Coin (Frame #2)", 18, 46);
    public static final GameTexture COIN_3 = loadTileFromSheet(TextureSource.TILE, "Coin (Frame #3)", 35, 46);
    public static final GameTexture COIN_4 = loadTileFromSheet(TextureSource.TILE, "Coin (Frame #4)", 52, 46);

    // Misc.
    public static final GameTexture CASTLE_FLAG = loadTileFromSheet(TILE_SHEET, "Castle Flag", 634, 185);

    // This is the coin sprite which shoots out of a brick block when you smash it.
    public static final GameTexture BRICK_COIN_COLLECT_1 = loadTileFromSheet(TILE_SHEET, "Brick Coin Collect (Frame #1)", 549, 202);
    public static final GameTexture BRICK_COIN_COLLECT_2 = loadTileFromSheet(TILE_SHEET, "Brick Coin Collect (Frame #2)", 566, 202);
    public static final GameTexture BRICK_COIN_COLLECT_3 = loadTileFromSheet(TILE_SHEET, "Brick Coin Collect (Frame #3)", 583, 202);
    public static final GameTexture BRICK_COIN_COLLECT_4 = loadTileFromSheet(TILE_SHEET, "Brick Coin Collect (Frame #4)", 600, 202);
    // Screens.
    public static final GameTexture TITLE_SCREEN = loadTextureFromSheet(HUD_SHEET, "Title Screen", 1, 10, 256, 224);
    public static final GameTexture LEVEL_INTRO_SCREEN = loadTextureFromSheet(HUD_SHEET, "Level Intro Screen", 260, 10, 256, 224);
    public static final GameTexture HUD_OVERLAY = loadTextureFromSheet(HUD_SHEET, "HUD Overlay", 519, 10, 256, 224);
    public static final GameTexture TIME_UP_SCREEN = loadTextureFromSheet(HUD_SHEET, "Time Up Screen", 1, 10, 256, 224);
    public static final GameTexture GAME_OVER_SCREEN = loadTextureFromSheet(HUD_SHEET, "Game Over Screen", 260, 10, 256, 224);

    private static final GameTexture[] LETTER_TEXTURES = new GameTexture[26];
    private static final GameTexture[] DIGIT_TEXTURES = new GameTexture[10];
    private static final GameTexture MINUS_TEXTURE = loadIconFromSheet(HUD_SHEET, "Minus Character", 609, 257);
    private static final GameTexture MULTIPLY_TEXTURE = loadIconFromSheet(HUD_SHEET, "Multiply Character", 618, 257);
    private static final GameTexture EXCLAMATION_TEXTURE = loadIconFromSheet(HUD_SHEET, "Exclamation Character", 627, 257);
    private static final GameTexture COPYRIGHT_TEXTURE = loadIconFromSheet(HUD_SHEET, "Copyright Character", 636, 257);
    private static final GameTexture PERIOD_TEXTURE = loadIconFromSheet(HUD_SHEET, "Period Character", 645, 257);
    private static final GameTexture PLACEHOLDER_ICON_TEXTURE = loadIconFromSheet(HUD_SHEET, "Placeholder Icon", 654, 257);

    // HUD.
    public static final GameTexture ICON_MUSHROOM = loadIconFromSheet(HUD_SHEET, "Mushroom Icon", 519, 266);
    public static final GameTexture ICON_CROWN = loadIconFromSheet(HUD_SHEET, "Crown Icon", 528, 266);

    public static final GameTexture ICON_COIN_1 = loadIconFromSheet(HUD_SHEET, "Coin Icon (Frame #1)", 519, 283);
    public static final GameTexture ICON_COIN_2 = loadIconFromSheet(HUD_SHEET, "Coin Icon (Frame #2)", 528, 283);
    public static final GameTexture ICON_COIN_3 = loadIconFromSheet(HUD_SHEET, "Coin Icon (Frame #3)", 537, 283);
    public static final GameTexture ICON_COIN_4 = loadIconFromSheet(HUD_SHEET, "Coin Icon (Frame #4)", 546, 283);

    public static final GameTexture ICON_SCORE_10 = loadIconFromSheet(TILE_SHEET, "Score 10", 655, 185);
    public static final GameTexture ICON_SCORE_20 = loadIconFromSheet(TILE_SHEET, "Score 20", 664, 185);
    public static final GameTexture ICON_SCORE_40 = loadIconFromSheet(TILE_SHEET, "Score 40", 673, 185);
    public static final GameTexture ICON_SCORE_50 = loadIconFromSheet(TILE_SHEET, "Score 50", 682, 185);
    public static final GameTexture ICON_SCORE_80 = loadIconFromSheet(TILE_SHEET, "Score 80", 691, 185);
    public static final GameTexture ICON_SCORE_0 = loadIconFromSheet(TILE_SHEET, "Score 0", 700, 185);
    public static final GameTexture ICON_SCORE_00 = loadIconFromSheet(TILE_SHEET, "Score 00", 709, 185);
    public static final GameTexture ICON_SCORE_1UP = loadTextureFromSheet(TILE_SHEET, "1UP Notifier", 718, 185, 16, 8);

    /**
     * Gets the GameTexture for a given text character. Used for writing text.
     * @param character The character to get text for.
     * @return gameTexture
     */
    public static GameTexture getCharacterTexture(char character) {
        if (character >= 'a' && character <= 'z')
            return LETTER_TEXTURES[character - 'a'];
        if (character >= 'A' && character <= 'Z')
            return LETTER_TEXTURES[character - 'A'];
        if (character >= '0' && character <= '9')
            return DIGIT_TEXTURES[character - '0'];

        switch (character) {
            case '-':
                return MINUS_TEXTURE;
            case '*':
                return MULTIPLY_TEXTURE;
            case '!':
                return EXCLAMATION_TEXTURE;
            case '©':
                return COPYRIGHT_TEXTURE;
            case '.':
                return PERIOD_TEXTURE;
            default: // There was no character found, so return a placeholder.
                return PLACEHOLDER_ICON_TEXTURE;
        }
    }

    /**
     * Loads a game texture from a texture sheet.
     * @param source  The source to load the image from.
     * @param texName The name of the game texture.
     * @param startX  The x position on the sheet where the image starts at.
     * @param startY  The y position on the sheet where the image starts at.
     * @return loadedGameTexture
     */
    public static GameTexture loadIconFromSheet(TextureSource source, String texName, int startX, int startY) {
        return loadTextureFromSheet(source, texName, startX, startY, 8, 8);
    }

    /**
     * Loads a game texture from a texture sheet.
     * @param sheet   The sheet to load the image from.
     * @param texName The name of the game texture.
     * @param startX  The x position on the sheet where the image starts at.
     * @param startY  The y position on the sheet where the image starts at.
     * @return loadedGameTexture
     */
    public static GameTexture loadIconFromSheet(BufferedImage sheet, String texName, int startX, int startY) {
        return loadTextureFromSheet(sheet, texName, startX, startY, 8, 8);
    }

    /**
     * Loads a game texture from a texture sheet.
     * @param source  The source to load the image from.
     * @param texName The name of the game texture.
     * @param startX  The x position on the sheet where the image starts at.
     * @param startY  The y position on the sheet where the image starts at.
     * @return loadedGameTexture
     */
    public static GameTexture loadTileFromSheet(TextureSource source, String texName, int startX, int startY) {
        return loadTextureFromSheet(source, texName, startX, startY, 16, 16);
    }

    /**
     * Loads a game texture from a texture sheet.
     * @param image   The source image sheet to load the image from.
     * @param texName The name of the game texture.
     * @param startX  The x position on the sheet where the image starts at.
     * @param startY  The y position on the sheet where the image starts at.
     * @return loadedGameTexture
     */
    public static GameTexture loadTileFromSheet(BufferedImage image, String texName, int startX, int startY) {
        return loadTextureFromSheet(image, texName, startX, startY, 16, 16);
    }

    /**
     * Loads a game texture from a texture sheet.
     * @param sheet     The sheet to load the image from.
     * @param texName   The name of the game texture.
     * @param startX    The x position on the sheet where the image starts at.
     * @param startY    The y position on the sheet where the image starts at.
     * @param texWidth  The width (in pixels) of the image.
     * @param texHeight The height (in pixels) of the image.
     * @return loadedGameTexture
     */
    public static GameTexture loadTextureFromSheet(BufferedImage sheet, String texName, int startX, int startY, int texWidth, int texHeight) {
        return new GameTexture(texName, null, sheet.getSubimage(startX, startY, texWidth, texHeight));
    }

    /**
     * Loads a game texture from a texture sheet.
     * @param texSource The source to load the image from.
     * @param texName   The name of the game texture.
     * @param startX    The x position on the sheet where the image starts at.
     * @param startY    The y position on the sheet where the image starts at.
     * @param texWidth  The width (in pixels) of the image.
     * @param texHeight The height (in pixels) of the image.
     * @return loadedGameTexture
     */
    public static GameTexture loadTextureFromSheet(TextureSource texSource, String texName, int startX, int startY, int texWidth, int texHeight) {
        BufferedImage sheetImage;
        switch (texSource) {
            case TILE:
                sheetImage = TILE_SHEET;
                break;
            case ENTITY:
                sheetImage = ENTITY_SHEET;
                break;
            case PLAYER:
                sheetImage = PLAYER_SHEET;
                break;
            default:
                throw new UnsupportedOperationException("Can't load textures from source '" + texSource + "'.");
        }

        GameTexture texture = new GameTexture(texName, texSource, sheetImage.getSubimage(startX, startY, texWidth, texHeight));
        for (TextureTheme theme : TextureTheme.values())
            if (theme.sourceType == texSource)
                texture.addImage(theme, sheetImage.getSubimage(startX + theme.xOffset, startY + theme.yOffset, texWidth, texHeight));

        return texture;
    }

    /**
     * Loads an image texture by the image name.
     * Images should be in the resources/images folder.
     * Exits the program if it fails to load. (Bad practice, but it's fine for learning.)
     * @param imageName The name of the image file to load.
     * @return loadedImage
     */
    public static BufferedImage loadImage(String imageName) {
        try {
            InputStream inputStream = TextureRegistry.class.getClassLoader().getResourceAsStream("images/" + imageName);
            if (inputStream == null) {
                System.err.println("Image file '" + imageName + "' could not be found.");
                System.exit(1);
            }

            return ImageIO.read(inputStream);
        } catch (IOException ex) {
            System.err.println("Failed to load image '" + imageName + "'.");
            ex.printStackTrace();
            System.exit(1);
            return null;
        }
    }

    public static void loadTextures() {
        // Read letters.
        for (int i = 0; i < 26; i++)
            LETTER_TEXTURES[i] = loadIconFromSheet(HUD_SHEET, "Letter '" + (char) (i + 'A') + "'", 519 + (9 * i), 248);

        // Read digits.
        for (int i = 0; i < 10; i++)
            DIGIT_TEXTURES[i] = loadIconFromSheet(HUD_SHEET, "Number " + i, 519 + (9 * i), 257);

        // TODO: Add alternate tiles.

        System.out.println("Textures have been successfully loaded.");
    }
}

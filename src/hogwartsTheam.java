import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class hogwartsTheam {

    // --- COLORS ---
    public static final Color OLIVE_HARVEST = new Color(0x9D9167);
    public static final Color GOLDEN_BATTER = new Color(0xE8D1A7);
    public static final Color CARAMEL = new Color(0x84592B);
    public static final Color WINE = new Color(0x743014);
    public static final Color COCOA = new Color(0x442D1C);
    public static final Color LIGHT_BROWN = new Color(0xF4EBD0);

    // --- HOUSE COLORS ---
    public static final Color slythrin_main = new Color(0x1a472a);
    public static final Color slythrin_second = new Color(0xaaaaaa);
    public static final Color griffindor_main = new Color(0x740001);
    public static final Color griffindor_second = new Color(0xeeba30);
    public static final Color ravenclaw_main = new Color(0x0e1a40);
    public static final Color revenclaw_second = new Color(0xbebebe);
    public static final Color Hufflepuff_main = new Color(0xecb939);
    public static final Color Hufflepuff_second = new Color(0x372e29);

    // --- FONTS ---
    public static final Font HEAD_LINE;
    public static final Font TABLE_HEAD_LINE;
    public static final Font TABLE_HEAD_LINE1;
    public static final Font REGULAR;
    public static final Font REGULAR1;

    // Static block to initialize fonts from files
    static {
        // Change these filenames to match your actual .ttf files exactly
        Font castellarBase = loadFontFile("/resources/castellar.ttf", "Castellar");
        Font youYuanBase = loadFontFile("/resources/YouYuan.ttf", "YouYuan");

        // Derive fonts with specific sizes
        HEAD_LINE = castellarBase.deriveFont(Font.PLAIN, 25f);
        TABLE_HEAD_LINE = castellarBase.deriveFont(Font.PLAIN, 15f);
        TABLE_HEAD_LINE1 = castellarBase.deriveFont(Font.PLAIN, 20f);
        
        REGULAR = youYuanBase.deriveFont(Font.PLAIN, 20f);
        REGULAR1 = youYuanBase.deriveFont(Font.PLAIN, 14f);
    }

    /**
     * Internal helper to load and register the font
     */
    private static Font loadFontFile(String path, String fallbackName) {
        try (InputStream is = hogwartsTheam.class.getResourceAsStream(path)) {
            if (is == null) {
                System.err.println("Could not find font file at " + path + ". Using fallback.");
                return new Font(fallbackName, Font.PLAIN, 12);
            }
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            // Register font so Java knows the name "Castellar" or "YouYuan"
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(font);
            return font;
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            return new Font(fallbackName, Font.PLAIN, 12);
        }
    }
}
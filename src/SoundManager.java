import javax.sound.sampled.*;
import java.io.File;

public class SoundManager {
    private static Clip clip;
    private static long pausePosition; // Stores where the music stopped

    public static void playBackgroundMusic(String filePath) {
        try {
            File musicPath = new File(filePath);
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // The "Silencio" Charm (Pause)
    public static void pauseMusic() {
        if (clip != null && clip.isRunning()) {
            pausePosition = clip.getMicrosecondPosition(); // Record the time
            clip.stop(); // Stop the playback
        }
    }

    // The "Sonorus" Charm (Resume)
    public static void resumeMusic() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(pausePosition); // Set back to saved time
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
}
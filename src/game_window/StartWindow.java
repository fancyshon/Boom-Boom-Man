package game_window;
import javax.sound.sampled.*;
import java.io.*; 

public class StartWindow {
    public static void main(String[] args) {
        Menu t = new Menu();
        t.setVisible(true);

        AePlayWave apw = new AePlayWave("boommusic.wav");
        apw.start();
    }
}
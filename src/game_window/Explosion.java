package game_window;

import java.awt.*;
import java.io.File;
import java.util.TimerTask;
import javax.imageio.ImageIO;

public class Explosion extends TimerTask{
    private Image image;
    private int x, y;
    static public boolean isExplo = false;

    public Explosion() {
        try {
            image = ImageIO.read(new File("fire.gif"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Draw(Graphics g) {
        g.drawImage(image, x, y, 50, 50, null);
        boolean up = true, down = true, left = true, right = true;

        for (int j = 1; j <= Player.num_of_waterball_of_P1 + 1; ++j) {
            
            for (int i = 0; i < 102; ++i) {

                if ((x + 50*j == Map.tree_x[i] || x + 50*j >= 50 * 18)
                        && (y == Map.tree_y[i] || y - 25 == Map.tree_y[i] || y + 25 == Map.tree_y[i]))
                    right = false;
                if (x - 50*j == Map.tree_x[i]
                        && (y == Map.tree_y[i] || y - 25 == Map.tree_y[i] || y + 25 == Map.tree_y[i]))
                    left = false;
                if ((x == Map.tree_x[i] || x + 25 == Map.tree_x[i] || x - 25 == Map.tree_x[i])
                        && y + 50*j == Map.tree_y[i])
                    down = false;
                if ((x == Map.tree_x[i] || x + 25 == Map.tree_x[i] || x - 25 == Map.tree_x[i])
                        && y - 50*j == Map.tree_y[i])
                    up = false;

            }

            if (right)
                g.drawImage(image, x + 50*j, y, 50, 50, null);
            if (left)
                g.drawImage(image, x - 50*j, y, 50, 50, null);
            if (down)
                g.drawImage(image, x, y + 50*j, 50, 50, null);
            if (up)
                g.drawImage(image, x, y - 50*j, 50, 50, null);
        }
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
    public void run() {
        isExplo = false;            
    }

}
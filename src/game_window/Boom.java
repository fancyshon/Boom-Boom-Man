package game_window;

import java.io.File;
import java.util.TimerTask;
import javax.imageio.ImageIO;
import java.awt.*;


public class Boom extends TimerTask{

    private Image image;
    private int x, y, px, py;
    static public boolean setBomb = false;
    
    public Boom() {
        try {
            image = ImageIO.read(new File("boom.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Boom(int x,int y){   //For timer.
        try {
            this.x = x;
            this.y = y;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Draw(Graphics g) {
        g.drawImage(image, x, y, 50, 50, null);
    }

    public void explosion(int x, int y) {
        boolean UpBlocked=false,DownB=false,RightB=false,LeftB=false;

        for (int i = 0; i < 99; i++) {

            int Tx=Map.tree_x[i],Ty=Map.tree_y[i];

            if (Tx == this.x && Ty == this.y - 50 )
                UpBlocked=true;
            if (Tx == this.x && Ty == this.y + 50 )
                DownB=true;
            if(Tx == this.x+50 && Ty == this.y )
                RightB=true;
            if(Tx == this.x-50 && Ty == this.y )
                LeftB=true;
        }

        for (int j = 1; j <= Player.num_of_waterball_of_P1 + 1; ++j) {

            for (int i = 0; i < 99; i++) {
                int Bx = Map.box_x[i];
                int By = Map.box_y[i];

                if (Bx == this.x && By == this.y - 50 * j && !UpBlocked) { //Above
                    Map.existBox[i] = false;
                    for (int xi = 0; xi < 24; ++xi) {
                        int m = Item.item_x[xi], n = Item.item_y[xi];
                        if (m == Bx && n == By && Item.used[xi] == false) {
                            Item.existitem[xi] = true;
                            break;
                        }
                    }
                }
                if (Bx == this.x && By == this.y + 50 * j && !DownB) { //Under
                    Map.existBox[i] = false;
                    for (int xi = 0; xi < 24; ++xi) {
                        int m = Item.item_x[xi], n = Item.item_y[xi];
                        if (m == Bx && n == By && Item.used[xi] == false) {
                            Item.existitem[xi] = true;
                            break;
                        }
                    }
                }
                if (Bx == this.x + 50 * j && By == this.y && !RightB) { //right
                    Map.existBox[i] = false;
                    for (int xi = 0; xi < 24; ++xi) {
                        int m = Item.item_x[xi], n = Item.item_y[xi];
                        if (m == Bx && n == By && Item.used[xi] == false) {
                            Item.existitem[xi] = true;
                            break;
                        }
                    }
                }
                if (Bx == this.x - 50 * j && By == this.y && !LeftB) { //Left
                    Map.existBox[i] = false;
                    for (int xi = 0; xi < 24; ++xi) {
                        int m = Item.item_x[xi], n = Item.item_y[xi];
                        if (m == Bx && n == By && Item.used[xi] == false) {
                            Item.existitem[xi] = true;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    public void setX(int x) {
        setBomb = true;
        this.x = x;
    }

    public void setY(int y) {
        setBomb = true;
        this.y = y;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return y;
    }
    
    public void run() {
        explosion(x, y);
        setBomb = false;
        Explosion.isExplo = true;
    }
}
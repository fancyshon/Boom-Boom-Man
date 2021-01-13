package game_window;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Line2D;

public class Item {
 static public int[] item_x = {250,450,
          200,450,
          650,
          50,400,
          450,
          650,
          50,800,
          200,400,450,650,
          400,700,
          500,
          200,350,700,
          100,500,
          600};
 static public int[] item_y = {50,50,
          100,100,
          150,
          200,200,
          250,
          300,
          350,350,
          400,400,400,400,
          450,450,
          500,
          550,550,550,
          600,600,
          650};
 File pathToFile1;
 Image image1;
 static public boolean[] existitem = new boolean[24];
 static public boolean[] used = new boolean[24];

 public Item() {
  try {
   pathToFile1 = new File("waterball.png");
   image1 = ImageIO.read(pathToFile1);
  }catch (IOException ex) {
   ex.printStackTrace();
  }
  for(int i=0;i<24;i++) {
   existitem[i] = false;
   used[i] = false;
  }
 }
 public void Draw(Graphics g)
 {
  for(int i = 0;i < 24;i++)
  {
   if(existitem[i])
    g.drawImage(image1, item_x[i],item_y[i],50,50,null);
  }
  
  
 }
}

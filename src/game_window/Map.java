/*package game_window;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Map {
	
	
	//地圖上不會被破壞的方塊tree 總共106個
	 
	
	static public int[] tree_x = {50,50 ,50 ,50 ,50 ,50 ,50 ,50 ,50 ,150,200,250,300,400,500,550,600,650,700,800,
			800,200,550,150,0  ,150,250,350,400,500,600,650,750,800,850,400,150,200,250,300,350,400,500,600,700,750,800,
			650,350,500,150,250,350,400,450,500,550,600,650,700,800,450,800,0  ,100,150,250,350,400,500,600,700,800,850,
			350,800,50 ,100,150,200,300,350,400,450,500,550,600,650,700,800,150,200,300,500,550,50 ,150,300,400,450,550,
			650,700,200,800,700};
	static public int[] tree_y = {50,100,150,200,250,350,400,450,600,50 ,50 ,50 ,50 ,50 ,50 ,50 ,50 ,50 ,50 ,50 ,
			600,0  ,0  ,100,150,150,150,150,150,150,150,150,150,150,150,200,250,250,250,250,250,250,250,250,250,250,250,
			200,300,300,350,350,350,350,350,350,350,350,350,350,350,400,400,450,450,450,450,450,450,450,450,450,450,450,
			500,500,550,550,550,550,550,550,550,550,550,550,550,550,550,550,600,600,600,600,600,650,650,650,650,650,650,
			650,650,700,700,700};
	
	
	//地圖上可以被破壞的方塊box 總共43個
	 
	static public int[] box_x = {100,150,300,350,400,450,600,700,800,150,0  ,250,350,400,600,0  ,150,350,450,800,
				0  ,150,250,300,700,0  ,150,300,600,50 ,200,450,650,0  ,100,450,600,850,250,500,150,400,650};
	static public int[] box_y = {0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,0  ,50 ,100,100,100,100,100,200,200,200,200,200,
				300,300,300,300,300,400,400,400,400,500,500,500,500,600,600,600,600,600,650,650,700,700,700};
	File pathToFile1;
	File pathToFile2;
	Image image1;
	Image image2;
	static public boolean[] existBox = new boolean[43];
		
	public Map() {
		//讀取地圖物件圖片
		try {
			pathToFile1 = new File("tree.png");
			image1 = ImageIO.read(pathToFile1);
			pathToFile2 = new File("box.png");
			image2 = ImageIO.read(pathToFile2);
					
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		for(int i=0;i<43;++i)
			existBox[i] = true;
	}
	
	//繪製地圖
	public void Draw(Graphics g)
	{
		for(int i = 0;i < 106;i++)
		{
			g.drawImage(image1, tree_x[i],tree_y[i],50,50,null);
		}
		for(int i = 0;i < 43;i++){
			if (existBox[i]) {
				g.drawImage(image2,box_x[i],box_y[i],50,50,null);
			}
		}
		Graphics2D g2 = (Graphics2D)g;
		g2.setColor(Color.GRAY);
		Line2D line1 = new Line2D.Double(0,0,0,750);
		Line2D line2 = new Line2D.Double(0,750,900,750);
		Line2D line3 = new Line2D.Double(900,0,900,750);
		Line2D line4 = new Line2D.Double(0,0,900,0);
		g2.draw(line1);
		g2.draw(line2);
		g2.draw(line3);
		g2.draw(line4);
	}
}
*/

package game_window;

import java.awt.*;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Map {
 
 /*
  * 地圖上不會被破壞的方塊tree 總共102個
  */
 
static public int[] tree_x = {0,50,100,150,200,250,300,350,400,450,500,550,600,650,700,750,800,850,
           0,200,850,
           0,100,250,650,850,
           0,100,400,450,750,850,
           0,150,850,
           0,350,500,600,650,700,750,850,
           0,100,750,850,
           0,100,200,400,450,650,750,850,
           0,100,750,850,
           0,100,150,200,250,350,500,850,
           0,700,850,
           0,100,400,450,750,850,
           0,200,600,750,850,
           0,650,850,
           0,50,100,150,200,250,300,350,400,450,500,550,600,650,700,750,800,850};
static public int[] tree_y = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
           50,50,50,
           100,100,100,100,100,
           150,150,150,150,150,150,
           200,200,200,
           250,250,250,250,250,250,250,250,
           300,300,300,300,
           350,350,350,350,350,350,350,350,
           400,400,400,400,
           450,450,450,450,450,450,450,450,
           500,500,500,
           550,550,550,550,550,550,
           600,600,600,600,600,
           650,650,650,
           700,700,700,700,700,700,700,700,700,700,700,700,700,700,700,700,700,700};
 
 /*
  * 地圖上可以被破壞的方塊box 總99個
  */
static public int[] box_x = {250,300,350,400,450,500,
           150,200,350,400,450,500,600,700,750,
           50,150,200,350,500,600,650,700,
           50,100,200,350,400,450,500,
           100,150,200,400,450,
           50,350,400,450,500,600,650,700,800,
           50,150,250,350,500,600,700,800,
           50,150,200,250,350,400,450,500,600,650,700,800,
           400,450,650,700,750,
           350,400,450,500,650,750,800,
           150,200,250,350,500,650,700,800,
           100,150,250,350,400,450,500,650,700,
           350,400,450,500,550,600};
static public int[] box_y = {50,50,50,50,50,50,
           100,100,100,100,100,100,100,100,100,
           150,150,150,150,150,150,150,150,
           200,200,200,200,200,200,200,
           250,250,250,250,250,
           300,300,300,300,300,300,300,300,300,
           350,350,350,350,350,350,350,350,
           400,400,400,400,400,400,400,400,400,400,400,400,
           450,450,450,450,450,
           500,500,500,500,500,500,500,
           550,550,550,550,550,550,550,550,
           600,600,600,600,600,600,600,600,600,
           650,650,650,650,650,650};
 File pathToFile1;
 File pathToFile2;
 Image image1;
 Image image2;
 static public boolean[] existBox = new boolean[99];
  
 public Map() {
  //讀取地圖物件圖片
    try {
     pathToFile1 = new File("tree.png");
     image1 = ImageIO.read(pathToFile1);
     pathToFile2 = new File("box.png");
     image2 = ImageIO.read(pathToFile2);
       
    }
    catch (IOException ex) {
     ex.printStackTrace();
    }
    for(int i=0;i<99;++i)
     existBox[i] = true;
 }
 
 //繪製地圖
 public void Draw(Graphics g)
 {
  for(int i = 0;i < 102;i++)
  {
   g.drawImage(image1, tree_x[i],tree_y[i],50,50,null);
  }
  for(int i = 0;i < 99;i++)
  {
   if (existBox[i]) {
    g.drawImage(image2,box_x[i],box_y[i],50,50,null);
   }
  }
  Graphics2D g2 = (Graphics2D)g;
  g2.setColor(Color.GRAY);
  Line2D line1 = new Line2D.Double(0,0,0,750);
  Line2D line2 = new Line2D.Double(0,750,900,750);
  Line2D line3 = new Line2D.Double(900,0,900,750);
  Line2D line4 = new Line2D.Double(0,0,900,0);
  g2.draw(line1);
  g2.draw(line2);
  g2.draw(line3);
  g2.draw(line4);
 }
}
package game_window;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Player {

	private int position_x;
	private int position_y;
	static int num_of_waterball_of_P1 = 0;
	static int num_of_waterball_of_P2 = 0;
	File pathToFile;
	Image image;
	
	//�����l��
	public Player(int x, int y, String str)
	{
		this.position_x = x;
		this.position_y = y;
		
		//Ū������Ϥ�
		try {
			if(str.equals("player"))
			{
				pathToFile = new File("player.png");
			}
			else {
				pathToFile = new File("enemy.png");
			}
			image = ImageIO.read(pathToFile);
					
			}
		catch (IOException ex) {
			ex.printStackTrace();
		}
		
	}
	
	//ø�s����
	public void Draw(Graphics g)
	{		
		g.drawImage(image,position_x,position_y,50,50,null);
	}
	
	/*
	 * ���⪺��mŪ���B�ק�
	 */
	public int getPosition_x()
	{
		return position_x;
	}
	public void setPosition_x(int position_x)
	{
		this.position_x = position_x;
	}
	public int getPosition_y()
	{
		return position_y;
	}
	public void setPosition_y(int position_y)
	{
		this.position_y = position_y;
	}
	
}

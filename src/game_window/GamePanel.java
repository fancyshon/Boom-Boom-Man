package game_window;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GamePanel extends JPanel implements Runnable, KeyListener{

	private Player player;
	private Player enemy;
	private Map map;
	private Boom bombOfPlayer[];
	private Boom2 bombOfEnemy[];
	private Timer timer;
	private Explosion explosion;
	private Explosion2 explosion2;
	private boolean Game_over = false;
	private Item item;
	
	
	public GamePanel() {
		this.setBackground(Color.white);
		player = new Player(800,650,"player");
		enemy = new Player(50, 50, "enemy");
		map = new Map();
		timer = new Timer();
		item = new Item();
		bombOfPlayer = new Boom[3];
		bombOfEnemy = new Boom2[3];
		explosion = new Explosion();
		explosion2 = new Explosion2();
		for (int i = 0; i < 3; ++i) {
			bombOfPlayer[i] = new Boom();
			bombOfEnemy[i] = new Boom2();
		}

		ImageIcon exit = new ImageIcon("exit.png"); 
		JButton exitBtn = new JButton(exit);
		exitBtn.setSize(230,100);
		exitBtn.setLocation(907,642);
		Game_window listener = new Game_window();
		exitBtn.addActionListener(listener);
		
		ImageIcon smallgreen = new ImageIcon("smallgreen.jpg");
		JLabel smallgreenlabel = new JLabel(smallgreen);
		smallgreenlabel.setSize(230,70);
		smallgreenlabel.setLocation(907,142);
		
		JLabel smallgreenlabel2 = new JLabel(smallgreen);
		smallgreenlabel2.setSize(230,70);
		smallgreenlabel2.setLocation(907,222);
		
		ImageIcon blue = new ImageIcon("blueback.jpg");
		JLabel bluelabel = new JLabel(blue);
		bluelabel.setSize(250,750);
		bluelabel.setLocation(900,0);
			  
		ImageIcon enemy = new ImageIcon("enemy1.png");
		JLabel enemylabel = new JLabel(enemy);
		enemylabel.setSize(50,50);
		enemylabel.setLocation(915,152);
			  
		ImageIcon player = new ImageIcon("player1.png");
		JLabel playerlabel = new JLabel(player);
		playerlabel.setSize(50,50);
		playerlabel.setLocation(915,230);
		
		String getname1 = InputNameWindow.name1;
		String getname2 = InputNameWindow.name2;
		
		JLabel namelabel1 = new JLabel(getname1);
	    Font font4 = new Font(Font.DIALOG,Font.BOLD,30);
	    namelabel1.setFont(font4);
	    namelabel1.setForeground(Color.BLACK);
	    namelabel1.setSize(200,100);
	    namelabel1.setLocation(980,130);
	    
	    JLabel namelabel2 = new JLabel(getname2);
	    namelabel2.setFont(font4);
	    namelabel2.setForeground(Color.BLACK);
	    namelabel2.setSize(200,100);
	    namelabel2.setLocation(980,210);
		
	    this.add(namelabel2);
	    this.add(namelabel1);
		this.add(playerlabel);
		this.add(enemylabel);
		this.add(smallgreenlabel2);
		this.add(smallgreenlabel);
		this.add(bluelabel);
		this.setLayout(null);
	
	}
	
	//繪製畫面
	public void paint(Graphics g){
		super.paint(g);
		if(Boom.setBomb)
			bombOfPlayer[0].Draw(g);
		if(Boom2.setBomb)
			bombOfEnemy[0].Draw(g);
		player.Draw(g);
		enemy.Draw(g);
		map.Draw(g);
		item.Draw(g);
		if (Explosion.isExplo) {
			explosion.Draw(g);
		}
		if (Explosion2.isExplo) {
			explosion2.Draw(g);
		}
	}
	
	public void run() {
		while (!Game_over) {
			this.repaint();
			if (Explosion.isExplo || Explosion2.isExplo) {
				for (int i = 1; i <= Player.num_of_waterball_of_P1 + 1; i++) {

					if ((explosion.getX() + 50 != Map.tree_x[i] && explosion.getX() + 50 * i > player.getPosition_x())
							&& explosion.getY() == player.getPosition_y())
						Game_over = true;
					else if ((explosion.getX() - 50 != Map.tree_x[i]
							&& explosion.getX() - 50 * i > player.getPosition_x())
							&& explosion.getY() == player.getPosition_y())
						Game_over = true;
					else if (explosion.getX() == player.getPosition_x()
							&& (explosion.getY() + 50 * i > player.getPosition_y()
									&& explosion.getY() + 50 != Map.tree_y[i]))
						Game_over = true;
					else if (explosion.getX() == player.getPosition_x()
							&& (explosion.getY() - 50 * i > player.getPosition_y()
									&& explosion.getY() - 50 != Map.tree_y[i]))
						Game_over = true;

					if ((explosion2.getX() + 50 != Map.tree_x[i] && explosion2.getX() + 50 * i > player.getPosition_x())
							&& explosion2.getY() == player.getPosition_y())
						Game_over = true;
					if ((explosion2.getX() - 50 != Map.tree_x[i] && explosion2.getX() - 50 * i > player.getPosition_x())
							&& explosion2.getY() == player.getPosition_y())
						Game_over = true;
					if (explosion2.getX() == player.getPosition_x()
							&& (explosion2.getY() + 50 * i > player.getPosition_y()
									&& explosion2.getY() + 50 != Map.tree_y[i]))
						Game_over = true;
					if (explosion2.getX() == player.getPosition_x()
							&& (explosion2.getY() - 50 * i > player.getPosition_y()
									&& explosion2.getY() - 50 != Map.tree_y[i]))
						Game_over = true;

					if ((explosion.getX() + 50 != Map.tree_x[i] && explosion.getX() + 50 * i > enemy.getPosition_x())
							&& explosion.getY() == enemy.getPosition_y())
						Game_over = true;
					else if ((explosion.getX() - 50 != Map.tree_x[i]
							&& explosion.getX() - 50 * i > enemy.getPosition_x())
							&& explosion.getY() == enemy.getPosition_y())
						Game_over = true;
					else if (explosion.getX() == enemy.getPosition_x()
							&& (explosion.getY() + 50 * i > enemy.getPosition_y()
									&& explosion.getY() + 50 != Map.tree_y[i]))
						Game_over = true;
					else if (explosion.getX() == enemy.getPosition_x()
							&& (explosion.getY() - 50 * i > enemy.getPosition_y()
									&& explosion.getY() - 50 != Map.tree_y[i]))
						Game_over = true;

					if ((explosion2.getX() + 50 != Map.tree_x[i] && explosion2.getX() + 50 * i > enemy.getPosition_x())
							&& explosion2.getY() == enemy.getPosition_y())
						Game_over = true;
					if ((explosion2.getX() - 50 != Map.tree_x[i] && explosion2.getX() - 50 * i > enemy.getPosition_x())
							&& explosion2.getY() == enemy.getPosition_y())
						Game_over = true;
					if (explosion2.getX() == enemy.getPosition_x()
							&& (explosion2.getY() + 50 * i > enemy.getPosition_y()
									&& explosion2.getY() + 50 != Map.tree_y[i]))
						Game_over = true;
					if (explosion2.getX() == enemy.getPosition_x()
							&& (explosion2.getY() - 50 * i > enemy.getPosition_y()
									&& explosion2.getY() - 50 != Map.tree_y[i]))
						Game_over = true;

				}
			
			}

			
			for(int i=0;i<24;++i) {
			    int i_x = item.item_x[i],i_y = item.item_y[i];
			    if(item.existitem[i]==true && player.getPosition_x()<i_x+25 &&player.getPosition_x()>=i_x && player.getPosition_y()<=i_y+25 && player.getPosition_y()>=i_y && item.used[i]==false) {
			     item.existitem[i] = false;
			     item.used[i] = true;
			     Player.num_of_waterball_of_P1++;
			     this.repaint();
			     break;
			    }
			   }
			for(int i=0;i<24;++i) {
			    int i_x = item.item_x[i],i_y = item.item_y[i];
			    if(item.existitem[i]==true && enemy.getPosition_x()<i_x+25 &&enemy.getPosition_x()>=i_x && enemy.getPosition_y()<=i_y+25 && enemy.getPosition_y()>=i_y && item.used[i]==false) {
			     item.existitem[i] = false;
			     item.used[i] = true;
			     Player.num_of_waterball_of_P2++;
			     this.repaint();
			     break;
			    }
			   }
		}
		System.out.println("Game over!");
		Game_window over = new Game_window(Game_over);
		over.setVisible(true);
	}
	
	//Override
	public void keyTyped(KeyEvent e){}
	//Override
	public void keyReleased(KeyEvent e){}
	
	/* 角色移動
	 * Player藍寶: 方向鍵控制上下左右
	 * Enemy睏寶: WASD控制上下左右
	 */
	
	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			if(player.getPosition_y() >= 25)
			{
				if(Player_CanMove(player.getPosition_x(),player.getPosition_y()-25))
				{
					player.setPosition_y(player.getPosition_y() - 25);
				}
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			if(player.getPosition_y() < 700)
			{
				player.setPosition_y(player.getPosition_y() + 25);
				if(!Player_CanMove(player.getPosition_x(),player.getPosition_y()))
				{
					player.setPosition_y(player.getPosition_y() - 25);
				}
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			if(player.getPosition_x() >= 25)
			{
				player.setPosition_x(player.getPosition_x() - 25);
				if(!Player_CanMove(player.getPosition_x(),player.getPosition_y()))
				{
					player.setPosition_x(player.getPosition_x() + 25);
				}
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			if (player.getPosition_x() < 850) {
				player.setPosition_x(player.getPosition_x() + 25);
				if (!Player_CanMove(player.getPosition_x(), player.getPosition_y())) {
					player.setPosition_x(player.getPosition_x() - 25);
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (!Boom.setBomb&&!Explosion.isExplo) {
				bombOfPlayer[0].setX(player.getPosition_x());
				bombOfPlayer[0].setY(player.getPosition_y());
				explosion.setXY(player.getPosition_x(), player.getPosition_y());
				timer.schedule(new Boom(bombOfPlayer[0].getX(), bombOfPlayer[0].getY()), 2000);
				timer.schedule(new Explosion(), 3000);
			}
		}

		if(e.getKeyCode() == KeyEvent.VK_W)
		{
			if(enemy.getPosition_y() >= 25)
			{
				enemy.setPosition_y(enemy.getPosition_y() - 25);
				if(!Enemy_CanMove(enemy.getPosition_x(),enemy.getPosition_y()))
				{
					enemy.setPosition_y(enemy.getPosition_y() + 25);
				}
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_S)
		{
			if(enemy.getPosition_y() < 700)
			{
				enemy.setPosition_y(enemy.getPosition_y() + 25);
				if(!Enemy_CanMove(enemy.getPosition_x(),enemy.getPosition_y()))
				{
					enemy.setPosition_y(enemy.getPosition_y() - 25);
				}
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_A)
		{
			if(enemy.getPosition_x() >= 25)
			{
				enemy.setPosition_x(enemy.getPosition_x() - 25);
				if(!Enemy_CanMove(enemy.getPosition_x(),enemy.getPosition_y()))
				{
					enemy.setPosition_x(enemy.getPosition_x() + 25);
				}
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_D)
		{
			if (enemy.getPosition_x() < 850) {
				enemy.setPosition_x(enemy.getPosition_x() + 25);
				if (!Enemy_CanMove(enemy.getPosition_x(), enemy.getPosition_y())) {
					enemy.setPosition_x(enemy.getPosition_x() - 25);
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			if (!Boom2.setBomb&&!Explosion2.isExplo) {
				bombOfEnemy[0].setX(enemy.getPosition_x());
				bombOfEnemy[0].setY(enemy.getPosition_y());
				explosion2.setXY(enemy.getPosition_x(), enemy.getPosition_y());
				timer.schedule(new Boom2(bombOfEnemy[0].getX(), bombOfEnemy[0].getY()), 2000);
				timer.schedule(new Explosion2(), 3000);
			}
		}
	}
	
	//判斷player移動
	public Boolean Player_CanMove(int x, int y)
	{		
		for(int i = 0;i < 102;i++)
		{
			int Bx = map.tree_x[i];
			int By = map.tree_y[i];

			if((Bx + 50 > x) && (By + 50 > y) && (x + 50 > Bx) && (y + 50 > By))	//偵測player和地圖物件tree的碰撞
			{
				return false;
			}
		}
		for(int i = 0;i < 99;i++)
		{
			int Bx = map.box_x[i];
			int By = map.box_y[i];

			if((Bx + 50 > x) && (By + 50 > y) && (x + 50 > Bx) && (y + 50 > By))	//偵測player和地圖物件box的碰撞
			{
				if(Map.existBox[i] == true)
					return false;
				else
					return true;
			}
		}
		//偵測player和enemy的碰撞
		if((enemy.getPosition_x() + 50 > x) && (enemy.getPosition_y() + 50 > y) && (x + 50 > enemy.getPosition_x()) && (y + 50 > enemy.getPosition_y()))
		{
			return false;
		}
		return true;
	}
	
	//判斷enemy移動
	public Boolean Enemy_CanMove(int x, int y)
	{		
		for(int i = 0;i < 102;i++)
		{
			int Bx = map.tree_x[i];
			int By = map.tree_y[i];

			if((Bx + 50 > x) && (By + 50 > y) && (x + 50 > Bx) && (y + 50 > By))	//偵測player和地圖物件tree的碰撞
			{
				return false;
			}
		}
		for(int i = 0;i < 99;i++)
		{
			int Bx = map.box_x[i];
			int By = map.box_y[i];

			if((Bx + 50 > x) && (By + 50 > y) && (x + 50 > Bx) && (y + 50 > By))	//偵測player和地圖物件box的碰撞
			{
				if(Map.existBox[i] == true)
					return false;
				else
					return true;
			}
		}
		//偵測enemy和player的碰撞
		if((player.getPosition_x() + 50 > x) && (player.getPosition_y() + 50 > y) && (x + 50 > player.getPosition_x()) && (y + 50 > player.getPosition_y()))
		{
			return false;
		}
		return true;
	}
}

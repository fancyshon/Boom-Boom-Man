package game_window;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game_window extends JFrame implements ActionListener{
	
	protected static final int WIDTH = 1150;
	protected static final int HEIGHT = 785;
	
	
	public Game_window() {
		this.setSize(WIDTH, HEIGHT);
		this.setTitle("BoomMan");
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Game_window(boolean GG) {
		if (GG) {
			this.setSize(300, 150);
			this.setTitle("Game over!");
			this.setLocationRelativeTo(null);
			this.setLayout(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JButton okBtn = new JButton("OK");
			okBtn.setSize(80,40);
			okBtn.setLocation(this.getWidth() / 2 - okBtn.getWidth() / 2, 60);
			okBtn.addActionListener(this);
			this.add(okBtn);
		}
	}
	
	public void ShowGameWindow()
	{
		GamePanel gamePanel = new GamePanel();
		this.add(gamePanel);
		this.addKeyListener(gamePanel);
		Thread th = new Thread(gamePanel);
		th.start();
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		System.exit(0);
    }

}
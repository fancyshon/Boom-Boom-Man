package game_window;

import javax.imageio.ImageIO;
import java.applet.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menu extends JFrame implements ActionListener {

    public Menu() {
        this.setSize(750, 450);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("BoomMan");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JButton startBtn = new JButton("Play !");
        //JButton onlineMode = new JButton("Connect !");
        startBtn.setSize(150, 50);
        startBtn.setLocation(750 / 2 - startBtn.getWidth() / 2, 300);
        startBtn.addActionListener(this);
        
        Font font = new Font("細明本",Font.BOLD,40);
        startBtn.setFont(font);
        startBtn.setForeground(Color.BLACK);
        //onlineMode.setSize(150, 50);
        //onlineMode.setLocation(800 / 2 - onlineMode.getWidth() / 2, 375);

        ImageIcon BG = new ImageIcon("Start.jpg");
        JLabel label = new JLabel(BG);
        label.setSize(this.getWidth(), this.getHeight());

        this.add(startBtn);
        //this.add(onlineMode);
        this.add(label);
        //this.setBackground(Color.BLUE);
        this.setLayout(null);
    }
    
    public void actionPerformed(ActionEvent event) { 
     InputNameWindow window = new InputNameWindow();
     window.ShowInputNameWindow();
     this.dispose();
    }


    
}
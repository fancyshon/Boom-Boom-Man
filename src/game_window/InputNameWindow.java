package game_window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.imageio.ImageIO;
import java.applet.*;

public class InputNameWindow extends JFrame implements ActionListener{
 
 protected static final int WIDTH = 750;
 protected static final int HEIGHT = 450;
 JTextField inputname1;
 JTextField inputname2;
 static public String name1,name2;
 
 public InputNameWindow() {
  this.setSize(WIDTH, HEIGHT);
  this.setTitle("BoomMan");
  this.setResizable(false);
  this.setLocationRelativeTo(null);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
  ImageIcon background = new ImageIcon("InputName.jpg");
        JLabel backgroundlabel = new JLabel(background);
        backgroundlabel.setSize(this.getWidth(), this.getHeight());
        
        ImageIcon up = new ImageIcon("up.jpg");
        JLabel uplabel = new JLabel(up);
        uplabel.setSize(50,50);
        uplabel.setLocation(475, 300);
        
        ImageIcon down = new ImageIcon("down.jpg");
        JLabel downlabel = new JLabel(down);
        downlabel.setSize(50,50);
        downlabel.setLocation(475, 350);
        
        ImageIcon left = new ImageIcon("left.jpg");
        JLabel leftlabel = new JLabel(left);
        leftlabel.setSize(50,50);
        leftlabel.setLocation(425, 350);
        
        ImageIcon right = new ImageIcon("right.jpg");
        JLabel rightlabel = new JLabel(right);
        rightlabel.setSize(50,50);
        rightlabel.setLocation(525, 350);
        
        ImageIcon enter = new ImageIcon("enter.png");
        JLabel enterlabel = new JLabel(enter);
        enterlabel.setSize(100,70);
        enterlabel.setLocation(610, 328);
        
        
    
        ImageIcon A = new ImageIcon("A.jpg");
        JLabel alabel = new JLabel(A);
        alabel.setSize(50,50);
        alabel.setLocation(50,350);
        
        ImageIcon W = new ImageIcon("W.jpg");
        JLabel wlabel = new JLabel(W);
        wlabel.setSize(50,50);
        wlabel.setLocation(100,300);
        
        ImageIcon S = new ImageIcon("S.jpg");
        JLabel slabel = new JLabel(S);
        slabel.setSize(50,50);
        slabel.setLocation(100,350);
        
        ImageIcon D = new ImageIcon("D.jpg");
        JLabel dlabel = new JLabel(D);
        dlabel.setSize(50,50);
        dlabel.setLocation(150,350);
        
        ImageIcon space = new ImageIcon("space.jpg");
        JLabel spacelabel = new JLabel(space);
        spacelabel.setSize(140,40);
        spacelabel.setLocation(225,360);
        
        inputname1 = new JTextField(50);
        inputname1.setLocation(275,100);
        inputname1.setSize(200,50);
        //inputname1.setText("<Input your name>");
        Font font2 = new Font(Font.DIALOG,Font.PLAIN,20);
        inputname1.setFont(font2);
        inputname1.isEditable();
        inputname1.setEditable(true);
  
        
        
        inputname2 = new JTextField(50);
        inputname2.setLocation(275,175);
        inputname2.setSize(200,50);
       // inputname2.setText("<Input your name>");
        inputname2.setFont(font2);
        
        
        JLabel option = new JLabel("Setting");
        Font font = new Font(Font.DIALOG,Font.BOLD,30);
        option.setFont(font);
        option.setForeground(Color.BLACK);
        option.setSize(200,100);
        option.setLocation(330,10);
        
        JLabel p1 = new JLabel("1P");
        p1.setFont(font);
        p1.setForeground(Color.BLACK);
        p1.setSize(100,100);
        p1.setLocation(200,75);
        
        JLabel p2 = new JLabel("2P");
        p2.setFont(font);
        p2.setForeground(Color.BLACK);
        p2.setSize(100,100);
        p2.setLocation(200,150);
        
        JButton start = new JButton("Start");
        start.setSize(100,75);
        start.setLocation(495,125);
        start.addActionListener(this);
        Font font1 = new Font(Font.DIALOG,Font.BOLD,27);
        start.setFont(font1);
        start.setForeground(Color.BLACK);
        
      
        this.add(p2);
        this.add(p1);
        this.add(rightlabel);
        this.add(leftlabel);
        this.add(downlabel);
        this.add(enterlabel);
        this.add(spacelabel);
        this.add(dlabel);
        this.add(slabel);
        this.add(wlabel);
        this.add(alabel);
        this.add(start);
        this.add(option);
        this.add(inputname1);
        this.add(inputname2);
        this.add(uplabel);
        this.add(backgroundlabel);
       
  
 }
 
 public void actionPerformed(ActionEvent e) {
	 	name1 = inputname1.getText();
	 	name2 = inputname2.getText(); 	

        Game_window game = new Game_window();
        game.ShowGameWindow();
        this.dispose();
    }   
 
 public void ShowInputNameWindow(){
  
  this.setVisible(true);
 }
}
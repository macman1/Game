package me.letsbuild.testgame;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import javax.swing.ImageIcon;

import javax.swing.JFrame;

public class Images extends JFrame {
	public static void main(String[] args){
		DisplayMode dm =new DisplayMode(800,600,16, DisplayMode.REFRESH_RATE_UNKNOWN);
		Images i = new Images();
		i.run(dm);
		
	}
	
	private Screen s;
	private Image bg;
	private Image pic;
	private boolean loaded;
	
	public void run(DisplayMode dm){
		setBackground(Color.BLUE);
		setForeground(Color.WHITE);
		setFont(new Font("Arial", Font.PLAIN, 24));
		loaded = false;
				
		s = new Screen();
		try{
		s.setFullScreen(dm, this);
		loadpics();
		try{
			Thread.sleep(5000);
		}catch(Exception ex){}
		}finally{
			s.restoreScreen();
		}
	}
	
	public void loadpics(){
		bg = new ImageIcon("D:\\test\\test.png").getImage();
		pic = new ImageIcon("D:\\test\\face.png").getImage();
		loaded = true;
		repaint();
	}
	
	public void paint(Graphics g){
		if(g instanceof Graphics2D){
			Graphics2D g2 =(Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		}
		if(loaded){
			g.drawImage(bg,0,0,null);
			g.drawImage(pic,170,180,null);
		}
	}
}

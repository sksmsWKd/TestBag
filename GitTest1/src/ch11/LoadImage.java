package ch11;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.*;
import java.awt.*;

public class LoadImage extends JPanel{
	 BufferedImage img;
	
	public LoadImage() {
		try {
			img = ImageIO.read(new File("galaxy.jpg"));
		}catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println("이미지를읽을수없어 프로그램을종료합니다.");
			System.exit(1);
		}
		
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img , 0 , 0 ,null);
	}
	public static void main(String[]args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LoadImage panel = new LoadImage();
		frame.add(panel);
		frame.setSize(panel.img.getWidth(),panel.img.getHeight());
		frame.setVisible(true);
	}
}

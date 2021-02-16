package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;

public class CarGame extends JFrame{
	private JLabel imgLabel;
	
	private CarGame() {
		
		this.setSize(300,300);
		imgLabel = new JLabel();
		
		ImageIcon imageIcon = new ImageIcon("car.jpg");
		imgLabel.setIcon(imageIcon);
		
		this.add(imgLabel);
		
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
	public static void main(String[]args) {
//		JFrame CarGame = new JFrame();
		new CarGame();
	}
}

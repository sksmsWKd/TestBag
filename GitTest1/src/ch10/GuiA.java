package ch10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GuiA extends JFrame{

	public GuiA(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton btn = new JButton("せせぉここ");
		
		frame.add(panel);
		frame.setSize(300,300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.add(btn);
		
		
	}
	
	public static void main (String[]args) {
		new GuiA();
	}
}

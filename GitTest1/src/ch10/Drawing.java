package ch10;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Drawing extends JFrame implements MouseListener{
	
	public JPanel panel;

	
	public Drawing(){
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addMouseListener(this);
		JPanel panel = new JPanel();
		this.add(panel);
		JButton bt1 = new JButton("예아");
		panel.add(bt1);
		
		
	}
	
	

	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		g.drawRect(5, 5, 50, 50);
	}

@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("눌렀어요!");
		
		repaint();
	}




	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}




public static void main(String[]args) {
	Drawing d = new Drawing();
}
}

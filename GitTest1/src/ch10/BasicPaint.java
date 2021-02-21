package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BasicPaint {
	
	public static void main(String[]args) {
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(new MyDrawingPanel());
	frame.setSize(300,200);
	frame.setVisible(true);
	
	}
	
}

class MyDrawingPanel extends JPanel{
	private int squareX = 50;
	private int squareY = 50;
	private int squareW = 20;
	private int squareH = 20;
	
	public MyDrawingPanel() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				drawSquare(e.getX(), e.getY());
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				drawSquare(e.getX(),e.getY());
			}
		
			
		});
	
	}
	
	private void drawSquare(int x, int y) {
squareX =x;
squareY =y; 
		repaint();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString("마우스를클릭하면 사각형ㅇ???", 10, 20);
		g.setColor(Color.red);
		g.fillRect(squareX, squareY, squareW, squareH);
		g.setColor(Color.black);
		g.drawRect(squareX, squareY, squareW, squareH);
	}
}

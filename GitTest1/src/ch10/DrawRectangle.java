package ch10;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DrawRectangle  extends JFrame{
	public DrawRectangle() {
	
	this.setSize(300,300);
	this.setTitle("마우스로그리기");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(new MyPanel());
	this.setVisible(true);

}



class Rectangle{
int x,y,w,h;
	public Rectangle(int x, int y, int w , int h) {
		
		this.x=x;
		this.y=y;
		this.w=w;
		this.h=h;
	}
}

class MyPanel extends JPanel implements MouseListener{
	Rectangle[] rectangles = new Rectangle[100];
	
	
	int index = 0;

 void rectangles(){
		
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
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (Rectangle r: rectangles) {
			if (r == null )break;
			g.drawRect(r.x, r.y, r.w, r.h);
		}
	}
	
	
	

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("zz");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(index >= rectangles.length) return;
		rectangles[index] = new Rectangle(e.getX(), e.getY(), 50 ,50);
		
		rectangles[index].x = e.getX();
		rectangles[index].y = e.getY();
		rectangles[index].w= 50;
		rectangles[index].h= 50;
		
		index++;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	public MyPanel() {
		this.addMouseListener(this);
	}
	
}




public static void main(String[]args) {
	DrawRectangle s =new DrawRectangle();
	
}
}

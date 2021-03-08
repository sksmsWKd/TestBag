package ch11;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DrawingFace extends JFrame{
public DrawingFace() {
	this.setSize(200,300);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.add(new DrawingFacePanel());


}


public static void main(String[]args) {
	new DrawingFace();
}

}
class DrawingFacePanel extends JPanel{
	@Override
	public void paintComponent(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval(20, 30, 150, 150);
		g.setColor(Color.black);
		g.drawArc(50, 70, 30, 30, 180, -180);
		
		g.setColor(Color.black);
		g.drawArc(110, 70, 30, 30, 180, -180);
		
		g.setColor(Color.black);
		g.drawArc(60, 90, 70, 70, -180, 180);
	}
}
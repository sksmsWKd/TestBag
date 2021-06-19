package ch11;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class gradientPanel extends MyPanel {
@Override
public void paintComponent(Graphics g) {
	Graphics2D g2 = (Graphics2D)g;
	g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	
	GradientPaint gp= new GradientPaint(0,20,Color.white,0,70,Color.red);
	for(Shape s:shapeArray){
		//g2.setPaint(Color.red);
		g2.setPaint(gp);
		g2.fill(s);
		}
}
public static void main(String[]args) {
	JFrame frame = new JFrame();
	frame.setSize(600,200);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(new gradientPanel());
	frame.setVisible(true);
	
}
}

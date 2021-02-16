package ch10;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;




public class TrafficLight extends JFrame{

	
	public TrafficLight() {
		this.add(new MyPanel());
		this.setSize(300 ,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
		
			}
		public static void main(String[]args) {
		JFrame frame = new TrafficLight();
			
		}
	
}


class MyPanel extends JPanel implements ActionListener {
	private int lightNumber =-1;
	JButton button1 = new JButton("빨강");
	JButton button2 = new JButton("초록");
	JButton button3 = new JButton("노랑");
	public MyPanel() {
		this.setLayout(new BorderLayout());
		JButton b = new JButton("traffic light turn on");
		
		
		b.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		this.add(b,BorderLayout.SOUTH);
		this.add(button1,BorderLayout.WEST);
		this.add(button2,BorderLayout.EAST);
		this.add(button3,BorderLayout.NORTH);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
	System.out.println("paintcomponent");
	g.setColor(Color.black);
	g.drawOval(100, 100, 100, 100);
	g.drawOval(100, 200, 100, 100); 
	g.drawOval(100, 300, 100, 100); 
	if(lightNumber ==0) {
		//빨간신호등 그리기  
		g.setColor(Color.red);
		g.fillOval(100, 100, 100, 100);
		
	}else if (lightNumber ==1) {
		//초록
		g.setColor(Color.green);
		g.fillOval(100, 200, 100, 100);
	}else {
		//노란
		g.setColor(Color.yellow);
		g.fillOval(100, 300, 100, 100);
	}
	
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(++lightNumber >=3 )lightNumber=0;
		
		this.repaint();
		
		if(e.getSource()==button1) {
			this.setColor1(Color.red);
			
		}
		else if(e.getSource()==button2) {
			this.setColor2(Color.green);
		}
		else if(e.getSource()==button3) {
			this.setColor3(Color.yellow);
		}
		
	}
	

	public void actionPerformed1(ActionEvent c) {
	
	
	
}
	private void setColor1(Color red) {
		// TODO Auto-generated method stub
		
	}
	private void setColor2(Color green) {
		// TODO Auto-generated method stub
		
	}
	private void setColor3(Color yellow) {
		// TODO Auto-generated method stub
		
	}
}


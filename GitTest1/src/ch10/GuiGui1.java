package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiGui1 extends JFrame{
public GuiGui1(){
	JPanel panel= new JPanel();
	JPanel panel2= new JPanel();
	JButton btn1 = new JButton("��");
	JButton btn2 = new JButton("��");
	JButton btn3 = new JButton("��");
	JButton btn4 = new JButton("��");
	JButton btn5 = new JButton("�߾�");
	JButton btn6 = new JButton("�ٴ�");
	
	
	this.add(panel2);
	panel.setLayout(new BorderLayout());
	panel2.setLayout(new BorderLayout());
	
	
	
	panel2.add(btn6,BorderLayout.SOUTH);
	this.add(panel2,BorderLayout.SOUTH);

	panel.add(btn1,BorderLayout.EAST);
	panel.add(btn2,BorderLayout.WEST);
	panel.add(btn3,BorderLayout.SOUTH);
	panel.add(btn4,BorderLayout.NORTH);
	panel.add(btn5,BorderLayout.CENTER);
	this.add(panel);
	
	this.setSize(700,350);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.setTitle("�̰����������Դϴ�.");
	
	
	
}


public static void main (String[]args) {
	new GuiGui1();
}
}  
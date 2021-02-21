package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiGui1 extends JFrame{
public GuiGui1(){
	JPanel panel= new JPanel();
	JPanel panel2= new JPanel();
	JButton btn1 = new JButton("동");
	JButton btn2 = new JButton("서");
	JButton btn3 = new JButton("남");
	JButton btn4 = new JButton("북");
	JButton btn5 = new JButton("중앙");
	JButton btn6 = new JButton("바닥");
	
	
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
	this.setTitle("이것은프레임입니다.");
	
	
	
}


public static void main (String[]args) {
	new GuiGui1();
}
}  
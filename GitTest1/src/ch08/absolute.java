package ch08;
import javax.swing.*;
import java.awt.*;

public class absolute extends JFrame {
public absolute() {
	this.setTitle("absolute");
	this.setSize(400,200);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
	JButton b1= new JButton("button 1");
	JButton b2= new JButton("button 2");
	Object b3= new JButton("button 3");
	

	
	b1.setBounds(150, 50, 100, 100);
	b2.setBounds(0, 100 ,100, 100);
	b3.setBounds(300, 100, 100, 100);
	
	this.add(b1);
	this.add(b2);
	this.add(b3);
	
	this.setLayout(null);//���̾ƿ� �Ŵ��� ��
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
}
public static void main(String[]args) {
	JFrame frame = new absolute();
}
}

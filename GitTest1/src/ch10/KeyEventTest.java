package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class KeyEventTest extends JFrame implements KeyListener{

	private JPanel panel;
	private JTextField field;
	private JTextArea area;
	public KeyEventTest() {
		panel = new JPanel(new GridLayout(0,2));
		panel.add(new JLabel("¹®ÀÚÀÔ·ÂÇÏ¼¼¿ä"));
		
		field = new JTextField(10);
		field.addKeyListener(this);
		panel.add(field);
		
		area = new JTextArea(3,30);
		
		this.add(panel, BorderLayout.NORTH);
		this.add(area, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(400,200);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Å°´­¸²");
		display(e, "´­·È½¿!");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("³õ¾ÆÁü");
		display(e, " ³õ¾Æ º½¿!");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Å°Å¸ÀÌÇÎµÊ");
		
		display(e, "ÆÄÀÌÇÎ‰ç½¿!");
		
	
	}
	private void display(KeyEvent e, String s) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar();
		int keyCode = e.getKeyCode();
		
		System.out.println(s + " "+ c +" " + keyCode);
		area.append(s + " "+ c +" " + keyCode);
		area.append("\n");
		
		
	}
	public static void main(String[]args) {
		JFrame frame1 =new KeyEventTest();
	}
}

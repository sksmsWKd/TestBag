package ch08;

import java.awt.*;
import javax.swing.*;


public class MyFrame extends JFrame{
public MyFrame() {
//	this.setSize(400,500);
//	this.setTitle("����");
//	
////	JButton button = new JButton("��ư");
////	this.add(button);
//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	this.setVisible(true);
//	this.setLayout(new FlowLayout());
//	
//	
//	JLabel label = new JLabel("�ȳ��ϼ���?");
//	JTextField text = new JTextField(20);
}

public static void main(String[] args) {
	MyFrame frame = new MyFrame();
	JPanel panel = new JPanel();
	frame.add(panel);
	
	JLabel label1 = new JLabel("ȭ�� �µ�");
	JLabel label2 = new JLabel("���� �µ�");
	JTextField field1 = new JTextField(20);
	JTextField field2 = new JTextField(20);
	JButton button = new JButton("��ȯ");
	
	panel.add(label1);
	
	
	panel.add(field1);
	
	panel.add(label2);
	
	panel.add(field2);
	panel.add(button);
	frame.setSize(400,500);
	frame.setTitle("����");
	
//	JButton button = new JButton("��ư");
//	this.add(button);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
//	frame.setLayout(new FlowLayout());
//	
}
	
}

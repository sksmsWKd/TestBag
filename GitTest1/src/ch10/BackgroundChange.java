package ch10;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BackgroundChange extends JFrame implements ActionListener{
	private JButton button1;
	private JButton button2;
	private JPanel panel;
	
	
	public BackgroundChange() {
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�̺�Ʈ ����");
	
		
		button1= new JButton("�����");
		button1.addActionListener(this);
		button2= new JButton("��ũ��");
		button2.addActionListener(this);

		
		panel = new JPanel();
		
		panel.add(button1);
		panel.add(button2);
		
		this.setVisible(true);
		
		this.add(panel, BorderLayout.NORTH);
		
		
	}
	public static void main(String[] args) {
		JFrame frame = new BackgroundChange();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== button1) {
			this.setBackground(Color.YELLOW);
		}else if (e.getSource() == button2) {
			this.setBackground(Color.RED);
		}
	}
	
	
}



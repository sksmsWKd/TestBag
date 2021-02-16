package ch10;

import javax.swing.*;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.*;
public class KeyPad extends JFrame implements ActionListener {
	private JTextField textfield;
	private JPanel panel;
	
	
	public KeyPad() {
		textfield = new JTextField(20);
		this.add(textfield, BorderLayout.NORTH);
		panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		
		this.add(panel, BorderLayout.CENTER);
		
		for( int i =1 ; i <=9 ; i++) {
			JButton button = new JButton(String.valueOf(i));
			button.setPreferredSize(new Dimension(100,100));
			panel.add(button);
			button.addActionListener((ActionListener) this);
		}
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		textfield.setText(textfield.getText()+ actionCommand);
	}
	
	public static void main(String[]args) {
//		JFrame keyPad = new JFrame();
		new KeyPad();
	}
	}


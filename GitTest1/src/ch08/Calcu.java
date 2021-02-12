package ch08;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calcu extends JFrame{
private JTextField textfield;
private JPanel panel;
private JButton[] numButton;
private JButton addButton, subButton, mulButton, divButton,
decButton, equButton, delButton, clearButton, negButton;
private Font myFont= new Font(Font.SANS_SERIF, Font.BOLD, 30);

public Calcu(){
	this.setTitle("CalCulator");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(420,550);
	this.setLayout(null);
	
	textfield = new JTextField();
	textfield.setBounds(50, 25, 300, 50);
	textfield.setEditable(true);
	textfield.setFont(myFont);
	
	panel = new JPanel();
	panel.setBounds(50 , 100 ,300 ,300);
	panel.setLayout(new GridLayout(4,4,10,10));
	
	numButton = new JButton[10];
	for(int i = 0 ; i  < numButton.length; i++){
		numButton[i] = new JButton(String.valueOf(i));
		numButton[i].setFont(myFont);
		numButton[i].setFocusable(false);
	}
	

	addButton = new JButton("+"); addButton.setFocusable(false);
	subButton = new JButton("-"); subButton.setFocusable(false);
	mulButton = new JButton("*"); mulButton.setFocusable(false);
	divButton = new JButton("/"); divButton.setFocusable(false);
	decButton = new JButton("."); decButton.setFocusable(false);
	equButton = new JButton("="); equButton.setFocusable(false);
	delButton = new JButton("delete"); delButton.setFocusable(false);
	clearButton = new JButton("clear"); clearButton.setFocusable(false);
	negButton = new JButton("(-)"); negButton.setFocusable(false);
	delButton = new JButton("del");
	delButton.setBounds(150, 430, 100 ,50);
	clearButton = new JButton("clear");
	clearButton.setBounds(250, 430,100 ,50);
	negButton = new JButton("(-)");
	negButton.setBounds(50, 430,100 ,50);
	
	
	panel.add(numButton[1]);
	panel.add(numButton[2]);
	panel.add(numButton[3]);
	panel.add(addButton);
	
	panel.add(numButton[4]);
	panel.add(numButton[5]);
	panel.add(numButton[6]);
	panel.add(subButton);
	
	panel.add(numButton[7]);
	panel.add(numButton[8]);
	panel.add(numButton[9]);
	panel.add(mulButton);
	
	panel.add(decButton);
	panel.add(numButton[0]);
	panel.add(equButton);
	panel.add(divButton);
	
	
	
	this.add(panel);
	this.add(textfield);
	this.setLocationRelativeTo(null); //frame 이 화면 중앙에 나타남
	this.setVisible(true);
	this.add(negButton);
	this.add(clearButton);
	this.add(delButton);
	
	
}

public static void main(String[]args) {
	JFrame Calcu = new Calcu();
}
}


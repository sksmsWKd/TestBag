package ch08;
import javax.swing.*;
import java.awt.*;


public class FlowLayOut extends JFrame{

	
	public FlowLayOut(){
	JButton button1  = new JButton("Button1");
	JButton button2  = new JButton("Button2");
	JButton button3  = new JButton("Button3");
	JButton button4  = new JButton("Long Named Button4");
	JButton button5  = new JButton("5");
	
	this.add(button1, BorderLayout.NORTH); //public static final string=north
	this.add(button2, BorderLayout.CENTER);
	this.add(button3, BorderLayout.WEST);
	this.add(button4, BorderLayout.SOUTH);
	this.add(button5, BorderLayout.EAST);
	
	this.setVisible(true);
//	this.setLayout(new FlowLayout());//명시적으로 지정안하면 borderlayout 이 default
	this.setSize(400,300);   
	this.setResizable(true); //크기줄여도 사이즈안바뀜
//	this.pack(); //알아서 사이즈 딱맞게
	} 
	public static void main (String[]args) {
	FlowLayOut frame = new FlowLayOut();
	
}

}

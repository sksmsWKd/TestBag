package ch10;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class MyCounter extends JFrame implements ActionListener{

	
	private JLabel label1, label2;
	private JPanel panel;
	private JButton bt1;
	private JButton bt2;
	private JButton bt3;
	private int count = 0;
	
	public MyCounter() {
		
		
		
		
		
		panel = new JPanel();
		 label1 = new JLabel("COUNTER");
		panel.add(label1);
		
		
		 label2 = new JLabel(count+ "번");
		
		label2.setFont(new Font("Serif" , Font.BOLD| Font.ITALIC, 60 ));
		label2.setForeground(Color.blue);
		panel.add(label2);
		
		bt1 = new JButton("증가하는 버튼");
		bt1.addActionListener(this);
		panel.add(bt1);
		
		
		bt2 = new JButton("감소하는 버튼");
		bt2.addActionListener(this);
		panel.add(bt2);
	
		
		bt3 = new JButton("초기화 버튼");
		bt3.addActionListener(this);
		panel.add(bt3);
		
		
	
		
		
		
		
		this.add(panel);
		this.setTitle("MyCounter");
		this.setSize(1000,400);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.setLayout(null);
		
		
		bt1.setLocation(350,210);
		bt2.setLocation(420,230);
		bt3.setLocation(550,250);
		label1.setLocation(50,150);
		label2.setLocation(140,100);
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == bt1) {
			count++;
			label2.setText(count+ "번");		
		}
		else if(e.getSource() == bt2) {
			count--;
			label2.setText(count+ "번");
			if(count ==-1 && e.getSource() == bt2) {
				count ++;
				label2.setText(count+ "번");
				JOptionPane.showMessageDialog(null, "0이하로 감소할수 없습니다.");

			
			}else {
				
			}
		}
		else{
			count = 0;
			label2.setText(count+ "번");
		}
				
	}

}

public class Counter{
	public static void main(String[]args) {
		new MyCounter();
	}
}




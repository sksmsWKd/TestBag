package ch11;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class quadraticFunctionDraw extends JPanel implements ActionListener{
	JTextField aField;
	JTextField bField;
	JTextField cField;
	private JFrame f;
	public JButton btn1;
	 Double A = -1.0;
	 Double B = -5.0;
	 Double C = 3.0;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		A = Double.parseDouble(aField.getText()); // a�ʵ忡�� ���� ���� ����� ��ȯ -> x^2�� ���
		B = Double.parseDouble(bField.getText()); // b�ʵ忡�� ���� ���� ����� ��ȯ -> x�� ���
		C = Double.parseDouble(cField.getText()); // c�ʵ忡�� ���� ���� ����� ��ȯ -> ���
		f.repaint();	
		if (e.getSource()==btn1) {
			f.repaint();
		}
	}
	
	
	public void paintComponent(Graphics g) {
		//super.paintComponents(g);
		
		Graphics2D g2 = (Graphics2D) g;
		
		
		g2.drawLine(250 ,0, 250, 500);
		g2.drawLine(0, 250, 500, 250);
		g2.setColor(Color.black);  //Graphics2D �� ��ȯ�Ͽ� ���� ����.
		
		for (int i = -20; i<20; i++) {
			int x =i;                          // x��ǥ
			int y = (int) (A* x * x -B * x +C); //   y��ǥ
			g2.fillOval(250 + x - 2, 250 - (y - 2), 4, 4); //  ���μ��� 4��ŭ�� ���� x�� �ٲ𶧸��� y �� ���� �ٲ���Ͽ� x�� y��ǥ�� �ٲ�
		}
		f.repaint();
	}
	
	
	
	
	
	public quadraticFunctionDraw() {
		
		 aField = new JTextField("-1",10);
		 bField = new JTextField("-5",10);
		 cField = new JTextField("3",10);
		JButton btn1= new JButton("�׸���");
		
		
		this.add(aField);
		this.add(bField);
		this.add(cField);
		this.add(btn1);
		btn1.addActionListener(this);
				
		 f = new JFrame();
		f.add(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.setVisible(true);
	}
	
	

public static void main(String []args) {
	
	new quadraticFunctionDraw();
}
}


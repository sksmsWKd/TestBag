package ch10;
import javax.swing.*;
public class MyFrame1 extends JFrame{

	
	private JButton button;
	private JLabel label;
	
	public MyFrame1() {
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("�̺�Ʈ����");
		
		JPanel panel= new JPanel();
		
		button = new JButton("��ư�� ��������");
		button.addActionListener(new MyListener1());
		label = new JLabel("���� ��ư�� �������� �ʾҽ�����");
		
		panel.add(button);
		panel.add(label);
		
		this.add(panel);
		this.setVisible(true);
		
	}
}

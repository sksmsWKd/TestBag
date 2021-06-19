package ch11;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class JSliderExample extends JFrame implements ChangeListener,ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==imgBtn) {
			
			imgBtn.setSize(INT_VALUE*10, INT_VALUE*10);
		}
	}

	static final int INT_VALUE =30;
	private JSlider slider;
	private JButton imgBtn;
	private JLabel label;
	
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider) e.getSource();
		if(!source.getValueIsAdjusting()) {// getValueIsAdjusting �Լ��� � �̺�Ʈ �ν��Ͻ����� ���������� �̺�Ʈ�� �Ͼ� ���� ��, 
			//�ش� �̺�Ʈ �ν��Ͻ����� ������ ������ ü������ ���� ü���� ������ �ν��Ͻ� �ܿ��� ȣ���ϴ� ��� true�� ��ȯ�ϴ� �Լ��̴�.
			
			
		int value = (int) slider.getValue();
		imgBtn.setSize(value*10, value*10);// �����̴��� ���°� ����Ǹ� ȣ���
		}
	}
	public JSliderExample(){
		JPanel panel;
		panel = new JPanel();
		this.add(panel);
		
		slider = new JSlider(0,30,INT_VALUE);
		slider.setMajorTickSpacing(10);  //ū���� ����
		slider.setMinorTickSpacing(1); //�������� ����
		slider.setPaintTicks(true); //���� ǥ���Ѵ�. �̰� ���ϸ� ���� �ȳ���
		slider.setPaintLabels(true); //���� ���̺�� ǥ����. �Ƹ� ū���� �����ΰŰ���
		slider.addChangeListener(this);
		
		imgBtn = new JButton();
		ImageIcon icon = new ImageIcon("dog.jpg");
		imgBtn.setIcon(icon);
		imgBtn.setSize(INT_VALUE*10, INT_VALUE*10);
		imgBtn.addActionListener(this);
		
		label = new JLabel("�̹����� ������ ����� ������� ���ƿ���, �����̵� ������ �̹���ũ�⺯��");
		
		panel.add(label);
		panel.add(slider);
		panel.add(imgBtn);
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);
	}
	
	public static void main(String[]args) {
		new JSliderExample();
	}
}

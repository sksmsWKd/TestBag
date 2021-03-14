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
		if(!source.getValueIsAdjusting()) {// getValueIsAdjusting 변경점 감지해서 덧씌우기같은느낌
			
			
		int value = (int) slider.getValue();
		imgBtn.setSize(value*10, value*10);// 사이즈 조절
		}
	}
	public JSliderExample(){
		JPanel panel;
		panel = new JPanel();
		this.add(panel);
		
		slider = new JSlider(0,30,INT_VALUE);
		slider.setMajorTickSpacing(10);  //큰눈금 간격
		slider.setMinorTickSpacing(1); //작은눈금간격
		slider.setPaintTicks(true); //눈금표시
		slider.setPaintLabels(true); //값을 레이블로 표시 - > 슬라이더아래 숫자
		slider.addChangeListener(this);
		
		imgBtn = new JButton();
		ImageIcon icon = new ImageIcon("dog.jpg");
		imgBtn.setIcon(icon);
		imgBtn.setSize(INT_VALUE*10, INT_VALUE*10);
		imgBtn.addActionListener(this);
		
		label = new JLabel("이미지 누르면 원래사이즈로 바꿔줍니다.");
		
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

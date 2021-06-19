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
		if(!source.getValueIsAdjusting()) {// getValueIsAdjusting 함수는 어떤 이벤트 인스턴스에서 연속적으로 이벤트가 일어 났을 때, 
			//해당 이벤트 인스턴스들을 일종의 데이터 체인으로 보고 체인의 마지막 인스턴스 외에서 호출하는 경우 true를 반환하는 함수이다.
			
			
		int value = (int) slider.getValue();
		imgBtn.setSize(value*10, value*10);// 슬라이더의 상태가 변경되면 호출됨
		}
	}
	public JSliderExample(){
		JPanel panel;
		panel = new JPanel();
		this.add(panel);
		
		slider = new JSlider(0,30,INT_VALUE);
		slider.setMajorTickSpacing(10);  //큰눈금 간격
		slider.setMinorTickSpacing(1); //작은눈금 간격
		slider.setPaintTicks(true); //눈금 표시한다. 이거 안하면 눈금 안나옴
		slider.setPaintLabels(true); //값을 레이블로 표시함. 아마 큰눈금 기준인거같다
		slider.addChangeListener(this);
		
		imgBtn = new JButton();
		ImageIcon icon = new ImageIcon("dog.jpg");
		imgBtn.setIcon(icon);
		imgBtn.setSize(INT_VALUE*10, INT_VALUE*10);
		imgBtn.addActionListener(this);
		
		label = new JLabel("이미지를 누르면 사이즈가 원래대로 돌아오고, 슬라이드 조정시 이미지크기변경");
		
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

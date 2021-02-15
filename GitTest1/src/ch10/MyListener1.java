package ch10;
import java.awt.event.*;

import javax.swing.JButton;
public class MyListener1 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource(); //이`벤트 발생한 객체가 object타입으로 봔환
		button.setText("버튼이 눌러졌습니다");
	}
}

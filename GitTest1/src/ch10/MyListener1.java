package ch10;
import java.awt.event.*;

import javax.swing.JButton;
public class MyListener1 implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton)e.getSource(); //��`��Ʈ �߻��� ��ü�� objectŸ������ ��ȯ
		button.setText("��ư�� ���������ϴ�");
	}
}

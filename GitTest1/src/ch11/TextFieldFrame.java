package ch11;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
public class TextFieldFrame extends JFrame implements ActionListener{

	JButton btn,btn2;
	JTextField input,result;
	Double A,B;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btn) {
			 A = Double.parseDouble(input.getText());
			 result.setText(""+ A*A); // "" �� ���ڿ� �ȳ����� ���ڸ� �ֱ� �Ұ���.
			 							//���࿡ double ���� int ������ ����Ϸ���
			 							//Integer.ParseInt(); �� ����. ->���ڿ��� int������ �ٲ���.
		}
		if(e.getSource()==btn2) {
			input.setText("");
			result.setText("");
		}
	}
	public TextFieldFrame(){
		
		
		JPanel panel = new JPanel();
	
		panel.add(new JLabel("�Է°��� �Է��ϼ���:"));
		input = new JTextField(15);
		panel.add(input);
		panel.add(new JLabel("�Է°��� ������ ����:"));
		result = new JTextField(15);
		result.setEditable(false);
		panel.add(result);
		
		btn = new JButton("���");
		btn2 = new JButton("�ʱ�ȭ");
		btn.addActionListener(this);
		btn2.addActionListener(this);
		panel.add(btn);
		panel.add(btn2);
		
		add(panel);
		this.setSize(250,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public static void main(String[]args) {
		new TextFieldFrame();
	}
}

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
			 result.setText(""+ A*A); // "" 빈 문자열 안넣으면 숫자만 넣기 불가능.
			 							//만약에 double 말고 int 형으로 출력하려면
			 							//Integer.ParseInt(); 로 하자. ->문자열을 int형으로 바꿔줌.
		}
		if(e.getSource()==btn2) {
			input.setText("");
			result.setText("");
		}
	}
	public TextFieldFrame(){
		
		
		JPanel panel = new JPanel();
	
		panel.add(new JLabel("입력값을 입력하세요:"));
		input = new JTextField(15);
		panel.add(input);
		panel.add(new JLabel("입력값을 제곱한 값은:"));
		result = new JTextField(15);
		result.setEditable(false);
		panel.add(result);
		
		btn = new JButton("계산");
		btn2 = new JButton("초기화");
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

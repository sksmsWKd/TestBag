package ch11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextConverter extends JFrame implements ActionListener{

	private JButton convertBtn;
	private JButton cancelBtn;
	private JTextArea textIn;
	private JTextArea textOut;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 변환 버튼이 클릭되었다면 좌측 텍스트에리어의 텍스트를 읽어서 영어로 ㅂ꾸고, 그 변환된결과를 오른쪽에..
		//취소누르면 왼쪽을 빈칸으로
		if (e.getSource()==convertBtn) {
			String str = textIn.getText();
			String convertResult=toEnglish(str);
			textOut.setText(convertResult);
		}else if(e.getSource()==cancelBtn) {
			textIn.setText("");
			textOut.setText("");
		}
		
	}
	
	private String toEnglish(String korean) {
		//korean 문자열을 영어로 변환해서 반환..
		//텍스트 -text
		//영어 -english
		
		String result = null;
		result = korean.replace("텍스트", "text");
		result =result.replace("영어", "english");
		return result; // 항상 메소드를 쓸떄 주의할점은 원본이 바뀌늦지? 아님 카피본을 리턴해주는지?
		
		
		//String [] result2 = new String[4] ;
		
		 //String[] result2 = {"가","나","다,","라","마"};
	}
	
	public TextConverter() {
		this.setTitle("텍스트변환");
		textIn = new JTextArea(10,14);
		textOut = new JTextArea(10,14);
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1,2,20,20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		convertBtn = new JButton("변환");
		cancelBtn = new JButton("취소");
		convertBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(convertBtn);
		btnPanel.add(cancelBtn);
		
		JPanel mainPanel = new JPanel (new BorderLayout(10,10));
		mainPanel.add(textAreaPanel,BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
	}
	public static void main(String[]args) {
		new TextConverter();
	}

}

package ch10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class TicTacToe implements ActionListener{

	
	private Random random = new Random();
	private JFrame frame = new JFrame();
	private JPanel titlePanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JLabel titleLabel = new JLabel();
	private int count =1;
	JButton [][] buttons = new JButton[3][3];
	boolean player1Turn = false; //true 면 1의순서

public TicTacToe() {
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
	frame.setSize(1000,1000);
	
	
	titleLabel.setBackground(new Color(25,25,25));
	titleLabel.setForeground(new Color(25,255,0));
	titleLabel.setFont(new Font(Font.SANS_SERIF,Font.BOLD,75));
	titleLabel.setHorizontalAlignment(JLabel.CENTER);//글자수평정렬 중간
	titleLabel.setText("TIC TAC TOE");
	titleLabel.setOpaque(true);//??
	
	titlePanel.setLayout(new BorderLayout());
	titlePanel.add(titleLabel);
	
	
	frame.add(titlePanel);	
	frame.add(buttonPanel);
	
	buttonPanel.setLayout(new GridLayout(3,3));
	buttonPanel.setBackground(new Color(150,150,150));
	
	for(int i =0; i<3 ; i++) {
		for(int j=0; j<3; j++) {
		buttons[i][j] = new JButton();
		buttons[i][j].setOpaque(true);
		buttons[i][j].setFont(new Font(Font.SANS_SERIF,Font.BOLD,120));
		buttons[i][j].addActionListener(this);
		buttonPanel.add(buttons[i][j]);
	}
	}
	frame.add(titlePanel, BorderLayout.NORTH);
	}

	private void firstTurn() {
		try {
		Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		if(random.nextInt(2)==0) {
			player1Turn = true;
			titleLabel.setText("x turn");
		}else {
			player1Turn = false;
			titleLabel.setText("y turn");
		}
	}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
	for(int i=0; i<3; i++) {
		for(int j=0; j<3; j++) {
	
	if(e.getSource()== buttons[i][j]) {
		if (buttons[i][j].getText().equals("")) {
			
			if (player1Turn ==true) {
				buttons[i][j].setForeground(Color.blue);
				buttons[i][j].setText("O");
				player1Turn = false;
				titleLabel.setText("o turn");
				
			}else {
				buttons[i][j].setForeground(Color.red);
				buttons[i][j].setText("X");
				player1Turn = true;
				titleLabel.setText("x turn");
			}
			
		}
		}
		
		
		
	}
		}
	}

public void check() {
	
	if( ((buttons[0][0].getText().equals("X"))&&	
			(buttons[0][1].getText().equals("X"))&&	
			(buttons[0][2].getText().equals("X")))){
		xWins(0,1,2);
	}
	if( ((buttons[0][0].getText().equals("O"))&&	
			(buttons[0][1].getText().equals("O"))&&	
			(buttons[0][2].getText().equals("O")))){
		oWins(0,1,2);
	}
	
	//인터페이스
	//디폴트메소드 정적 메소드
	//무명 클래스
	//함수 인터페이스와 람다식
	//람다식
	//패키지
	
	
	
}

private void xWins(int a, int b , int c) {
	
	buttons[a][a].setBackground(Color.green);
	buttons[a][b].setBackground(Color.green);
	buttons[a][c].setBackground(Color.green);
	titleLabel.setText("X WINS !!");
	
	for(int i =0; i<buttons.length;i++) {
		for(int j=0; j<buttons.length;j++) {
			buttons[i][j].setEnabled(false);
		}
		
	}
	
}
private void oWins(int a, int b , int c) {
	buttons[a][a].setBackground(Color.green);
	buttons[a][b].setBackground(Color.green);
	buttons[a][c].setBackground(Color.green);
	titleLabel.setText("O WINS !!");
	
	for(int i =0; i<buttons.length;i++) 
		for(int j=0; j<buttons.length;j++){
		buttons[i][j].setEnabled(false);
	}
}



	
public static void main(String[]args) {
	new TicTacToe();
}
}

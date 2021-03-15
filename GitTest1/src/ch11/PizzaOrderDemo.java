package ch11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PizzaOrderDemo extends JFrame implements ActionListener{
	
	private  int sum,temp1,temp2,temp3;
	private JButton orderBtn ,cancelBtn;
	private JPanel orderPanel;
	private JTextField priceField;
	
	JPanel welcomePanel =new welcomePanel();
	JPanel typePanel = new typePanel();
	JPanel toppingPanel =new toppingPanel();
	JPanel sizePanel = new sizePanel();
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==orderBtn) {
			sum = temp1 + temp2 + temp3;
			priceField.setText("피자의 가격은:"+ sum +"원 입니다");
			System.out.println(sum);
		}else if(e.getSource()==cancelBtn) {
			priceField.setText("피자의 가격은:"+0+"원 입니다");
		}
	}
	public PizzaOrderDemo() {
		 orderPanel = new JPanel();
		this.add(orderPanel);
		orderBtn = new JButton("주문");
		
		 cancelBtn = new JButton("취소");
		
		orderPanel.add(orderBtn);
		
		orderPanel.add(cancelBtn);
		
		 priceField = new JTextField("가격은 : 원");
		orderPanel.add(priceField);
		priceField.setEditable(false);
		priceField.setColumns(15);
		
		this.add(orderPanel,BorderLayout.SOUTH);
		
		this.add(welcomePanel, BorderLayout.NORTH);
		this.add(typePanel, BorderLayout.WEST);
		this.add(toppingPanel, BorderLayout.CENTER);
		this.add(sizePanel, BorderLayout.EAST);
	
		this.setSize(600,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		orderBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		
	}
	class welcomePanel extends JPanel {
		public welcomePanel() {
			JLabel label = new JLabel("피자를 주문해주세요");
			this.add(label);
			
		}
	}
	class typePanel extends JPanel implements ActionListener{
		JRadioButton peperroni;
		JRadioButton potato;
		JRadioButton bulgogi;
		public typePanel() {
			
			this.setLayout(new GridLayout(3,1));
			this.setBorder(BorderFactory.createTitledBorder("종류"));

			ButtonGroup bg2 = new ButtonGroup();  //버튼 그룹으로 그룹중에 버튼 하나만 눌리도록 설정.
			 peperroni = new JRadioButton("페페로니 피자15000원");
			bg2.add(peperroni);
			this.add(peperroni);
			 potato = new JRadioButton("포테이토 피자16000원");
			bg2.add(potato);
			this.add(potato);
			 bulgogi = new JRadioButton("불고기 피자17000원");
			bg2.add(bulgogi);
			this.add(bulgogi);
			
			peperroni.addActionListener(this);
			potato.addActionListener(this);
			bulgogi.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(peperroni.isSelected()) {
				temp1 =15000;
			}else if(potato.isSelected()) {
				temp1 =16000;
			}else if(bulgogi.isSelected()) {
				temp1 = 17000;
			}
		}
	}
	class toppingPanel extends JPanel implements ActionListener{
			
			JRadioButton olive;
			JRadioButton bacon;
			JRadioButton pineapple; 
			JRadioButton shrimp;
		public toppingPanel() {
			
			
			this.setLayout(new GridLayout(4,1));
			this.setBorder(BorderFactory.createTitledBorder("토핑"));
			
			ButtonGroup bg1 = new ButtonGroup();
			
			 olive = new JRadioButton("올리브 추가500원");
			bg1.add(olive);
			this.add(olive);
			 bacon = new JRadioButton("베이컨 추가 1000원");
			bg1.add(bacon);
			this.add(bacon);
			 pineapple = new JRadioButton("파인애플 추가 1500원");
			bg1.add(pineapple);
			this.add(pineapple);
			 shrimp = new JRadioButton("새우 추가 2000원");
			bg1.add(shrimp);
			this.add(shrimp);
			olive.addActionListener(this);
			bacon.addActionListener(this);
			pineapple.addActionListener(this);
			shrimp.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(olive.isSelected()) {
				temp2 =500;
			}else if(bacon.isSelected()) {
				temp2 =1000;
			}else if(pineapple.isSelected()) {
				temp2 = 1500;
			}else if(shrimp.isSelected()) {
				temp2 = 2000;
			}
		}
	}
	class sizePanel extends JPanel implements ActionListener{
		
			JRadioButton small;
			JRadioButton medium;
			JRadioButton large;
			
		public sizePanel() {
			this.setLayout(new GridLayout(3,1));
			this.setBorder(BorderFactory.createTitledBorder("사이즈"));

			ButtonGroup bg1 = new ButtonGroup();
			 small = new JRadioButton("스몰 기본사이즈 가격차이X");
			bg1.add(small);
			this.add(small);
			 medium = new JRadioButton("미디움 사이즈업 2000원");
			bg1.add(medium);
			this.add(medium);
			 large = new JRadioButton("라지 사이즈업 3000원");
			bg1.add(large);
			this.add(large);
			small.addActionListener(this);
			medium.addActionListener(this);
			large.addActionListener(this);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(small.isSelected()) {
				temp3 =0;
				System.out.println("스몰사이즈 선택");
			}else if(medium.isSelected()) {
				temp3 =2000;
			}else if(large.isSelected()) {
				temp3 = 3000;
			}
		}
	}
	public static void main(String[]args) {
		new PizzaOrderDemo();
	}
	
	//멤버 변수로 만들고 생성자 내에서 또 객체 생성하게되면
	//객체가 메인메소드 실행시마다 생성되어서
	//addActionListener해도 이벤트발생이 안됨.
	
}

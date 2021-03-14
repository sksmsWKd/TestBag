package ch11;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class comboBoxDemo extends JFrame implements ActionListener{

	public JLabel label;
	
		@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JComboBox combo = (JComboBox) e.getSource();
		String name = (String)combo.getSelectedItem();
		changePicture(name);
		
	}
		protected void changePicture(String name){
			ImageIcon icon = new ImageIcon(name+".jpg");
			label.setIcon(icon);
			if(icon!=null) {
				label.setText(null);
				
			}else {
				label.setText("이미지 못찾음");
			}
		}

		
		
	
		public comboBoxDemo() {

		
			
			String animals[] = {"dog","lion","tiger"};
			JComboBox animalList = new JComboBox(animals);
			animalList.setEditable(true);   //원래 콤보박스는 타이핑 안되는게 디폴트인데, 이걸 넣으면 타이핑이 가능함
												//타이핑 한후 엔터하면 해당 이름+jpg 를 string 으로 받아서 검색가능 대소문자 상관없다.
			animalList.setSelectedIndex(0);
			animalList.addActionListener(this);   //동물이름 표시하는 콤보박스 생성
			

			
			 label = new JLabel();   
			changePicture(animals[animalList.getSelectedIndex()]);  //changePicture 메소드 실행, 선태괸 그동물로 그림변경
			label.setHorizontalAlignment(JLabel.CENTER);
			
			add(animalList,BorderLayout.PAGE_START);
			add(label,BorderLayout.CENTER);
			this.setSize(500,300);
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		}

		public static void main (String[] args) {
			comboBoxDemo frame=	new comboBoxDemo();
		}
}










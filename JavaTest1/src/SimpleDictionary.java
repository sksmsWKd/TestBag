// 21/05/06 map 과 swing 이용한 간단사전

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.lang.Object;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class SimpleDictionary extends JPanel implements ActionListener {
	/*
	 * 단어 입력 받을수 있는 JTextField 검색 
	 * /버튼 /추가 /버튼/ 단어장 구현을 위한 자료구조로 Map 객체
	 */

	private JTextField inputField = new JTextField(30);
	private JButton searchBtn = new JButton("검색");
	private JButton addBtn = new JButton("추가");

	/*
	 * Map 객체를 단어장 구현 사용함. 
	 * <key, value> 쌍으로 저장 , key 는 한글단어 , value 는 대응되는 영어단어
	 */

	 Map<String, String> dict = new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";
	// map 객체를 생성시 map 을 구현한 자료구조 생성

	public SimpleDictionary() {
		// Panel 의 기본 레이아웃은 : FlowLayout
		this.add(inputField);
		this.add(searchBtn);
		this.add(addBtn);

		searchBtn.addActionListener(this);
		addBtn.addActionListener(this);

		this.setPreferredSize(new Dimension(600, 50));
		// 파일에 key = value 형태로 저장된 엔트리들을 읽어서 , dict 를 구성하자.
		buildDictionaryFromFile();
	}
	
	private void buildDictionaryFromFile() {
		Properties props = new Properties();
		//Properties 도 일종의 map 인데,
		//key 와 value 의타입이 각각 String 으로 고정된/
//		props.put("사과", "apple");
//		System.out.println(props.get("사과"));
		//파일에서 읽어서 props 객체의 <key,value> 
		//쌍을 구할 수 있다.
		
		try (FileReader fReader = new FileReader(DIC_FILE_NAME)){
		
		props.load(fReader);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
//		Set<java.lang.Object> set = props.keySet();
//		for(java.lang.Object obj :set ) {
//			words.put((String)obj, (String)props.get(obj));
//		}
	
		Set<Object> set = props.keySet();
		for(Object obj :set ) {
			dict.put((String)obj, (String)props.get(obj));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String key = inputField.getText();
		if (key.trim().length() == 0)
			return;

		if (e.getSource() == searchBtn) {
			/*
			 * 입력된 단어를 추출 그 단어를 key 값으로 가지는 대응되는 맵 엔트리가 있는지 검사/ -> 
			 * dict.get(단어);
			 * 그 단어 대응되는 값이 있으면 JOptionPane.showMessageDialog() 메서드를 
			 * 호출해서 그 대응되는 값을 보여준다.
			 * 없으면 (null이면) JOptionPane.showMessageDialog() 메서드를 호출해서 
			 * '단어를 찾을수없습니다' 출력
			 * inputField 빈 문자열로 설정
			 */

			System.out.println("[" + key + "]");
			String value = dict.get(key);
			if(value !=null) { // 대응되는 단어가 있는경우
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
		
			}else { // 대응되는 단어가 없는경우
				JOptionPane.showMessageDialog(this, "단어를 찾을수 없습니다", key , JOptionPane.INFORMATION_MESSAGE);
				
			}
		} else if (e.getSource() == addBtn) {
			/*
			 * 입력된 단어를 추출
			 * String value = JOptionPane.showInputDialog();
			 *  메서드를 호출해서 추가할 영어 단어를 입력 받는다.
			 * dict.put(입력필드에 입력된 단어 , inputDialog 에 입력된 단어);
			 *  
			 */
			String value = JOptionPane.showInputDialog(this, key+"에 대응되는 영어단어를 입력하세요");
			
			if(value.trim().length()==0)return;
			
			dict.put(key, value);
			addWordToFile(key,value);
			JOptionPane.showMessageDialog(this, value+"영어단어가 추가되었습니다", key , JOptionPane.INFORMATION_MESSAGE );
		}
	//	inputField.setText("");
		
	}
	private void addWordToFile(String key, String value) {
		try (FileWriter fWriter = new FileWriter(DIC_FILE_NAME, true)){
			fWriter.write(key+"="+value+"\n");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		SimpleDictionary dictPanel = new SimpleDictionary();
		frame.add(dictPanel);
		frame.setLocationRelativeTo(dictPanel);

		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

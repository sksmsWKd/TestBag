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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
	private static final String JDBC_DRIVER = "org.mariadb.jdbc.driver";
	
	
	//DB 마다 서버 URL 포맷이 다르다.
	//찾아야한다.
	private static final String DB_SERVER_URL = "jdbc:mysql://localhost:3306/oop";
	private static final String DB_USER = "root";
	private static final String DB_USER_PASSWORD = "1111";
	
	/*
	 * Map 객체를 단어장 구현 사용함. 
	 * <key, value> 쌍으로 저장 , key 는 한글단어 , value 는 대응되는 영어단어
	 */
	
	private static final String diverClassName = "org.mariadb.jdbc.Driver";
	
	//"oracle.jdbc.driver.OracleDriver";  오라클
	//"org.mariadb.jdbc.Driver";
	

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
		buildDictionaryFromDB();
	}
	
	private void buildDictionaryFromDB() {
		/*
		 * 1. DATABASE server 연결한다
		 * 		a. JDBC 드라이버 메모리에 로딩 (적재)연결
		 * 			->>
		 * 		b. DriverManager (java.sql 패키지에 정의된 클래스)
		 * 		 
		 *  	Connection con = DriveManager.getConnection
		 *  메서드를 호출해 연결을 설립(유지됨)
		 *  이때 연결 정보를 getConnection() 메서드에 전달해줘야함.
		 *  연결정보 DB server 의 URL =>          (((ip,주소 ,, port 주소 데이트베이스 이름,))++ db 사용자의 아이디와 암호) 
		 *  
		 *  2.Connection 객체를 통해 SQL 문 실행을 서버에 요청 하고 그 결과를 받아 처리
		 *  크케 2가지 방법이있음
		 *  
		 *  =첫째는 con.createStatement() 메소드 호출을 통해서 반환되는 Statement 객체를 이용 <-정적 sql문
		 *  select * from dict where han = ?
		 *  
		 *  이 예에서는 PreperedStatement 객체를 이용
		 *  
		 * 
		 *  =두번째는 con.propareStatelment() 메서드 호출을 통해서
		 *  
		 *  selet *from dict where han - => <<동적 sql문
		 *  
		 *  
		 *  반환되는 PreparedStatement 객체를 이용하는 방법 (동적 sq;문
		 *  동적 sql 문: 프로그래밍 시점에 설치할 준비를  )
		 *  
		 *  
		*
		 * 
		 */
		
		/*    어느 db던지 같이 사용가능.
		 * sql 문이 조금 달라질수는 있는데.. sql 표준을 따름
		 * 
		 * 
		 * 
		 * 	
		//1. 문법적 검사
		//2. 정당성 검사
	    //3. execution plag세움
	    //4. execute
	
			//이 예에서는 PreperedStatement객체를 이용
		//String sql = "select * from dict";
		*/
		
		
		//PreparedStatement pstmt = com.prepareStatement.(sql);
		/*
		// 실행 준비가 된 PreparedStatement 을 실행시키는 방법은 크게 2가지
		//첫번 째 실행할 SQL insert delete update;
		
	pstmt.execute();  //반환값은 숫자, insert ,delete ,update 가 몇개됬는지
	insert into ...
	delete from dict...
	update set eng = ... from ....
	

		pstmt.executeUpdate();
		
		select...
		
		
		두번째. 실행할 sql 문이 select 문 인 경우
		ResultSet re = pstmt.executeQuery();  //ResultSet 은 결과쿼리
		결과를 한개씩 준다.
		현재 포인터가 가르키는곳에 결과있으면 true,  가르키는 레코드에 결과가 없으면 false
		
		
//	}

		 * 
		 * 
		 * 3. DB Server 와의 연결읠 해제 (close) 한다.
		 * con.close(); 
		 * 반드시 close 해야한다.
		 * 
		 * 
		 */
		Connection con;
		try {
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
	try {
		PreparedStatement pstmt =null;
		ResultSet re=null;
		Class.forName(JDBC_DRIVER );
		//패키지 이름까지 포함해서. class 이름을 줘야함 -->JDBC 드라이버 메모리에 로딩 (적재)연결
		
		//DB서버에 연결
	 con = DriverManager.getConnection(DB_SERVER_URL, DB_USER, DB_USER_PASSWORD);
		//Connection 은 java.sql 에있다
		
	
		// select 문 실행
		String sql  = "select * from dict";
		
		con.prepareStatement(sql);

		// 정당성검사 까지 다해서 준비시킴.
		
		ResultSet rs = pstmt.executeQuery();
		while(re.next()) {
			//현재 포인터가 가리키는 칼럼 값을 빼오면 됨
			//각 칼럼의 타입에 따라서 , 호출할 메서드가 달라진다.
			//예를들어서 char , varvchar 타입의 칼럼은
			//getString("칼럼이름" 또는 "칼럼위치");
			//int 타입의 칼럼은 getInt(...);
			//DateTime, Date 타입의 칼럼 값은
			//getDate();
			
			String han = re.getString(1);
			String eng = re.getString(2);
			
			dict.put(han,eng);
			
			
		}
		//java.sql 에있다 resultset
	} catch (Exception e) {
		// TODO Auto-generated catch block
	System.out.println(e.getMessage());
	}finally {
		
	}
	
	/*
	 * 드라이버마다 클래스이름이 다름
	 * 오라클,,mysql,,,mariaDb등등
	 * EX)mariaDB jdbc 드라이버 이름
	*/
		
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
			//파일과 db에 넣어줌.
			
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

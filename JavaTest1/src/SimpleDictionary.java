// 21/05/06 map 과 swing 이용한 간단사전

import javax.swing.*;

import java.awt.Dimension;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.sql.*;


public class SimpleDictionary extends JPanel implements ActionListener{
   /*
    * 단어 입력받는 JTextField
    * 검색버튼
    * 추가버튼
    * 단어장 구현을 위한 Map 객체
    */

   private JTextField inputField = new JTextField(30);
   private JButton searchBtn = new JButton("Search");
   private JButton addBtn = new JButton("Add");
   
   String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
   String URL = "jdbc:mysql://localhost:3306/oop";
   String USER = "root";
   String PWD = "1111";

   //Map 객체로 단어장 구현
   // <Key, Value> 쌍으로 저장. key는 한글, value는 대응되는 영어단어.
   Map<String, String> dict = new HashMap<>();
   private static final String DIC_FILE_NAME = "dict.props";


   public SimpleDictionary() {
      //Panel 의 기본 레이아웃 : FlowLayout
      this.add(inputField);
      this.add(searchBtn);
      this.add(addBtn);

      //SearchBtn, AddBtn 에 클릭이벤트를 처리해주는 리스너 지정.
      searchBtn.addActionListener(this);
      addBtn.addActionListener(this);

      this.setSize(new Dimension(600, 50));

      //파일에 key = value 형태로 저장된 엔트리들을 읽어서, dict를 구성.
      buildDictionaryFromFile();

      //데이터 베이스를 활용.
      buildDictionaryFromDB();
   }

   private void buildDictionaryFromDB() {
      /*
       * Database sever 에 연결한다.
       * JDBC 드라이버를 메모리에 로딩(적재)
       * DriverManager(java.sql 패키지에 정의된 클래스)
       * Connection con = DriverManager.getConnection();
       * 메서드를 호출해 연결을 establish
       * 이 떄 연결 정보를 getConnection() 메서드에 연결해줘야 함.
       * 연결정보 : DB server 의 URL, =>(ip address, port num, DB_Name, db 사용자의 id, pw);
       * connection 객체를 통해서 SQL 문 실행을 요청학, 그 결과를 받아 처리한다.
       * 1. con.createStatement() 메서드 호출한 후 반환되는 Statment 객체를 이용 (Static SQL)
       * 정적 SQL문 : 프로그래밍 시점에 실행할 SQL 문 결정되고 고정된 경우. SELECT * FROM dict;
       * 2. con.prepareStatement() 메서드 호출한 후 반환되는 PreparedStatement 객체를 이용. (Dynamic SQL) // 이번에 사용
       * 동적 SQL문 : 프로그래밍 시점에 실행할 SQL 문 결정되지 않고 변경되는 경우. SELECT * FROM dict WHERE kWord = ?
       * String sql = "SELECT * FROM dict";
       * PreparedStatement pstmt = con.prepareStatement(sql);
       * 실행 준비가 된 PreparedStatement를 실행시키는 방법 2가지
       * 1. 실행할 SQL 문이 insert, delete, update 의 경우 = pstmt.executeUpdate();
       * 2. 실행할 SQL 문이 select 문일 경우. = pstmt.executeQuery();
       */

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

//   Connection con = null;
   Statement stmt = null;
   ResultSet rs = null;
   //DB
   // JDBC 드라이버를 메모리에 적재
   // 드라이버 클래스 이름은 DBMS 마다 다르다.
   try {
      Class.forName(JDBC_DRIVER); // Load Driver
      System.out.println("Connect Success");
   } catch (ClassNotFoundException e) {
      System.out.println("Fail to Connect");
   }

   try (Connection con = DriverManager.getConnection(URL, USER, PWD);){ // finally 호출 필요없음.

      //Connect DB
//      con = DriverManager.getConnection(URL, USER, PWD);

      //Run SELECT
      String sql = "SELECT * FROM dict";
      PreparedStatement pstmt = con.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while(rs.next()) {
         // 현재 포인터가 가리키는 컬럼 값을 빼오면 됨.
         // 각 컬럼의 타입에 따라서 호출할 메소드가 달라진다.
         // ex) char, varchar 타입의 컬럼은 getString('컬럼이름'또는 '컬럼위치');
         // int 타입은 getInt();
         // DateTime, Date 타입은 getDate();
    	  
    	//현재 포인터가 가리키는 칼럼 값을 빼오면 됨
			//각 칼럼의 타입에 따라서 , 호출할 메서드가 달라진다.
			//예를들어서 char , varvchar 타입의 칼럼은
			//getString("칼럼이름" 또는 "칼럼위치");
			//int 타입의 칼럼은 getInt(...);
			//DateTime, Date 타입의 칼럼 값은
			//getDate();

    	  String key = rs.getString("hword");
    	  String value= rs.getString("eword");
    	  
    	  dict.put(key, value);
         String hword = rs.getString("hword");
         //rs.getString(1);
         String eword = rs.getString("eword");
         //rs.getString(2);
         
         

         dict.put(hword, eword);
      }

   }catch(Exception ex) {
      System.out.println("Load fail" + ex);
   }
//   finally {
//      try {con.close();} catch(Exception ignore) {}
//   }
   }

   private void buildDictionaryFromFile() {
      // Properities 도 일종의 Map 이며,
      // Key, Value 쌍의 타입이 각각 String, String로 고정된 일종의 Map이다.
      Properties props = new Properties();
//      props.put("사과", "Apple");
//      System.out.println(props.get("사과"));

      // 파일에서 이릭어서 props 객체의 <key, value> 쌍을 구성할 수 있다.
//      FileReader fReader = null;
      try (FileReader fReader = new FileReader(DIC_FILE_NAME)){
         props.load(fReader);
      } catch (Exception e) {
         System.out.println(e.getMessage());
      }
      Set<java.lang.Object> set = props.keySet();
      for(java.lang.Object obj : set) {
         dict.put((String)obj, (String)props.get(obj));
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String key = inputField.getText();
      if(key.trim().length() == 0) return;// 공백만 입력된 경우는 무시

      
      if(e.getSource() == searchBtn) {
         /*
          * 입력된 단어를 추출
          * 그 단어를 키 값으로 가지는 대응되는 맵 엔트리가 있는지 검사
          * dict.get("단어");
          * 그 단어에 대응되는 값이 있으면, JOptionPane.showMessageDialog() 메서드를 호출.
          * 대응되는 값을 보여줌. 없으면 (null)이면 JOptionPane.showMessageDialog() 메서드 호출.
          * "단어를 찾을 수 없습니다." 출력
          * inputField를 빈문자열로 설정.
          */
    	  
    	  

         System.out.println("[" + key + "]");
         String value = dict.get(key);

         
         if(value != null) { // 대응되는 단어가 있는 경우.
            JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
         }else { // 대응되는 단어가 없는 경우.
            JOptionPane.showMessageDialog(this, "단어를 찾을 수 없음.", key, JOptionPane.ERROR_MESSAGE);
         }



      }else if(e.getSource() == addBtn) {
         /*
          * 입력된 단어를 추출
          * String value = JOptionPane.showMessafeDialog();
          * 메서드를 호출해서 추가할 영어 단어를 입력받음.
          * dict.put (입력필드에 입력된 단어, inputDialog에 입력된 단어);
          */
         String value = JOptionPane.showInputDialog(this,
            "입력한 "+ key + " 에 대응되는 영어단어를 입력하세요.");
         if(value.trim().length() == 0) return;
         dict.put(key, value);
         dict.put(value, key); //한영
         
         addToDB(key, value);
         
         
         addWordToFile(key, value);
         JOptionPane.showMessageDialog(this, value + " 영어단어가 추가되었습니다.",
               key, JOptionPane.INFORMATION_MESSAGE);
      }
//      inputField.setText("");

   }

   private void addToDB(String key, String value) {
	   /*
	    * 1. 드라이버 클래스는 딱 한번만 메모리에 적재하면 된다.
	    * 근데 , 이미 객체가 생성될때 생성자에서 적재되었음.
	    * 여기서는 적재할 필요가 없다
	    * 
	    * 2.데이터베이스에 연결
	    * 
	    * 3.SQL문 실행
	    * prepar
	    * 4. 데이터베이서 연결 해제
	    * 
	    */
	   
	   try(Connection con   =  DriverManager.getConnection(URL,USER,PWD)){   //서버 url, id, pw 명시해야함
		   String sql = "insert into dict values(?,?)";
		   con.prepareStatement(sql);
		   PreparedStatement pstmt = con.prepareStatement(sql);
		   
		   //?자리에 값을 채운 후에 , 서버에게
		   //서버에 실행 준비된 sql문을 실행하라고 요청해야 한다.
		   
		   pstmt.setString(1, key);
		   pstmt.setString(2, value);
		   //첫번째 인자에는 key 두번째 인자에는 value
		   
		   pstmt.executeUpdate();//실행요청
		   
	   }catch(Exception e) {
		   System.out.println(e.getMessage());
		   e.printStackTrace();   // 어디서 에러가났는지? 몇번에서 에러가났는지?? 알기가쉽다.
	   }

   }

   private void addWordToFile(String key, String value) {

      try(FileWriter fWriter =
            new FileWriter(DIC_FILE_NAME, true)){
         fWriter.write(key+"="+value+"\n"); // 덮어씀.
      }catch(Exception e) {
         System.out.println(e.getMessage());
         }

   }

   public static void main(String[] args) {
      JFrame frame = new JFrame();
      SimpleDictionary dictPanel = new SimpleDictionary();
      frame.add(dictPanel);

      frame.setTitle("Simple Dictionary");
      frame.pack();
      frame.setResizable(false);
      frame.setLocationRelativeTo(dictPanel);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   }

}





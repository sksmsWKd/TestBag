
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.sql.Date;



public class BookListViewer2 extends JFrame implements ActionListener{

	private JTextField idField, titleField, publisherField, yearField, priceField;
	private JButton previousBtn, nextBtn, insertBtn, finishBtn;
	private ResultSet rs;
	private Connection con;
	
	public BookListViewer2() throws Exception{
	
		/*
		 * 객체가 생성될때 반드시 불려지는것. 생성자
		 * 
		 * 이 JFrame 객체(this)의 Layout을  GridLayout 로설정
		 * 컴포넌트들을 생성하고 JFrame 객체(this) 에 추가
		 * 
		 * 버튼 컴포넌트들의 액션리스너를 이 객체(this) 로 설정한다.
		 */
		
		
		/*
		 * DB에서 책 레코드들을 가져오자.
		 * 1.JDBC 드라이버 적재
		 * 2.DB연결
		 * 3.PreparedStatement 객체 생성
		 * 4.SQL문 실행
		 * 
		 */
		
		Class.forName("org.mariadb.jdbc.Driver");
		 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop", "root", "1111");
		String sql ="select * from books order by book_id desc";
		con.prepareStatement(sql);
		
		/*
		 * 1. 문법적 검사  
		 * 2. 정당성 검사
		 * 3. execution plag세움
		 * 123 후 PreparedStatement 객체 반환
		 * 4. execute 
		 */
		PreparedStatement pstmt = con.prepareStatement(sql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		/*
		 * select 문을 실행할 때는 executeQuery()메서드를 사용하고
		 * 그외 , insert ,delete, update 문을 실행할 때는
		 * executeUpdate()메서드를 사용한다.
		 * - executeUpdate 반환은 정수값
		 * - executeQuery 는 결과집합- ResultSet
		 */
		 rs = pstmt.executeQuery();
	
		
		this.setLayout(new GridLayout(0,2));
		
		this.add(new JLabel("ID", JLabel.CENTER));
		idField = new JTextField(10);
		this.add(idField);
		
		this.add(new JLabel("Title", JLabel.CENTER));
		titleField = new JTextField(10);
		this.add(titleField);
		
		this.add(new JLabel("Publisher", JLabel.CENTER));
		publisherField = new JTextField(10);
		this.add(publisherField);
		
		this.add(new JLabel("Year", JLabel.CENTER));
		yearField = new JTextField(10);
		this.add(yearField);
		
		this.add(new JLabel("Price", JLabel.CENTER));
		priceField = new JTextField(10);
		this.add(priceField);
		
		previousBtn = new JButton("Previous");
		previousBtn.addActionListener(this);
		this.add(previousBtn);
		
		nextBtn = new JButton("Next");
		nextBtn.addActionListener(this);
		this.add(nextBtn);
		
		insertBtn = new JButton("Insert");
		insertBtn.addActionListener(this);
		this.add(insertBtn);
		
		finishBtn = new JButton("Finish");
		finishBtn.addActionListener(this);
		this.add(finishBtn);
		
		
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		//x 눌러도 안꺼지게함
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(350, 200);
	}
	





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
		if(e.getSource()==previousBtn) {
			System.out.println("previousBtn");
			/*결과집합의 커서를 이전으로 이동하고
			 * 그 커서가 가리키는 결과 레코드의 컴럼값을 뽑아와서 
			 * 적절한 JTextField 값으로 설정
			 */
			rs.previous();
			setCurrentBookInfo2TextField();
			//현재 책 정보를 텍스트필드에.
			
		}else if(e.getSource()==nextBtn) {
			System.out.println("nextBtn");
			/*결과집합의 커서를 다음으로 이동하고
			 * 그 커서가 가리키는 결과 레코드의 컴럼값을 뽑아와서 
			 * 적절한 JTextField 값으로 설정
			 */
		}else if(e.getSource()==insertBtn) {
			System.out.println("insertBtn");
			
		}else if(e.getSource()==finishBtn) {
			System.out.println("finishBtn");
			System.out.println("종료합니다...");
			con.close();
			System.exit(0);
		
		}
	}
		catch(Exception err) {
		System.out.println(err.getMessage());
	}
	}
	
	private void setCurrentBookInfo2TextField() throws Exception {
		// TODO Auto-generated method stub
		int bookId = rs.getInt("book_id");
		String title = rs.getString("title");
		String publisher = rs.getString("publisher");
		Date year = rs.getDate("year");
		int price = rs.getInt("price");
		
		idField.setText(String.valueOf(bookId));
		titleField.setText(title);
		publisherField.setText(publisher);
		yearField.setText(year.toString());
		priceField.setText(String.valueOf(price));
	}






	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		//BookListenerViewer 클래스의 인스턴스 생성
		
		new BookListViewer2();
		
		//main 메소드 끝나도 창이 안꺼져요 왜에요?
		//gui 가 독립된 스레드로 계속 돌아가서다
	}

}

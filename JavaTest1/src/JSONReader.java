// 21/06/07
//응용 1~2문제
import java.net.*;

import com.google.gson.Gson;

import java.io.*;
 
import java.sql.*;

public class JSONReader {
	public static void main(String[]args) throws Exception{
	String site = "https://jsonplaceholder.typicode.com/posts";
	
	URL url = new URL(site);
	
	URLConnection con = url.openConnection();
	
	InputStream stream = con.getInputStream();
			
	//편리하게 한줄씩 읽을수있게 BufferedReader
	
	//BufferedReader 는 InputStream 에서 바로 만들지는 못하니
	//InputStreamReader 를 거쳐서 만듬
	
	InputStreamReader reader =new InputStreamReader(stream,"UTF-8");
	
	//InputStreamReader reader =new InputStreamReader(stream); -> utf-8 지원안함
	//생성자 매개변수로.
	//Reader 붙으면 문자열 받는것
	//안붙으면 보통 byte
	
	BufferedReader bufReader = new BufferedReader(reader);
	
	String line = null;

	String jsonString = "";
	while((line= bufReader.readLine())!=null) {
		jsonString += line;
	}
	System.out.println(jsonString);
	//한 라인씩 읽게 된다.

		Gson gson = new Gson();
		
		
		//String json ="[{'userId' : 1, 'id':1, 'title':'test', 'body':'test body'},{'userId' : 2, 'id':2, 'title':'test2', 'body':'test body2'}]";
		Post[] posts = gson.fromJson(jsonString,Post[].class);

	

//		Gson gson = new Gson();
//		String json ="{'userId' : 1, 'id':1, 'title':'test', 'body':'test body'}";
//		Post post = gson.fromJson(json,Post.class);

		
		/*
		 * 내부적으로
		 * Post post = new Post();
		 * post.setUserId(1);
		 * post.setId(1);
		 * .....
		 * return post
		 * 
		 * 
		 */
//			System.out.println(post.getUserId());
//			System.out.println(post.getId());
//			System.out.println(post.getTitle());
//			System.out.println(post.getBody());
			//객체로 만들어서 핸들링 가능.
			
			//만약 배열이면 post[0].getUserId();...
		
			for(Post post : posts) {
				System.out.println(post.getUserId());
				System.out.println(post.getId());
				System.out.println(post.getTitle());
				System.out.println(post.getBody());
			}
			
			insertIntoDB(posts);
		
	}
	
	private static void insertIntoDB(Post[] posts) throws Exception {
		/*
		 * 1. Class.forName(...); // JDBC 드라이버 메모리에 적재
		 * 
		 * 2. Connection con = 
		 * 			DriverManager.getConnection(...);  DB서버에 저장
		 * 3. String sql = "insert into posts(userId, id, title, body)
		 * 									values(?,?,?,?)"
		 * 
		 * PreparedStatement pstmt = con.prepareStatement(sql);
		 * 
		 * 
		 * 실행 준비까지는 123. 한번만 하면 됨
		 * 
		 * 4. x 자리 들어갈 값을 설정
		 * 
		 * pstmt.setInt(1, post.getUserId());
		 * pstmt.setInt(2, post.getId());
		 * pstmt.setString(3, post.getTitle());
		 * pstmt.setString(4, post.getBody());
		 * 
		 * 5. 서버에 실행요청
		 * pstmt.executeUpdate();
		 * 왜?? insert 문이니깐.
		 * 
		 * 데이터가 한가지 아니고 여러개면, 4,5 번만 안에 값 바꾸어서 roop돔
		 * 
		 * 6. con.close();
		 * 
		 */
		
		Class.forName("org.mariadb.jdbc.Driver");
		//이름꼭기억하기
		
		String url = "jdbc:mysql://localhost:3306/oop";
		String user="root";
		String password="1111";
		
		Connection con = DriverManager.getConnection(url, user, password);
		//연결 됬으면 sql문 
		
		String sql = "insert into posts(userId, id, title, body)values(?,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		for (Post post: posts) {
			pstmt.setInt(1, post.getUserId());
			  pstmt.setInt(2, post.getId());
			  pstmt.setString(3, post.getTitle());
			  pstmt.setString(4, post.getBody());
			  
			  //1~4자리 ? 의 자리에 값 설정
			  
			  pstmt.executeUpdate();
			  //실행
			  
			  
		}con.close();
		//연결해제
	}
}

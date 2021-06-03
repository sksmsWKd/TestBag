import java.net.*;
import java.io.*;

public class HttpURLPostTest {
public static void main(String[]args) throws Exception{
								// 이 메서드 실행시 throw 될수도있다 - throws
								// 직접 에러 throw - throw
	String site = "http://localhost:9090/todos";
	
	URL url = new URL(site);
	
	HttpURLConnection con = (HttpURLConnection)url.openConnection();
	//http connection 으로강제변환
	con.setDoInput(true);
	con.setDoOutput(true);
	// Output 을 true 로
	//기본적으로 inputstream 만가능함.
	
	con.setRequestMethod("POST");
	// OutputStream 열어서 보내겠다.
	
	
	con.setRequestProperty("content-type", "application/x-www-form-urlencoded");
	//http 요청 헤더 부분에 , 서버가 받아서 표시
	
	String data = "id=scpark&pw=1111";
	// ID - SCpark
	
	OutputStream stream = con.getOutputStream();
	
	
	OutputStreamWriter owriter = new OutputStreamWriter(stream, "UTF-8");
	//유니코드로 모든글자
	//OutputStream 객체를 그대로 써도 되는데 OutputStreamWriter 객체를 새로 만듬
	
	PrintWriter writer = new PrintWriter(owriter);

	
	writer.print(data);
	writer.flush();
	//혹시 안보내고 buffer 에 남아있는것이 있으면 보냄
	
	InputStream instream = con.getInputStream();
	
	InputStreamReader instreamReader = new InputStreamReader(instream);
	//inputstream 을 이용해서 만듬. reader 는 내부적으로 inputstream이있음
	
	BufferedReader reader = new BufferedReader(instreamReader);
	
	String line;
	while((line=reader.readLine())!=null) {
		//
		System.out.println(line);
	}System.out.println();
	
	
	
}
}

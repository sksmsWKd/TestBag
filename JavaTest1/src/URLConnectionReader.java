import java.net.*;
import java.io.*;
public class URLConnectionReader {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		//  1. URL 객체를 만듬
		URL site = new URL("https://www.naver.com");
		
		//  2. URL 객체보루터 사이트로 연결을 시도함. openConnection();
		URLConnection con  = site.openConnection();
		
		//  3. InputStream 객체를 통해 네트워크 너머의 프로세스가 보내주는 데이터를 읽는다.
		InputStream stream = con.getInputStream();
		
		InputStreamReader isreader = new InputStreamReader(stream);
		
		BufferedReader reader = new BufferedReader(isreader);
		String line ;
		while((line = reader.readLine())!=null) {
		System.out.println(line);
		
		}
		
		
	}

}

import java.net.*;

import com.google.gson.Gson;

import java.io.*;
public class PostJson {

	public static void main(String[]args)throws Exception{
	Gson gson = new Gson();
	String site = "https://jsonplaceholder.typicode.com/posts";
	
	//연결
	//결과를 입력스트림으로 받아서 문자열로 저장.
	//저장된 문자열로부터 자바
	
	//자바 객체를 이용하여 여러가지 처리를 할수 있겠다
	//db에 저장할 수도 있고
	
	//네트워크 - 파싱 - 디비넣기
	//디비에서 - 파싱 - 네트워크보내기
}
}
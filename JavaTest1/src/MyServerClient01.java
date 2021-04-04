import java.io.*;
import java.net.*;


public class MyServerClient01 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("123.123.123.123", 1234); 
			System.out.println("접속 성공");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

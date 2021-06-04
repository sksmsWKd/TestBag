import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


public class MyServerClient01 {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.1.1.1", 1234); 
			System.out.println("접속 성공");
			
			InputStream is = socket.getInputStream();
			DataInputStream dis = new DataInputStream(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

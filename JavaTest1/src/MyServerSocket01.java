import java.net.*;
import java.io.*;


public class MyServerSocket01 {
	
	public static void main(String[] args) {
		try {
			int socketPort = 1234;
			ServerSocket serverSocket = new ServerSocket(socketPort); 
			System.out.println("socket : " + socketPort + "으로 서버가 열렸습니다");
			
                     
                        while(true) {
                        Socket socketUser = serverSocket.accept(); // 소켓 서버로 접속 시 socketUser에 접속자 정보 할당
                        System.out.println("Client가 접속함 : " + socketUser.getLocalAddress()); // 접속자의 getLocalAddress 가져오기
                        }			
            
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
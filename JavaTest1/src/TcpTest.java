import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpTest {
  public static void main(String[] args) throws IOException {
  
    ServerSocket socket = new ServerSocket(1234);
    System.out.println("서버 준비 완료");

    Socket socket1 = socket.accept();

    System.out.println("서버의 소켓 : " + socket); // toString() 오버라이드 되어있음

    Sender sender = new Sender(socket1);
    Receiver receiver = new Receiver(socket1);

    sender.start();
    receiver.start();
   
  } 
} 
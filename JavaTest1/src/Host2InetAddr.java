import java.net.*;
public class Host2InetAddr {

	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String hostName  = "www.naver.com";
		
		try {
			InetAddress address = InetAddress.getByName(hostName);
			System.out.println(address);
			System.out.println(address.getHostAddress());
			//웹사이트의 ip4 주소를 적어줌.
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}

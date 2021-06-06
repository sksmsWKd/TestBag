import java.net.*;
import java.io.*;
public class HttpURLTest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		URL url =new URL ("https://www.google.com/search?q=java");
		HttpURLConnection con = (HttpURLConnection)url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		  
		 int responseCode = con.getResponseCode();
		 System.out.println("Response Code :  "+ responseCode);
		 
		 InputStream stream = con.getInputStream();
		 
		 InputStreamReader isreader  = new InputStreamReader(stream,"UTF-8");
		 
		 BufferedReader reader = new BufferedReader(isreader);
			String line ;
			while((line = reader.readLine())!=null) {
			System.out.println(line);
			
			}
		 // 이거아직 커밋안함
		 
		
	}

}

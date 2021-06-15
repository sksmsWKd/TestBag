import java.net.*;

import com.google.gson.Gson;

import java.io.*;
 
import java.sql.*;
public class JSONReader2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		
		String site = "https://jsonplaceholder.typicode.com/posts";
		
		URL url = new URL(site);
		URLConnection con = url.openConnection();
		InputStream stream = con.getInputStream();
		
		InputStreamReader reader = new InputStreamReader(stream , "UTF-8");
		
		BufferedReader bufReader = new BufferedReader(reader);
		String line = null;
		String jsonString = "";
		while((line = bufReader.readLine())!=null) {
			jsonString+=line;
		}
		System.out.println(jsonString);
		
		Gson gson = new Gson();
		Post[] posts = gson.fromJson(jsonString, Post[].class);
		
	}

}

// 21/05/06 파일 아웃풋 테스트 .props

import java.util.*;
import java.io.*;
public class TextOutPutText {

	public static void main(String[] args) {
		Properties props = new Properties();
		File file = new File("dict.props");
		try(FileReader reader = new FileReader("dict.props")){
			//import 해서 자바의 io 패키지에 있다
		props.load(reader);
	}catch (Exception err){
		System.out.println(err.getMessage());
	}
				
	System.out.println(props.get("사과"));
	
	try {
	FileOutputStream out = new FileOutputStream("dict.props");
	props.store(out, "나의 한영사전");
	}
	catch(Exception e) {
		System.out.println(e.getMessage());
	}finally {
		try {
			FileOutputStream out= null;
			props.put("장미", "rose");
			out.close();
		}catch(Exception ignore) {
			
		}
	}
	
	}
}
	


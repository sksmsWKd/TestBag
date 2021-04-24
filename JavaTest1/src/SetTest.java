import java.io.*;
import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}   

	private static void test1() {
		File file = new File("wordbook.txt");
		Set<String> set = new HashSet<>(); // set 은 인터페이스라서 클래스 생성해야함
//		if (file.exists() == true) {
//		System.out.println(file.getAbsolutePath());
//		}else {
//			System.out.println(file.getAbsolutePath());
//		}
		// 파일 내용을 읽자.
		// 파일을 읽고쓰려면 stream 객체를 이용해야 한다.
		/*
		 * 파일을 읽을때는 input stream 파일을 쓸 때는 output stream 가 필요하다
		 * 
		 * stream 은기본적으로 byte stream. 그런데 문자단위로 읽고 쓸 떄는 문자 스트림을 이용하는 것이 편리 문자 단위의 입력
		 * 스트림은 reader 객체로 표현된다. 문자 단위의 출력 스트림은 writer 객체로 표현된다.
		 */
		int count = 0;
		BufferedReader bReader = null; // 한 라인 단위로 읽어줌
		try {
			FileReader fileReader = new FileReader(file);
			fileReader.read(); // 문자단위로 읽어줌
			bReader = new BufferedReader(fileReader); // 한 라인 단위로 읽어줌
			String line = null;
			// 읽은 내용을 string 으로 리턴
			System.out.println(line);
			
			line = bReader.readLine();
			System.out.println(line);
			line = bReader.readLine();
			System.out.println(line);

			while ((line = bReader.readLine()) != null) {
				if (line == null)
					break;
				line = bReader.readLine();
				set.add(line);
				System.out.println(line);
				count++;

			}

		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		} finally {
			try {
				bReader.close();
			} catch (Exception e) {

			}
		} // finally 안써도 되게 try
		System.out.println("중복포함 : " + count);
		System.out.println("중복미포함 : " + set.size());
	}
}

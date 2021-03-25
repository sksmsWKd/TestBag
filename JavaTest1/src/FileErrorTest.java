import java.io.*;

public class FileErrorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writelist();
	}

	public static void writelist() { // throws IOException ->throws 하면 try catch 안해도 됨.
		PrintWriter out = null;
		FileWriter fw = null; // 객체변수는 null로 초기화 가능;
		try {
			fw = new FileWriter("c:\\zz틀린주소"); // 파일 써주는 객체
			out = new PrintWriter(fw);
			out.println("안녕하세요");
			System.out.println("생성완료");
			out.close();

		} catch (IOException e) {
			System.out.println("catch" + e.getMessage());
		} finally {
			System.out.println("finally code"); // 예외와 상관없이 무조건 실행됨
			if (out != null) // runtime exception이 발생하지않도록
				out.close();
			System.out.println("finally end"); // 예외와 상관없이 무조건 실행됨

		}//
//
	}

}

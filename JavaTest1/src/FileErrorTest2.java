import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileErrorTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writelist();
	}

	public static void writelist() { // throws IOException ->throws 하면 try catch 안해도 됨.
		PrintWriter out = null;
		//FileWriter fw = null; // 객체변수는 null로 초기화 가능;
		
		//AutoClosable 인터페이스를 구현해야한다
		//그 객체는 try with resources 절에 사용 될수 있다.
		try (FileWriter fw = new FileWriter("out2.txt")){ // 파일 써주는 객체){// 마지막으로close 메소드가 불려져야하는 close 객체 생성을 ()괄호안에서
		//	fw = new FileWriter("c:\\zz틀린주소"); // 파일 써주는 객체
		
			out = new PrintWriter(fw);
			out.println("안녕하세요");
			System.out.println("생성완료");
			out.close();  // out 을 close 했지만 filewriter 도close 가능
			
		
		} catch (IOException e) {
			System.out.println("catch" + e.getMessage());
		} finally {
			System.out.println("finally code"); // 예외와 상관없이 무조건 실행됨
			if (out != null) // runtime exception이 발생하지않도록
				out.close();
			System.out.println("finally end"); // 예외와 상관없이 무조건 실행됨

		}//
	}

}

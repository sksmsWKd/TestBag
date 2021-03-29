
public class genericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericBox<String> gbox = new GenericBox(); // 형 <> 안 명시
		// String s = gbox.getContent("동해물과");
		//System.out.println(s);

		GenericBox<Integer> gbox2 = new GenericBox<Integer>(); // 형 <> 안 명시
		// gbox2.setContent(100); 에러남
		GenericBox<Student> gbox3 = new GenericBox<Student>(); // 형 <> 안 명시
		gbox3.setContent(new Student());
		Student std = gbox3.getContent(); // 타입을 클래스 따로만들지 않고 타입만 바꿔야할때
	}

}

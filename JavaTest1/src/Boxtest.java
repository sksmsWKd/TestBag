
public class Boxtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Box box = new Box();
		box.setContent("동해물과 백두산이");
		String cont = box.getContent();
		System.out.println(cont);

		Box2 box2 = new Box2();
		box2.setContent(105);
		Integer cont2 = box2.getContent();
		System.out.println(cont2);

		Box3 box3 = new Box3();
		Student std = new Student();
		std.setName("홍길동");
		std.setDept("컴정");
		std.setGrade(100);

		box3.setContent(std);
		System.out.println(std.getName() + ":" + std.getGrade() + ":" + std.getClass());

		Box4 box4 = new Box4();
		box4.setContent("동해물과 백두산이");
		box4.setContent("홍길동");
		box4.setContent(100);  // object형이라 int값도 가능
		box4.setContent("상자");
		System.out.println(box4.getContent()); // auto boxing - 객체 Integer <-> int 형 int//integer//number//object
												// 하위 <------ 상위 상속
												// <--- unboxing 자동변환 boxing--->

	}

	public static void process(Box4 box4) {
		Object obj = box4.getContent();
		if(obj instanceof Student) {
			Student std = (Student)obj; //instanceof
			
			
			String s =std.getName();
			int n = std.getGrade();
		}else if (obj instanceof String) {
			//문자열처리
		}else if (obj instanceof Integer) {
			//정수 처리
	

	}

	}
}

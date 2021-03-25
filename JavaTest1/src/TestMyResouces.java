
public class TestMyResouces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test1();
		test2();
	}

	public static void test1() { // trycatch 쓰는 에러핸들
		MyResource r = new MyResource();// 객체생성
		r.close(); // 리소스 반납
		try {
			System.out.println(r.getValue()); // throw를 myresource 에 적으면 에러가 날수도있어서 여기도 에러가 난다?? trycatch해야함
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			r.close(); // resource 의 close 메소드
		}
		System.out.println("정상 처리되었습니다");
	}

	public static void test2() { // trycatch 안쓰는

		try (MyResource r = new MyResource()) { // auto closealbe 하려면 implements해야함 + 직접 구현한 클래스라면 자원을 반납하는 문장을 넣으면 됨.
			System.out.println(r.getValue()); // throw를 myresource 에 적으면 에러가 날수도있어서 여기도 에러가 난다?? trycatch해야함
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}
}

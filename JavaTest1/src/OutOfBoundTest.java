
public class OutOfBoundTest {
	public static void main(String[] args) {
		int[] array = new int[10];

		for (int i = 0; i < 10; i++) {
			array[i] = 0;
		}
		try {
			int result = array[12];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열의 인덱스가 잘못되었습니다."); // 예외발생시만 실행되고 , 예외없으면 안됨.
		} finally {
			System.out.println("무조건 실행이 되는 구문입니다."); // 예외와 상관없이 무조건 실행됨
		}
		System.out.println("이건 항상 실행이됩니다");
	}//
}

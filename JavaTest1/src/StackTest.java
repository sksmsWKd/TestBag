import java.util.*;

//4/19

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Stack = LIFO (LAST IN FIRST OUT)
		 */

		// Stack stack = new Stack(); 기본.
		Stack<Integer> stack = new Stack<>();

		/*
		 * 얘도 제너릭. class 내부에서 사용할 데이터 타입이 저장되어진게 아니고 , 그 클래스의 객체를 생성할 때 결정할 수 있도록, 사용할
		 * 데이터 타입을 파라미터로 받아서 객체를 생성하는 것. 타입 파라미터 (Type Parameter)
		 * 
		 * 제너릭은 primitive type 불가능.
		 * https://gbsb.tistory.com/6 참조
		 * Integer 는 Wrapper class
		 * int 는 프리미티브 클래스.
		 * - Wrapper 클래스를 사용하는 이유
  			① 변수를 객체로 만들기 위해
  			② 필요한 메소드를 사용하기 위해
		 */

		for (int i = 0; i < 10; i++) {
			stack.push(i + 1);

		}
		System.out.println("스택");
		System.out.println(stack);
		
		while(!stack.isEmpty()) {
			Integer val = stack.pop();
			System.out.print(val + " ");	
		}	
		System.out.println(" ");
		System.out.println("팝 한 이후 스택");
		System.out.println(stack);
	}

}

import java.util.*;

//직접 만드는 arraylist
public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

	public static void test1() {
		// List<String> list = new ArrayList<>();
		List<String> list = new LinkedList<>(); // 둘다상관없다. 메커니즘은 다른데 사용자가쓰는 메소드는 동일.
		// list는 인터페이스라 new 해서 객체 못만듬. list 를 implement하고있는 arraylist를 만들수있음

		String[] arr = { "자동차", "운동장", "유치원", "학교", "개구리", "학교" }; // 중복되도 상관x
		for (String s : arr)
			list.add(s);
		// 출력은 그냥 for문 for each문iterator 가능

		// 1번방법
		System.out.println(list);
		// Arraylist 의 tostring()메소드가 이용됨.

		// 2번방법
		for (int i = 0; i < list.size(); i++) {

			System.out.print(list.get(i) + " ");
		}
		System.out.println();

		// 3번방법
		for (String s : list)
			System.out.print(s + " ");
		System.out.println();

		// 4번방법 iterator collection 의 원소 접근
		Iterator<String> iter = list.iterator(); // list 하나씩 접근가능할수있도록 iterator 객체생성

		for (int i = 0; i < list.size(); i++) {
			System.out.print(iter.next() + " "); // 첫번째라도 next해야함
		}
		// or
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();

		iter = list.iterator(); // 처음부터 다시 출력할경우 false 였어서 다시 생성

		// unchecked exception - > trycatch 안감싸도됨. exception 이 아니고 버그라서 발생안하게 코드짜야함

		// overloading은 add메소드로원소를 중간에 삽입할수 있다.
		list.add(1, "벚꽃");
		iter = list.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();

		list.remove(3);
		System.out.println(list);

	}
}

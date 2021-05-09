
import java.util.*;
import java.util.stream.IntStream;

// 05/03

public class CollectionTest {
	public static void main(String[] args) {
		test2();
		// test1();
		test3();
	}
	public static void test3() {  //arraylist
		ArrayList<String>list = new ArrayList<>();
		list.add("milk");
		list.add("bread");
		list.add("butter");
		System.out.println(list);
		list.add(1,"apple");
		System.out.println("index 1번에 apple 추가후"+list);
		list.set(2,"grape");
		System.out.println("2번인덱스원소를 바꾼후 "+list);
		
		list.remove(3);
		System.out.println("3번인덱스를 원소 삭제후"+list);
		
		Iterator<String>iter = list.iterator(); // iteraotr 란??
		while(iter.hasNext()) {
			System.out.println(iter.next());
			
		}
		iter.next(); // 다 돌기 끝나면 next하면 에러남
		
		
		
		
	}
	
	public static void setTest() {
		Set<String> set = new HashSet<>();
		String[]strArr = {"단어","중복","구절","중복"};
		for (String s : strArr) {
			if(set.add(s)==false) {
				System.out.println(s+"값은 이미 존재!!");
			}
		}
		System.out.println(set);
	}

	public static void test2() {
		List<Integer> list = new ArrayList<>();
		// List<Integer> list = new LinkedList<>(); // 성능을 고려하면 linked가나음 array list
		// <->linked list
//		for (int i = 0; i < 100000; i++) {
//			list.add(i + 1);
//		}
		IntStream.rangeClosed(1, 100000).forEach(i -> list.add(i)); // integer stream 생성. 시작값 끝값

		long start = System.currentTimeMillis();
//		for(int i = 0 ; i<1000;i++) {
//			list.add(30,100);
//		}
		for (int i = 0; i < list.size(); i++) {
			list.get(i);
		}

		long end = System.currentTimeMillis();

		System.out.println((end - start) + "ms elapsed");
	}

	public static void test1() {
		/*
		 * list : 순서가 있고 , 중복이 혀용되는 자료구조
		 */
		List<Integer> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		List<Double> list3 = new Vector<>();
		List<Integer> list4 = new Stack<>();

		for (int i = 0; i < 10; i++) {
			list1.add(i + 1);
			list2.add(String.valueOf(i + 1));
			list3.add(i + 1 * 1.0);
			list4.add(10 - i);
		}
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list4);

		for (int i = 0; i < list1.size(); i++) {// 포문 add해서 저장 get 해서 빼냄
			System.out.print(list1.get(i) + " ");
		}
		for (String s : list2) {// 어드벤스드 포문
			System.out.print(s + ",");
		}
		Iterator<Double> iter = list3.iterator();
		while (iter.hasNext()) {// hasNext는불린값, iterator 사용.

			Double d = iter.next();
			System.out.print(d + " ");
		}

	}

}
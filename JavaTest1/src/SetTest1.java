import java.util.*;


public class SetTest1 {
	public static void main(String[] args) {
		//test1();
		test2();

	}
	
	public static void test2() {
		List<Integer> list = Arrays.asList(2, 5234, 10, 3, 4, 5, 6, 8, 9, 10);
		//MyComparator mc = new MyComparator(mc);
		Set<Integer> set1 = new TreeSet<>();
		//Set<Integer> set1 = new LinkedHashSet<>();
		set1.addAll(list);
		Iterator<Integer> iter = set1.iterator();
		//입력된 순서대로 나오는지 확인
		//또는 값의 순서대로 나오는지 확인
		
		while(iter.hasNext()) {
			System.out.print(iter.next()+ " ");
		}
	}

	public static void test1() {
// 객체 생성 안하려고 static
		/*
		 * set 1 = {2,3,4,5,6,8,9,10} set 2 = {1,3,5,7,9}
		 * 
		 * 합집합 :set1.addAll(set2) = {1~10} 
		 * 교집합 :set1.retainAll(set2) = {3 , 5 ,9} 
		 * 차집합 = set1.removeAll(set2) =set1 - set2 => {2, 4, 6, 8, 10} set2.removeAll(set1) =
		 *			 set2 - set1 => {1, 7} //원본이바뀜.
		 */
		Set<Integer> set1 = new HashSet<>();
		//Integer[] arr = { 2, 3, 4, 5, 6, 8, 9, 10 };
		// <> 안이 타입 파라미터. generic 클래스 객체 생성할때 타입 파라미터는 primitive 타입 줄수없다
		// 객체 타입만 줄수있다.

		// 배열을 collection 으로 만들어주는메소드가 있다.
		// addall 시 collection 을 넣어줘야하기 때문.
		
		//Treeset 은 값에 따라 정렬된 순서로 나옴.
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6, 8, 9, 10);
		
		set1.add(2);
		set1.add(3);
		set1.add(4); set1.add(5);set1.add(6); set1.add(8); set1.add(9); set1.add(10);
		set1.addAll(list);
		// list는 collection
		
		
		Set<Integer> set2 = new HashSet<>();
		//Integer[] arr2 = {1,3,5,7,9};
		
		List<Integer>list2 = Arrays.asList(1,3,5,7,9);
		set2.addAll(list2);
		// set은 구현체라 단순set만 명시불가
		// hashset treeset linkedhashset
		
		System.out.println("set1 : " + set1);
		System.out.println("set2 : " + set2);
		
		Set<Integer> unionSet = new HashSet<>(set1);
		unionSet.addAll(set2);
		
		System.out.println("set1 합집합 set2: " + unionSet);
		
		//교집합

		Set<Integer> intersectionSet = new HashSet<>(set1);
		intersectionSet.retainAll(set2);
	
		System.out.println("set1 교집합 set2: " + intersectionSet);
		
		//차집합
		
		Set<Integer> diffset = new HashSet<>(set1);
		diffset.removeAll(set2);
	
		System.out.println("set1 차집합 set2: " + diffset);
	
		Set<Integer> diffset2 = new HashSet<>(set2);
		diffset2.removeAll(set1);
	
		System.out.println("set2 차집합 set1: " + diffset2);
		
		System.out.println("  for each문 ");
		for (Integer val : diffset) {
			System.out.print(val+ " ");
		}
		System.out.println("  $");
		
		
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()) {
			Integer val = iter.next();
			//val적절히 처리
			System.out.print(val+ " ");
			if(val == 10) {
				System.out.println("- > 10이 안에있다!");
			}
		}
		
		
	}
	class MyComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer n1, Integer n2) {
			// 앞의 인자로 전달된 것이 크면 양수
			//같으면 0
			// 뒤에 인자가 크면 음수
			return n1- n2;
		}

		
		
	}
	
}



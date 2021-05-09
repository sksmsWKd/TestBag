import java.util.*;

// 5/03

public class CollectionShuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		shuffleTest();
		binarySearchTest();
	}
	public static void binarySearchTest() {
		//1. 무작위 정수를 저장한 리스트에 대해 이진탐색 <= 잘못된 결과
		//2. 정렬된 리스트에 대해 이진탐색 < = 이렇게 사용해야 함
		// 이진 탐색시 리스트는 정렬이 되있어야함.
		
		Random random = new Random(); 
		List<Integer> list = new ArrayList<>();
		
		for (int i=0; i <20;i++){
		list.add(random.nextInt(40)+1);
		
			
		}
		System.out.println(list);
		int idx = Collections.binarySearch(list, 30); // 마이너스값 나오면 없다는거
		
		
		if(idx<0) {
			System.out.println("찾고자하는값이 없다.");
		}else if(idx >= 0){
			System.out.println((idx+1)+"번째이다");
		}
		
	}

	public static void shuffleTest() {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			list.add((i + 1) * 2);
		}
		ArrayList<Student3> stdList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Student3 std = new Student3();
			std.grade = (i + 1) * 100;
			stdList.add(std);
		}

		System.out.println("섞기 전");
		System.out.println(list);

		Collections.shuffle(list);
		System.out.println("섞은 후");
		System.out.println(list);
		
		System.out.println("2섞기 전");
		System.out.println(stdList);
		
		System.out.println("2섞은 후");
		Collections.shuffle(stdList);
		System.out.println(stdList);
	}

}

class Student3 {
	int grade;

	public String toString() {
		return String.valueOf(grade);
	}
}
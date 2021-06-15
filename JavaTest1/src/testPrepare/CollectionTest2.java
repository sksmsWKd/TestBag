package testPrepare;
import java.util.*;
public class CollectionTest2 {

	public static void test1() {
		List<Integer> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		List<Double> list3 = new Vector<>();
		List<Integer> list4 = new Stack<>();
		
		
		for(int i = 0 ; i<10 ; i++) {
			list1.add(i+1);
			list2.add(String.valueOf(i+1));
			list3.add(i+1 *1.0);
			list4.add(10-i);
			
		}
		
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		System.out.println(list4);

	}
	
	public static void main(String[] args){
		test1();
	}
}

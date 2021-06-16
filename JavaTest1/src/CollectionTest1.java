import java.util.Collections;
import java.util.List;
import java.util.Arrays;

//   5/03

public class CollectionTest1 {
	public static String[] sample = {"i","walk", "the", "line"};
	public static String[] sample2 = {};
	public class Reverse {
		public Reverse() {
			
			for(int i=sample.length; i<0;i--) {
			sample[i] = sample2[i];
			System.out.println(sample2);
			   
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		List<String> list = Arrays.asList(sample);
		List<String> list2 = Arrays.asList(sample2);
		
		//Collections 에 sort 메서드는 list 타입을 인자로 가짐
		System.out.println("정렬 전.."+ list);
		Collections.sort(list);   //arrays에 api를 통해 list 로 바꿀수 있다.
		System.out.println("정렬 후.."+ list);
		
		
		Collections.sort(list,new CollectionCompare());
		System.out.println("정렬 후x2 .."+ list);
		
		Collections.shuffle(list);
		System.out.println("셔플 후 .."+ list);
		
		
		//원소의 타입 클래스를 내가 변경 할수있다면 Comparable 인터페이스를 구현해서 정렬 방법 변경 가능
		
		//원소의 타입 클래스를 내가 변경 할수없다면 (내가 구현 안한거String Integer..) Comparator 클래스를 구현해서 정렬 방법을 알려줘야 한다
		//또는 원소의 타입 클래스를 변경 할 수 있지만 , 그 클래스를 변경하지않고
		//정렬 방법을 변경하고자 할 때는 Comparator 클래스를 구현해 준다.
		
		
		
		
		
	}
	
}

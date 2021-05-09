import java.util.Comparator;

//5/03


public class CollectionCompare implements Comparator<String> {

	

	@Override
	public int compare(String o1, String o2) {
		
		// o1 이 크면 양수 반환 , o1 o2 가 같으면  0을 반환
		// o2 가 크면 음수 반환
		
		//문자열 값의 비교는 , Comparable 인터페이스를 구현하고있는 
		// String class 에 compare 메소드를 호출하면된다.
		return o1.compareTo(o2)* (-1);
	}

}

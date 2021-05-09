import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;


//4/26 map 에서 정보를 가져오는 2가지와 map을 이용한 전화번호부입니다.

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		test1();
		test2();

	}
	public static void test2() {
		/*
		 * 친구들 전화번호를 저장하는 map 객체 생성할거야
		 * <이름,전화번호> // "홍길동" , "010-1234-5678"
		 * 
		 */
		String[] names = {"홍길동","일지매", "성춘향","이몽룡"};
		String[] phones = {"010-1234-1234","010-0000-0000","010-3333-3333","010-4321-4321"};
		Map<String,String> phoneBook= new HashMap<>();
		for(int i = 0 ; i<names.length;i++) {
			phoneBook.put(names[i], phones[i]);
			
			
		}
		
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("친구이름");
			String name = input.nextLine();
			if(name.equals("")) break;
			String phone = phoneBook.get(name);
			System.out.println(name + " 의 전화번호는 " + phone  + " 입니다");
		}
	}
	

	public static void test1() {
		// static type 으로 해야지 객채 안만들고 바로 확인가능

		/*
		 * map 객체 HashMap 객체 맵은 KEY 와 VALUE의 쌍으로 저장하고 key 값을 통해 값을 인출한다.1 map - generic
		 * 인터페이스. 이를 구현한것이 HashMap, TreeMap , LinkedHashMap 클래스들은 제너릭 클래스라는 것입니다, 이 의미는
		 * 객체들을 생성할때 타입을 지정해줘야 한다.
		 * 
		 * 
		 * ArrayList<Integer> list = new ArrayList<>(); ArrayList<String> list = new
		 * ArrayList<>(); ArrayList<Student> list = new ArrayList<>();
		 * 
		 * 
		 * map 에 <학번, 학생객체> 이렇게 저장할 예정.
		 * 
		 */

		Map<String, makeStudent> map = new HashMap<>();

		map.put("20000101", new makeStudent(20000101, "홍길동"));
		map.put("20000102", new makeStudent(20000102, "일지매"));
		map.put("20000103", new makeStudent(20000103, "이몽룡"));
		map.put("20000104", new makeStudent(20000104, "성춘향"));
		map.put("20000105", new makeStudent(20000105, "정춘황"));

		// 키값 가져오기, 저장하기
		//get해야해!!
		
//		makeStudent value = map.get("20000103");
//		System.out.println(value.getName());	
//		
//		map.put("20000103", new makeStudent(20000103,"이순신"));
//		makeStudent value2 = map.get("20000103");
//		System.out.println(value2.getName());	

		/*
		 * map자료구조에 들어가는 모든 원소를을 다 읽을수 있는 방법은 1. map 에게 니가 가진 원소의 모든 key 집합을 요청 그 집합의 각
		 * 원소를 가지고 map 에게 값을 요청하는 방법
		 * 
		 * 2.map 에게 <key,value> 쌍으로 저장된 엔트리 집합을 요청해서 그 집합의 원소를 하나씩 읽는방법 (원소 - 키값)
		 */

		
		//1번
		
		map.keySet();
		Set<String> keyset = map.keySet();
		// key 의set이니 string

		keyset.iterator();
		Iterator<String> iter = keyset.iterator();

		while (iter.hasNext()) {
			String key = iter.next();
			
			//System.out.println(key);
			makeStudent val = map.get(key);
			System.out.println( val);
								//"key : " + key  + " value : " + val
		}

		
		//map 에서 엔트리라 함은 <key,value>의 쌍으로 구성된 객체
		//객체라 함은 이 개체를 정의하는 클래스가 있다는 의미.
		
		
		
		//2.entryset 하는것
		
		Set<Entry<String, makeStudent>> entryset = map.entrySet();
		Iterator<Entry<String, makeStudent>> eIter = entryset.iterator();
		while(eIter.hasNext()) {
			Entry<String, makeStudent>entryObj= eIter.next();  //<Entry<String, makeStudent>> 반환
			
			String key = entryObj.getKey();
			makeStudent val = entryObj.getValue();
			System.out.println(entryObj);
		}
		
		
		
	}

}

class makeStudent {
	
	@Override
	public String toString() {
		return ("[학번  : "+ hakbun + "  이름    :    "+ name + "]");
	}
	
	private int hakbun;
	private String name;

	public makeStudent(int hakbun, String name) {
		super();
		this.hakbun = hakbun;
		this.name = name;
	}

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

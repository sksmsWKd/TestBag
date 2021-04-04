import java.util.ArrayList;

public class MyArrayList1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<>(); // 제너릭은 primitive 지원안함. wrapper class인 integer넣어야함 .primitive 형태를
		// wrapper 클래스로 하는것 boxing

for (int i = 0; i < 30; i++) {
list.add(i);
}
System.out.println(list); // arraylist 는 길이가 가변적인 배열

list.add(3, 100); // 3번째에 300을넣고싶어요 만약 넣게되면 대채하는게 아니고 밀린다.

System.out.println(list);

list.remove(3); // 3번 인덱스를 지웠는데, 자리가 빈게아니고 자리를 당긴다.
list.remove(Integer.valueOf(100)); // 100의 값을 지운다. 자리는 당김.
System.out.println(list);

for (int i = 0; i < list.size(); i++) {
System.out.print(i + " ");

//System.out.print(list.get(i));
//..
	}

}
}

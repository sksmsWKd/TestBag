import java.util.*;

public class DequeTest {

	public static void main(String[] args) {
		
		/*
		 * Deque 는 인터페이스, 이것을 구현한클래스는 ArrayDeque 인터페이스의 인스턴스 생성은 x
		 */
		Queue<Integer> queue = new ArrayDeque<>(); // 앞에 integer 타입 써주면 뒤에 안써줘도 됨.
		/*
		 * Queue: a,b 메소드가 있다면, ArrayDeque : a,b,c,d,e 메소드 가능.
		 */
		// q.a() a.b() ->o
		// q.c() -> X
		// 이건 fifo 결과가 나옴

		// 1.큐에 임의의 수 10개 넣고,
		// 2.안에 어떤 순서로 들어가있는지 보고
		// 3.하나씩 인출해보자 . <- FIFO순으로 나오는지 확인.

		for (int i = 0; i < 10; i++)
			queue.add(i + 1);
		
		System.out.println(queue);
		//결과가 나옴
		
		//poll메소드로 하나씩 인출. FIFO순으로 나와야 한다.
		// 1,2,3,....,10 순서로
		// 큐에 원소가 있으면 인출하자
	
		
		
		while(queue.size()>0) {   //!queue.isEmpty()   도가능. 	queue.isEmpty() 는 원소있으면 false 없으면 true.  
			 Integer val=queue.poll();
			 System.out.print(val + ",");
			 //큐의 사이즈가 1씩 감소
			 Integer val2 = queue.remove();
			 System.out.println(val2);

		}
		

		System.out.println("큐의 상태" + queue);
		
	}// stack 도 가져오면 삭제가 됨.
		
}

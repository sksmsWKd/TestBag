import java.util.*;

public class PriorityQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}
	public static void test1() {
		Queue<String> q = new PriorityQueue<>();
		q.offer("pineapple");
		q.offer("Banana");
		q.offer("Carrot");
		q.offer("Cherry");
		q.offer("Strawberry");
		
		//엿보기 . 인출 아님.
		
		System.out.println(q.peek()); // q.element()
		System.out.println(q.peek());
		System.out.println(q.peek());
		System.out.println("#############");
		while(q.size() > 0) {
			System.out.print(q.poll()+" "); //remove
		}
		System.out.print(q.poll()+" ");
	}
}

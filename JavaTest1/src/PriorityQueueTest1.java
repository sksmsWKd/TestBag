import java.util.*;
import java.lang.*;

//4월 15일
public class PriorityQueueTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// test1();
		MyQueue mq = new MyQueue();
		mq.offer(new Task("작업1", 3));
		mq.offer(new Task("작업2", 2));
		mq.offer(new Task("작업3", 5));
		mq.offer(new Task("작업4", 1));
		mq.offer(new Task("작업5", 4));

		for (int i = 0; i < 5; i++) {
			System.out.println(mq.poll());
		}
	}

	public static void test1() {
		/*
		 * 우선순위큐 객체를 생성하고, task 인스턴스를 삽입,인출 해보자.
		 */
		// 우선순위큐는 기본적으로 오름차순으로 나옴.
		// Queue<Task> queue = new PriorityQueue<>(); //이게 compareable인터페이스implement 한것
		Queue<Task> queue = new PriorityQueue<>(new TaskComparator()); // 자기가 비교가능해도 임의로 주면 이거로 비교함.
																		// 임의로 만든 비교 메소드.
		queue.offer(new Task("작업1", 3));
		queue.offer(new Task("작업2", 2));
		queue.offer(new Task("작업3", 5));
		queue.offer(new Task("작업4", 1));
		queue.offer(new Task("작업5", 4));
		// 작업 41253 순서

		while (queue.isEmpty() == false) {
			Task task = queue.poll();

			System.out.println(task);
		}
	}
}

class Task implements Comparable<Task> { // task 인스턴스를 비교가능한 객체로 생성하기 위해 인터페이스 구현.
	String desc; // task 의 설명
	int priority = 5; // 이 task 의 우선순위

	public Task(String desc, int priority) { // 생성자. 초기화하기위해
		this.desc = desc;
		this.priority = priority;
	}

	@Override // object 클래스에 정의된 toString 클래스를 재정의하는 것
	public String toString() {
		return "[desc : " + desc + "]    [priority : " + priority + " ]";
	}

	@Override
	public int compareTo(Task o) {
		// 이 객체의 값이 크면 양수. 같으면 0. 작으면 음수를반환

		// return (-1) * (this.priority - o.priority); //반환값을 반대로
		return this.priority - o.priority; // 원래꺼임

	}
}

class TaskComparator implements Comparator<Task> { // comparator implement 안하고, 사용자가 직접 compare 하는 메소드 만듬
	@Override
	public int compare(Task o1, Task o2) {
		return o1.priority - o2.priority;
	}
}

class MyQueue {
	Task[] tasks = new Task[10];
	int idx = 0;
	int pidx = 0;

	public void offer(Task value) {
		tasks[idx++] = value;
		//새로운 객체가 들어올 때 마다 선택정렬로 sorting 한다.
		
		for(int i = idx-1 ; i >=0 ; i--) {
		int max = i;
			for (int j =0;j<i;j++) {
				if(tasks[i].compareTo(tasks[max])>0) {
					max = j;  //맥스가 그걸 가르키게함
				}
			}
			//max 와  i 를 swap
			Task tmp =tasks[max];
			tasks[max] = tasks[i];
			tasks[i] = tmp;
		}
	}

	public Task poll() {
		return tasks[pidx++];
	}
}

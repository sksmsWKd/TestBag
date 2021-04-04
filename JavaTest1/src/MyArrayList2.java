import java.util.*;

public class MyArrayList2<T>{//arraylist비슷하게 그냥 array로 구현.  와일드카드?제너릭?
	private Integer[] array;
	private int capacity = 15;
	private int size = 15;

	public MyArrayList2() {
		array = new Integer[capacity];
	}

	private void increaseCapacity() {
		// 수용가능하면 넣는다.

		// 수용할수없으면 array배열 길이를 늘려야함.

		capacity = capacity + capacity / 2;
		array = new Integer[capacity];
		Integer[] tmp = new Integer[capacity];
		// 원래 값을을 tmp로 복사
		// array 가 용량이 늘어난 배열을 가르치도록한다
		array = tmp;

		for (int i = 0; i < size; i++) {
			tmp[i] = array[i];
		} // 배열 복사

		array = tmp;

	}

	public void add(Integer value) {
		// 현재 용량으로추가되는 값을 수용할수있으면
		array[size++] = value; // 0을 반환. 하지만 값은 1 후위연산자다.

		if (size >= capacity) {
			increaseCapacity();

		}
		array[size++] = value;

	}

	public void add(int idx, Integer value) {
		// 용량이 이미 꽉차있으면 용량을 50%늘리고
		// 아래 코드를 실행한다.

		if (size == capacity) {
			// 용량을 늘린다.
			increaseCapacity();
		}
		for (int i = size - 1; i >= idx; i--) {
			array[i + 1] = array[i];
		} // 맨뒤에 있는 원소부터 오른쪽으로 한 칸씩 민다.
			// idx 자리에 value를 넣는다
		array[idx] = value;
		size++;
	}

	public void remove() {
		if(size >0 ) size--;
	}
	public void remove(int idx) {
		//여기완성해야해
	}
	public int size() {
		return size;
	}

	public Integer get(int idx) {
		return array[idx];
	}

	@Override
	public String toString() {
		// 자기가 가진 스트링 반환
		if (size == 0) {
			return "[]";
		}

		String result = "[";
		for (int i = 0; i < size; i++) {
			result += array[i] + ",";

		}
		result += "]";
		return result;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyArrayList2 list2 = new MyArrayList2();

		System.out.println(list2);
		for (int i = 0; i < list2.size(); i++) {
			System.out.print(i + " ");
		}

	}//.

}

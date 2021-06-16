import java.util.Arrays;

public class ArrayEverage {

	private int[] arr = new int[5];

	@Override
	public String toString() {
		return "ArrayEverage [arr=" + Arrays.toString(arr) + "]";
	}

	public ArrayEverage() {
		for (int i = 0; i < 5; i++) {
			arr[i] = i;
		}

	}

	void average(int[] arr) {
		int sum = 0;
		int temp = 0;
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			temp++;
		}
		result = sum / temp;
		
	}

	public static void main(String[] args) {

		ArrayEverage arr = new ArrayEverage();

		System.out.println(arr);
		//arr.average();
	}

}

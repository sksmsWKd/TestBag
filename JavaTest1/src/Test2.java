import java.util.ArrayList;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String[] array = {"동해","바다","고래" };
		
		ArrayList<String> array2 = new ArrayList<>();
		for(int i = 0 ; i<200 ; i++) {
			array2.add(" "+ i);
		}
		for(int i = 0; i<array2.size();i++) {
			System.out.println(array2.get(i));
		}
		ArrayList<Student> array3 = new ArrayList<>();
		for(int i = 0; i<100;i++) {
			System.out.println(array3.get(i));
		}
		
		//제너릭으로 배열 만들기.
	}

	
}

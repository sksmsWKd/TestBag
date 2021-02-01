package ch06;

public class RecMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Rectangle r1 = new Rectangle(20,20);
		Rectangle r2 = new Rectangle();

		
		if(r1.isSame(r2)) {
			System.out.println("같은 크기의 사갹형");
		}else {
			System.out.println("다ㅓ른크기");
		}
		
		System.out.println(r1);
		System.out.println(r2);
			
}
		
	}



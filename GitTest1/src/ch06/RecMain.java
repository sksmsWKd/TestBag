package ch06;

public class RecMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		Rectangle r1 = new Rectangle(20,20);
		Rectangle r2 = new Rectangle();

		
		if(r1.isSame(r2)) {
			System.out.println("���� ũ���� �簽��");
		}else {
			System.out.println("�٤ø�ũ��");
		}
		
		System.out.println(r1);
		System.out.println(r2);
			
}
		
	}



package ch06;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Employee2 em1 = new Employee2("ȫ�浿", 3000000);
		 Employee2 em2 = new Employee2("���ȯ", 4000000);
		 Employee2 em3 = new Employee2("�ö�Ҵ�" ,10000000);
		 
		 int n = Employee2.getCount();
		 System.out.println(n);
		 
		System.out.println(em1);
		System.out.println(em2);
		System.out.println(em3);
		 
		 
		 
	}

}

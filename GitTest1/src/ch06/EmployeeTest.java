package ch06;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 Employee2 em1 = new Employee2("È«±æµ¿", 3000000);
		 Employee2 em2 = new Employee2("±èµÎÈ¯", 4000000);
		 Employee2 em3 = new Employee2("½Ã¶ó¼Ò´Ï" ,10000000);
		 
		 int n = Employee2.getCount();
		 System.out.println(n);
		 
		System.out.println(em1);
		System.out.println(em2);
		System.out.println(em3);
		 
		 
		 
	}

}

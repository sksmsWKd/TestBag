package ch06;

public class Outerclass {
private int val;
public void test() {
	System.out.println("test...");
	
	class Localclass {
		public int mylocalVal;
	} // �̰Ű��ǾȾ� 
	
	Localclass lc = new Localclass();
	
	test2();
	
	
}

public void test2() {
	System.out.println("tes2...");
	InnerClass ic = new InnerClass();
	lc.setMyInnerVal(100);
	System.out.println(lc.setMyInnerVal());
}
public class InnerClass {
	private int myInnerVal;
	
}

public void setMyInnerVal(int val) {
	myInnerVal = val;
}


/*inner class -> ����� ����Ǵ� ��� Ŭ����?
				 ���� Ŭ���� (��ϸӽ�Ŭ����),gui,�ȵ���̵����α׷�
				 ����Ŭ����(����Ŭ����)

*/



}

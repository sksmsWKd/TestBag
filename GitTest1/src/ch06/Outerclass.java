package ch06;

public class Outerclass {
private int val;
public void test() {
	System.out.println("test...");
	
	class Localclass {
		public int mylocalVal;
	} // 이거거의안씀 
	
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


/*inner class -> 멤버로 선언되는 멤버 클래스?
				 무명 클래스 (어나니머스클래스),gui,안드로이드프로그렘
				 지역클래스(로컬클래스)

*/



}

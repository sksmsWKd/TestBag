package ch06;

public class OuterClassP295 {
	private int a;
	public int b;
	public String myMethod1;
	
	class InnerClass{
		
		public  myMethod()
		{
		System.out.print("my");
		System.out.print("dd");
		return 0;
	}
		
	
		}
	OuterClassP295(){
		InnerClass ic = new InnerClass();
		this.myMethod1 =ic.myMethod();
	
	
	}
}

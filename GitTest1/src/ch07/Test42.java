public class Test42
{
	static int a=0; //정적변수a의 초기값은 0이다.
	int b=0; //일반변수a의 초기값은 0이다.

	static
	{
		Test42.a=1;
		Test42.moveA(5); ////static이 아닌 일반변수나 메소드는 안에서 사용불가능
		System.out.println("처음에 위치한 static{ }입니다");
	}

	static void moveA(int x)
	{
		a=a+x;
		System.out.println("moveA 메소드입니다");
	}

	void moveB(int y)
	{
		b=b+y;
		System.out.println("moveB 메소드입니다");
	}

	static
	{
		Test42.a=2;
		Test42.moveA(8); ////static이 아닌 일반변수나 메소드는 안에서 사용불가능
		System.out.println("끝에 위치한 static{ }입니다");
	}

	public static void main(String[] args)
	{
		Test42.a=10; //정적변수는 객체생성없이 바로 사용가능
		a=10; //Test42. 생략가능
		System.out.println(Test42.a);
		System.out.println(a); //Test42. 생략가능
		Test42.moveA(1); //정적메소드도 객체생성없이 바로 사용가능
		moveA(1); //Test42. 생략가능
		System.out.println(Test42.a);
		System.out.println(a); //Test42. 생략가능

		System.out.println("=====1=====");

		Test42 t=new Test42();
		t.b=10; //일반변수는 위와같이 객체생성후에 사용가능
		System.out.println(t.b);
		t.moveB(1); //일반메소드도 객체생성후에 사용가능
		System.out.println(t.b);

		System.out.println("=====2=====");

		Test42 t1=new Test42(); //객체생성을 통해 t1인 인스턴스를 만듬.
		Test42 t2=new Test42(); //객체생성을 통해 t2인 인스턴스를 만듬.

		System.out.println(t1.a); //정적변수a는 자동으로 처음에 한번만 생성된다.
		System.out.println(t2.a);
		System.out.println(t1.b); //일반변수b는 객체생성시 매번 새로 생성된다.
		System.out.println(t2.b);

		System.out.println("=====3=====");

		t1.a=111;

		System.out.println(t1.a);
		System.out.println(t2.a); //정적변수a는 모든 객체가 값을 공유한다.

		t1.b=222;

		System.out.println(t1.b);
		System.out.println(t2.b); //일반변수b는 객체들끼리 값을 공유하지 않는다.
	}
}
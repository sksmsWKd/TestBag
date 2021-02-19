package ch10;

public class InterfacePerson implements InterfaceTest{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("나걷는다");
	}

	@Override
	public void walk() {
		// TODO Auto-generated method stub
		System.out.println("나기어간다");
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("나잔다");
	}

}

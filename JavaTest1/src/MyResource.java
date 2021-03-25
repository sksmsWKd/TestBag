
public class MyResource implements AutoCloseable{
	public MyResource() {
		System.out.println("MyResource 생성");
	}
	public int getValue() throws Exception{
		int random = (int)(Math.random()*2);
		if(random==0) {
			throw new OutOfResourcesException("자원 고갈");//exception 객체를 만들면 된다.  // 내가만든 exception 임 class 새로만들어야함
		}
		
		return (int)(Math.random()*100);
	}
	public void close() {
		System.out.println("close...");
	}
}

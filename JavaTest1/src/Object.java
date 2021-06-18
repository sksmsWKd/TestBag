
public class Object {

	private String name;
	private int age;

	public Object() {

	}

	public Object(String n, int a) {
		this.name = n;
		this.age = a;
	}

	void reName(Object obj2) {
		obj2.name = "바뀐이름";
		this.name = obj2.name;
		obj2.age = 30;
		this.age = obj2.age;
	}

	@Override
	public String toString() {
		return "Object [name=" + name + ", age=" + age + "]";
	}

	public static void main(String[] args) {

		Object obj = new Object("이름", 20);
		Object obj2 = new Object();

		System.out.println("obj1 : " + obj);
		System.out.println("obj2 가 바뀌기 전 : " + obj2);
		obj2.reName(obj2);
		System.out.println("obj2 가 바뀐후 : " + obj2);
	}
}

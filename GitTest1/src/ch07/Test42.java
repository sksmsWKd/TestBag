public class Test42
{
	static int a=0; //��������a�� �ʱⰪ�� 0�̴�.
	int b=0; //�Ϲݺ���a�� �ʱⰪ�� 0�̴�.

	static
	{
		Test42.a=1;
		Test42.moveA(5); ////static�� �ƴ� �Ϲݺ����� �޼ҵ�� �ȿ��� ���Ұ���
		System.out.println("ó���� ��ġ�� static{ }�Դϴ�");
	}

	static void moveA(int x)
	{
		a=a+x;
		System.out.println("moveA �޼ҵ��Դϴ�");
	}

	void moveB(int y)
	{
		b=b+y;
		System.out.println("moveB �޼ҵ��Դϴ�");
	}

	static
	{
		Test42.a=2;
		Test42.moveA(8); ////static�� �ƴ� �Ϲݺ����� �޼ҵ�� �ȿ��� ���Ұ���
		System.out.println("���� ��ġ�� static{ }�Դϴ�");
	}

	public static void main(String[] args)
	{
		Test42.a=10; //���������� ��ü�������� �ٷ� ��밡��
		a=10; //Test42. ��������
		System.out.println(Test42.a);
		System.out.println(a); //Test42. ��������
		Test42.moveA(1); //�����޼ҵ嵵 ��ü�������� �ٷ� ��밡��
		moveA(1); //Test42. ��������
		System.out.println(Test42.a);
		System.out.println(a); //Test42. ��������

		System.out.println("=====1=====");

		Test42 t=new Test42();
		t.b=10; //�Ϲݺ����� ���Ͱ��� ��ü�����Ŀ� ��밡��
		System.out.println(t.b);
		t.moveB(1); //�Ϲݸ޼ҵ嵵 ��ü�����Ŀ� ��밡��
		System.out.println(t.b);

		System.out.println("=====2=====");

		Test42 t1=new Test42(); //��ü������ ���� t1�� �ν��Ͻ��� ����.
		Test42 t2=new Test42(); //��ü������ ���� t2�� �ν��Ͻ��� ����.

		System.out.println(t1.a); //��������a�� �ڵ����� ó���� �ѹ��� �����ȴ�.
		System.out.println(t2.a);
		System.out.println(t1.b); //�Ϲݺ���b�� ��ü������ �Ź� ���� �����ȴ�.
		System.out.println(t2.b);

		System.out.println("=====3=====");

		t1.a=111;

		System.out.println(t1.a);
		System.out.println(t2.a); //��������a�� ��� ��ü�� ���� �����Ѵ�.

		t1.b=222;

		System.out.println(t1.b);
		System.out.println(t2.b); //�Ϲݺ���b�� ��ü�鳢�� ���� �������� �ʴ´�.
	}
}
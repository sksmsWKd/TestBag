package ch06;

public class Date {
private int year;
private int month;
private int day;

public Date(int year, int month, int day) {
	//��ȿ�� ������ ��ũ..��ȿ�Ѱ��ΰ�� ���� ���� ����
	this.year = year;
	this.month = month;
	this.day = day;
}

@Override
public String toString() {
	return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
}

public Date() {
	this(1900,1,1);
}
public Date(int year) {
	this(year,1,1);
	this.year = year;   //-> �������ڸ��鶧�̰������� �̰ԾƷ���.

}

}

package ch06;

public class Date {
private int year;
private int month;
private int day;

public Date(int year, int month, int day) {
	//유효한 값인지 ㅊ크..유효한값인경우 한해 설정 ㄱㄴ
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
	this.year = year;   //-> 윗생성자만들때이거있으면 이게아래로.

}

}

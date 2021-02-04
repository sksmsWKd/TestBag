package ch06;

public class Employee2 {
private String name;
private double salary;
private static int count;

public Employee2(String n , double s) {
	this.name = n;
	this.salary = s;
	count ++;
}

@Override
public String toString() {
	return "Employee2 [name=" + name + ", salary=" + salary + "]";
}

protected void finalize() {
	count--;
}
public static int getCount() {
	return count;
}



}

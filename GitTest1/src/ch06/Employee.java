package ch06;

public class Employee {
private int sid;
private String name;
private static String ceo;

public Employee(int sid, String name) {
	this.sid = sid;
	this.name = name;
	
}

public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public static String getCeo() {
	return ceo;
}
public static void setCeo(String myceo) {
	ceo = myceo;
}

@Override
public String toString() {
	return "Employee [sid=" + sid + ", name=" + name + ", ceo=" + ceo + "]";
}
}

//Ω««‡¿∫ main.java

package ch06;

public class Box {
	//instance member variable
private int width;
private int length;
private int height;
private int volume;

public Box() {
	this(2,2,2,8);
}
public Box(int width, int length, int height, int volume)
{
this.width = width;
this.length = length;
this.height = height;
this.volume = width*length*height;
}
public boolean isSameBox(Box box) {
	boolean result = false;
	return result;
}
public String toString() {
	return "상자 밑변의 가로 : " + width + ", 세로 : "+length+"높이:"+height+",부피 : "+volume;
}
}

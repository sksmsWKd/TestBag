package ch06;

public class Rectangle {
	private int width;
	private int length;
	
	public Rectangle(){
		this(10,10);	
	}
	
	public boolean isSame(Rectangle re) {
		boolean result = false;
		if( this.width ==re.width&&this.length ==re.length) {
			result = true;
		}return result;
	}
	
	
	
	
public Rectangle (int width, int length) {
this.width = width;
this.length = length;
}

@Override
public String toString() {
	return "Rectangle [width=" + width + ", length=" + length + "]";
}




	
}

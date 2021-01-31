package ch06;

public class Time {
private int hour;
private int minute;
private int second;



public Time(int hour, int minute, int second) {
	this.hour=hour;
	this.minute = minute;
	this.second = second;
	
	if(this.hour >=0 && this.hour<= 23){
		this.hour =hour;
	}else {
		this.hour = 0;
	}
	

	if(this.minute >=0 && this.minute<= 59){
		this.minute =minute;
	}else {
		this.minute = 0;
	}
	
	if(this.second >=0 && this.second<= 59){
		this.second =second;
	}else {
		this.second = 0;
	}
	
}


@Override
public String toString() {
	return String.format("%02d:%02d:%02d",hour , minute,second);
}

public Time(){
	this(0,0,0);
}

}


public class Date {

	private int year;
	private int month;
	private int day;

	
	public Date() {
		this(0,0,0);
	}
	
	public Date(int year, int month) {
		this.year=year;
		this.month = month;
	}
	
	public Date(int year, int month, int day){
		this.year= year;
		this.month = month;
		this.day = day;
	}

	@Override
	public String toString() {
		return "Date [year=" + year + ", month=" + month + ", day=" + day + "]";
	}
	
	
	public static void main(String[] args) {
		Date date1 = new Date();
		Date date2 =  new Date(1999,04,10);
		Date date3 = new Date(1,1);
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
	}
}


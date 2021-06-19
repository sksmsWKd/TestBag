package ch11;

public class SubStringTest {
	public static void main(String[]args) {
		String s = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세"; //백두산을 뽑고싶어요 
		for (int i = 0; i< s.length();i++) {
			System.out.print(s.charAt(i)+" "); // 문자 하나 리턴
		}
		int index = s.indexOf("백두산"); //백두산이라는 글자가 시작하는 첫번째 인덱스가 어디인가요?
		System.out.println(index);
		
		String subs= s.substring(index);  //substring 은 문자열 출력
		System.out.println(subs);
		String subs2 = s.substring(index, index+"백두산".length());
		System.out.println(subs2);
		String subs3 = s.substring(index, index+3);
		System.out.println(subs3);
		System.out.println(index);
		String subs4 = s.substring(index+"백두산".length(), s.indexOf("만세"));
		System.out.println(subs4);
	}
}

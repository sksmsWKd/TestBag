//4/19
//StringTokenizer 클래스 사용

import java.util.*;
public class StackTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "apple, banana, carrot, pineapple, grape, mango, strawberry, watermelon, melon, orange, coconut, kiwi, lemon, tomato, cherry, blueberry, peach, cramberry, raspberry";
		
		//이 문자열을 잘라봅시다
		
		
		
        //		String s = str.substring(0,"apple".length());
        //		System.out.println(s);
		// 너무 귀찮다.
		
		
		//공백문자를 기준으로 하나씩 잘라주세요.
		/*
		 * 구분자를 입력으로주고, 그 구분자(delemeter)로 구분되는
		 * 문자열들을 하나씩 뽑아 쓸수 있게 해주는
		 * java util 패키지의 클래스가 뭐냐 하면
		 * StringTokenizer
		 */
		
		StringTokenizer st = new StringTokenizer(str,(", "));
		// 두번째 인수 안주면 구분자임 공백
		
		String s = st.nextToken();
		System.out.println(s);
		System.out.println("남은 수" + st.countTokens());
		
		// 토큰을 다 찍어 보는 방법 1
		// 토큰의 수만큼 for 문 돌기
		
		// 토큰을 다 찍어 보는 방법 2
		// 아직 나에게 줄 토큰이 남아있는지 물어보고,
		// 있으면 nextToken()메소드를 호출해서 하나씩 받아서 사용하기
		// 주로 2번째방법 사용
		
		System.out.println(st.hasMoreTokens());  // 남아있는지?
		
		
		while(st.hasMoreTokens()) {
			String token =  st.nextToken();
			System.out.print("[" + token + "]");
		}
	}

}

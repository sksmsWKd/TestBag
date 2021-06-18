// 04/22
import java.util.*;
public class StackBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* ()  중에 (를 스택에넣고 
		 *      ) 를 만나면 pop 해서 빼고
		 *      주어진 식을 다 처리했을때, empty 됨
		 *    	  만약 empty 가 아니면 잘못된 식이다.
		 *    ((( )) 처리후에 스택이 empty 가 아니게됨.
		 *    (( ) pop 했을때 인출되는 원소가 있어야하는데 없는경우. 잘못된경우이다.
		 *    
		 *    2 * ( 3 + 2 ) / ( 3 + 1 ) / 2 * 5 – 1 + 10  
		 *    
		 *    ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 *    1. 먼저 수식을 입력 받자.
		 *    scanner 객체가 필요
		 */
		
		Scanner input = new Scanner(System.in);    //콘솔 입력을 위한 Scanner 객체생성
		System.out.println("수식을입력하세요");
		String exp = input.nextLine();  
		
		// 2. 입력받은 수식을 공백을 기준으로 문자열 token 으로 분리하자
		
		StringTokenizer st = new StringTokenizer(exp);     // 두번째 인자 안주면 공백이 구분자
		
		//exp 문자열  변수에 값을 공백을 기준으로 문자열 토큰들로 분리
		
		// 3. 토큰을 하나씩 뜯어 보면서 여는 괄호이면 Stack 에 push , 닫는 괄호이면 Stack 에서 pop 
		
		Stack<String> stack = new Stack<>();
		
		while(st.hasMoreTokens())  {  //아직 토큰 남았니?
			String token = st.nextToken();
			//token 이 여는괄호이면 stack 에 push
			if(token.equals("(")) stack.push(")");
			
			
			//token 이 닫는괄호이면 stack 에 pop
			else if(token.equals(")")) {
				// 근데 stack 에 원소가 하나도 없다면 
				// 이거는 닫는 괄호에 매칭되는 여는 괄호가 없다는 이유니깐
				// 이것은 잘못된 식이지... 더이상 다른 토큰 볼 필요도 없다
			 if(stack.isEmpty()) {
				 System.out.println("잘못된 식입니다");
				 return;
				 
				 
			 }
		
			}
		}
		
		
		// 흐름이 여기까지 왔다는 것은 , 식에 잘못된 겂이 없거나, 또는 여는 괄호가 더 많은 경우
		//
		// 모든 토큰 처리가 끝났고 , 그 때까지 잘못된 괄호가 별견되지 않았다
		
		if(stack.isEmpty() !=true) {
			System.out.println("잘못된식");
			return ;   //main이 void
		}
		System.out.println("유효한 식");
		
	}

}

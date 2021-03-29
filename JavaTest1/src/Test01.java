import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("날짜를 입력하세요");
		int date = input.nextInt();

		assert (date >= 1 && date <= 31) : "잘못된 날짜 : " + date; // Assertion은 불린 식을 포함하고 있는 문장으로서, 프로그래머는 그 문장이 실행될 경우 불린
																// 식이 참
		// enableassention 옵션을 줘야함
		System.out.printf("입력된 날자는 %d입니다.\n", date);
	}

}

package workshop1.primenumber;

import java.util.Scanner;

public class ExercisePrimeNumber {
	
	// Scanner 이용해서 사용자 값을 입력받아서 전달.
	// static : 클래스 소유, 인스턴스 생성없이 사용 가능.
	public static int getUserInput() {
		int result = 0;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요 :");
		result = scan.nextInt();
		return result;
	}
}

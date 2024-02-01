package workshop1.guessgame;

import java.util.Scanner;

public class GuessGame {
	
	public static int getUserInput() {
		
		int result = 0;
		
		Scanner scan = new Scanner(System.in);
		result = scan.nextInt();
		
		return result;
	}

}

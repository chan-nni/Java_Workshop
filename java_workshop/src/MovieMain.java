import java.util.Scanner;

import workshop7.movie.guessgame.MovieServiceImpl;

public class MovieMain {

	public static void main(String[] args) {
		MovieServiceImpl service = new MovieServiceImpl();
		String selectedSentence = service.selectSentence();
		System.out.println(" selectedSentence >>> " + selectedSentence);
		String str = service.initGame(selectedSentence);
		
		StringBuffer solving = new StringBuffer(str);
		
		// 게임 진행 로직 추가
		Scanner scan = new Scanner(System.in);
		int count = 5;
		boolean guessedAll = false; // 모든 글자를 맞췄는지 여부를 나타내는 변수
		
		System.out.println("[남은 기회] : " + count);
		
		while (count > 0 && !guessedAll) { // 모든 글자를 맞추었거나 기회가 남았을 때까지 반복
			System.out.println("한 글자씩 입력하세요 :");
			String input = scan.nextLine();
			boolean found = service.checkString(selectedSentence, solving, input);
			if (!found && input.matches("[a-zA-Z]")) { // 입력된 글자가 올바르지 않고 알파벳인 경우에만 실행
				count--; // 남은 기회를 감소
				System.out.println("해당 글자가 없습니다.");
			}
			System.out.println(solving); // 해결된 문제를 출력
			System.out.println("[남은 기회] : " + count);
			
			// 모든 글자를 맞췄을 때
			guessedAll = true; // 기본적으로 모든 글자를 맞춘 것으로 설정
			for (int i = 0; i < solving.length(); i++) { // 해결된 문제를 확인하고 모든 글자가 맞았는지 확인 
				if(solving.charAt(i) == '\u25A1') { // 아직 맞추지 않은 글자가 있는 경우에만 실행
					guessedAll = false; // 모든 글자를 맞추지 않은 것으로 설정
					break;
				}
			}
		}
		
		if (guessedAll) { // 모든 글자를 맞췄는지 확인
            System.out.println("축하합니다.");
        } else {
            System.out.println("틀린 기회를 모두 소진했습니다. 게임 오버!");
        }
	}

}

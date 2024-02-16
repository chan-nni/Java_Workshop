package workshop7.movie.guessgame;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MovieServiceImpl {

	private static final PrintStream solvingSentence = null;

	// 워크샵 7번에 제공되는 영화 제목 스트링 배열
    private String[] sentenceDictionary = { "Matrix",
            "I know what you did last summer", "The Silence Of The Lambs",
            "Saving Private Ryan", "Black Hawk Down", "American Pie",
            "Enemy Of The State" };
    
    private ArrayList<String> lst = null;
    
    public MovieServiceImpl() {
    	lst = new ArrayList<String>(Arrays.asList(sentenceDictionary));
	}
    
	/*
	 * 임의의 영화 제목 반환
	 * Random(nextInt() )
	*/
    public String selectSentence() {
    	Random random = new Random();
    	int randomIdx = random.nextInt(sentenceDictionary.length);
    	return sentenceDictionary[randomIdx];
    }
    
	/*
	 * 게임의 초기화 화면을 출력하고 숨겨진 영화제목 반환
	*/
    public String initGame(String selectedSentence) {
    	System.out.println(" ========================================= ");
    	System.out.println(" 영화 제목을 맞춰 보세요...... ");
    	System.out.println(" 5번 까지 틀릴 수 있는 기회가 있습니다. ");
    	System.out.println(" ========================================= ");
    	
    	// 문자열을 동적으로 조작하기 위해서 StringBuffer를 사용한다.
    	// StringBuffer는 가변성을 가지고 있어 문자열을 효율적으로 조작할 수 있다.
    	// 변환된 영화 제목을 담을 StringBuffer 객체 생성
    	StringBuffer solvingSentence = new StringBuffer();
    	
    	// 영화 제목의 각 문자를 검사하여 변환
    	for (int i = 0; i < selectedSentence.length(); i++) {
    		char currentChar = selectedSentence.charAt(i);
    		
    		if (currentChar == ' ') {
    			solvingSentence.append(' ');
    		} else { // 공백이 아닌 경우 □ 으로 변환
    			solvingSentence.append('\u25A1'); // solvingSentence 문자열에 '□' 문자를 추가하는 것
    		}
    	}
    	
    	System.out.println(solvingSentence.toString()); // solvingSentence 문자열을 콘솔에 출력하는 코드
  
    	return solvingSentence.toString();
    }
    
	/*
	 * Scanner, BufferedReader
	 * 사용자로부터 한 문자를 입력받아서 반환
	*/
    public String getOneLetter() {
    	Scanner scan = new Scanner(System.in);
    	System.out.println("한 글자를 입력하세요 : ");
    	String letter = scan.nextLine();
    	
    	if(letter.length() > 0) {
    		return String.valueOf(letter.charAt(0)); // 입력받은 문자열 letter에서 첫 번째 문자를 추출하여 그 문자를 문자열로 변환하는 코드
    	} else {
    		return ""; // 입력받은 문자열이 없으면 빈 문자열 반환
    	}
    }
    
	/*
	 * 영화 제목에서 입력받은 문자를 정답으로 변경하고 찾았는지 여부를 반환
	 * @param String 영화 제목
	 * @param String 문제 풀이중인 영화제목
	 * @param String 사용자가 입력한 한 문자
	*/
    public boolean checkString( String selectedSentence, StringBuffer solvingSentence, String letter) {
    	// 대소문자를 구분하지 않기 위해 입력 문자열과 선택된 문장을 모두 소문자로 변환
    	String lowerCaseSelected = selectedSentence.toLowerCase(); //toLowerCase() 메서드는 문자열의 모든 문자를 소문자로 변환하는 메서드
    	String lowerCaseLetter = letter.toLowerCase();
    	
    	// 사용자가 입력한 문자가 선택된 문장에 존재하는지 확인
    	boolean found = false;
    	for(int i = 0; i < lowerCaseSelected.length(); i++) {
    		// 시용자가 입력한 문자를 발견하면 해결 중인 문장에서 해당 위치의 문자를 변경
    		if (lowerCaseSelected.charAt(i) == lowerCaseLetter.charAt(0)) {
    			solvingSentence.setCharAt(i, letter.charAt(0));
    			found = true;
    		}
    	}
    	return found;
    }
}

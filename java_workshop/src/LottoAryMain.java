import workshop3.lotto.exercise.ExerciseLotto;

public class LottoAryMain {

	public static void main(String[] args) {
		ExerciseLotto lotto = new ExerciseLotto();
		
		// Mission 01.
		int [] ary = lotto.generateLottoNumbers() ;
		/*
		for(int idx = 0 ; idx < ary.length ; idx++) {
			System.out.print(ary[idx]+" "); 
		}
		*/
		lotto.displayLottoNumbers(ary) ; 
		
		
		
	}

}

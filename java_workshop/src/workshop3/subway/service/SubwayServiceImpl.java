package workshop3.subway.service;

import workshop3.subway.entity.CardDTO;
import workshop3.subway.entity.StationDTO;

/*
 * 인터페이스를 참조하고 있는 클래스는 전부 Impl가 붙는다.
*/
public class SubwayServiceImpl implements SubwayService {
	
	public static final int BASIC_FEE = 800;

	@Override
	public int chargeFree(CardDTO card, StationDTO start, StationDTO end) {
		int fee = 0;
		int distance = getDistance(start, end);
		System.out.println("distance : " + distance);
		// 거리 계산
		if(distance <= 12) {
			fee = BASIC_FEE;
		} else if(distance > 12 && distance <= 42) {
			fee = BASIC_FEE + ( ((distance - 12 - 1) / 6) + 1 ) * 100;
		} else {
			fee = BASIC_FEE + (5 * 100) + (((distance - 42 -1) / 12) + 1) * 100;
			// fee = BASIC_FEE + 500; // 42km 초과 시 기본료 + 500원
			/*
			 * int extraDistance = distance - 42; // 42km를 초과하는 부분의 거리 계산 int extraFee =
			 * (extraDistance / 12) * 100; // 초과 거리에 대한 추가 요금 계산 if (extraDistance % 12 !=
			 * 0) { extraFee += 100; // 12km 단위로 나머지 거리에 대한 추가 요금 계산 } else if (distance ==
			 * 55) { fee += 1500; } fee += extraFee; // 추가 요금 추가
			 */            
		}
		// 요금 차감
		if(subtracBalance(card, fee)) {
			return fee;
		} else {
			return -1;
		}
	}

	@Override
	public boolean subtracBalance(CardDTO card, int amount) {
		int currentBalance = card.getBalance() - amount ;
		if(currentBalance >= 0) {
			card.setBalance(currentBalance);
			return true;
		}
		return false;
	}

	@Override
	public int getDistance(StationDTO start, StationDTO end) {
		
		return Math.abs(start.getLocation() - end.getLocation());
	}

}

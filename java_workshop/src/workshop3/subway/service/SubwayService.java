package workshop3.subway.service;

import workshop3.subway.entity.CardDTO;
import workshop3.subway.entity.StationDTO;

public interface SubwayService {
	// 1. 상수(constance) 선언
	// public int x = 10;
	
	// 운행요금을 반환하는 메서드(잔액 부족할 경우 -1 )
	// CardDTO card : 소유카드(충전), StationDTO start : 출발역, StationDTO end : 종착역
	public int chargeFree(CardDTO card, StationDTO start, StationDTO end);
	
	// 카드요금을 차감하는 메서드
	// 차감이 성공하면 true, 실패하면 false
	public boolean subtracBalance(CardDTO card, int amount);
	
	// 출발역과 종착역 사이의 거리 계산
	// 역 간의 거리를 반환하는 메서드
	public int getDistance(StationDTO start, StationDTO end);
	
	

}

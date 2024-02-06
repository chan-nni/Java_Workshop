package workshop3.subway.view;

import java.util.Scanner;

import workshop3.subway.entity.CardDTO;
import workshop3.subway.entity.StationDTO;
import workshop3.subway.service.SubwayService;
import workshop3.subway.service.SubwayServiceImpl;

public class SubwayView {
	
	private SubwayService service;
	
	private CardDTO card;
	
	private StationDTO [] stations;
	
	public SubwayView() {
		stations = new StationDTO[] {
				new StationDTO("A1105", "합정", 0),
				new StationDTO("A1106", "홍대입구", 10),
				new StationDTO("A1107", "신촌", 15),
				new StationDTO("A1108", "이대", 20),
				new StationDTO("A1109", "아현", 30),
				new StationDTO("A1110", "충정로", 35),
				new StationDTO("A1111", "시청", 40),
				new StationDTO("A1112", "을지로입구", 50),
				new StationDTO("A1113", "을지로3가", 58),
				new StationDTO("A1114", "을지로4가", 67),
				new StationDTO("A1115", "동대문운동장", 77)
		};
		
		service = new SubwayServiceImpl();
	}
	
	public void menu() {
		System.out.print("[교통카드 충전금액을 입력하세요] : ");
		card = new CardDTO(getUserInput());
	
		// int strIdx = selectNumber(stations, "승차");
		
		// 승차역 정보 출력 및 선택
		printStationList(stations);
		StationDTO startStation = stations[selectNumber(stations, "승차")];
		
		// 하차역 정보 출력 및 선택
		printStationList(stations);
		StationDTO endStation = stations[selectNumber(stations, "하차")];
		
		int chargedFee = service.chargeFree(card, startStation, endStation);
		
		System.out.println("chargedFee : " + chargedFee);
		if(chargedFee >= 0) {
			printSuccess(card, startStation, endStation, chargedFee);
		} else {
			printFail();
		}
	}
	
	// 역 정보 출력
	public void printStationList(StationDTO [] stations) { // 역 정보를 출력하면 배열을 넘겨줌
		System.out.println("===============================");
		for(int idx = 0; idx < stations.length; idx++) {
			System.out.println(idx+1 + ". " + stations[idx].getName());
		}
		System.out.println("===============================");
		
	}

	/*
	 @ params card 	: 소유카드
	 @ params start : 출발역
	 @ params end 	: 출발역
	 @ params chargedFee : 요금
	 요금 정산 성공 메시지를 출력
	*/
	public void printSuccess(CardDTO card, StationDTO start, StationDTO end, int chargedFee) {
		System.out.println("정상 처리되었습니다.");
		System.out.println("승차역은 " + start.getName() + "역이고 하차역은" + end.getName() );
		System.out.println("요금은" + chargedFee + "원이며, 잔액은" + card.getBalance() + "원 입니다.");
	}
	
	// 요금 정산 실패 메시지를 출력
	public void printFail() {
		System.out.println("잔액이 부족합니다.");
		System.out.println("직원에게 문의하세요.");
		
	}

	/**
	역 선택 메서드
	@params station 역 정보를 담는 배열
	@params msg 	출력메시지
	
	*/
	public int selectNumber(StationDTO [] station, String msg) {
		printStationList(station);
		System.out.println(msg + "역을 선택하세요. 1 ~ " + stations.length + " : ");
		int stationNum = getUserInput();
		return stationNum - 1;
		
	}
	/**
	Scanner 이용해서 입력받은 값을 처리하는 메서드 
	*/
	public int getUserInput() {
		Scanner scan = new Scanner(System.in);
		return  scan.nextInt();
	}
	
	
	
}

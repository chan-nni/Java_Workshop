package workshop3.subway.entity;

/*
 * 카드 정보를 담는 DTO
*/
public class CardDTO {
	
	private int balance ;

	public CardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardDTO(int balance) {
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "CardDTO [balance=" + balance + "]";
	}
	
	

}

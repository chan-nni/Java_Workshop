package workshop2.bank.entity;

public class Account {
	
	String custId;
	String custName;
	String accountNumber;
	int balance; 

	public Account() {
		super();
	}

	public Account(String custId, String custName, String accountNumber, int balance) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	// 잔액을 증가시키는 메소드
	public void addBalance(int amount) {
        this.balance += amount;
    }

    // 잔액을 감소시키는 메소드
    public void subtractBalance(int amount) {
    	
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("잔액 부족으로 인해 감소할 수 없습니다.");
        }
    }

}

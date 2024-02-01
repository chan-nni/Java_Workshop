package workshop2.bank.exercise;

import workshop2.bank.entity.Account;

public class ExerciseAccount {

    public static void main(String[] args) {
        // Account 객체를 생성한다.
    	Account account = new Account("CUST01", "소지섭", "1-22-333", 100000);

        System.out.println("=======================");
        System.out.println("고객번호: " + account.getCustId());
        System.out.println("고객명: " + account.getCustName());
        System.out.println("계좌번호: " + account.getAccountNumber());
        System.out.println("잔액: " + account.getBalance());
        System.out.println("=======================");
        
        // 잔액 증가ㄴ
        System.out.println(10000 +"원을 입금합니다.");
        account.addBalance(10000);
        System.out.println("증가 후 잔액: " + account.getBalance() + "원");

        // 잔액 감소
        System.out.println(20000 + "원을 출금합니다.");
        account.subtractBalance(20000);
        System.out.println("감소 후 잔액: " + account.getBalance() + "원");

    }
}

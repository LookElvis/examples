package Common.ThreadTest;

/**
 * Created by liuxiang on 2019/4/23.
 */
public class ThreadAccount {
    private String accountNo;
    private double balance;
    public ThreadAccount(String accountNo,double balance){
        this.accountNo=accountNo;
        this.balance=balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ThreadAccount account = (ThreadAccount) o;

        return accountNo.equals(account.accountNo);

    }

    @Override
    public int hashCode() {
        return accountNo.hashCode();
    }
}

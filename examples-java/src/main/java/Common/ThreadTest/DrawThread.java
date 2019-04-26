package Common.ThreadTest;

/**
 * Created by liuxiang on 2019/4/23.
 */
public class DrawThread extends Thread {
    private ThreadAccount account;
    private double drawAmount;

    public DrawThread(String name, ThreadAccount account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    public void run(){
        synchronized (account){
            if(account.getBalance()>=drawAmount){
                System.out.println(getName() + "取钱成功，吐出钞票： " + drawAmount);
                try{
                    Thread.sleep(100);
                }catch(InterruptedException ex){
                    ex.getStackTrace();
                }
                account.setBalance(account.getBalance()-drawAmount);
                System.out.println("\t余额为："+account.getBalance());
            }else{
                System.out.println(getName()+"取钱失败，余额不足");
            }
            System.out.println(getName() + System.currentTimeMillis());
        }
    }
}


package Common.DesignTest;

/**
 * Created by Elvis on 2020/1/13.
 */
public class Singleton {
    private volatile static Singleton instance = null;  // 1

    private Singleton() {  // 2

    }

    public static Singleton getInstance() {  // 3
        if (instance == null) {  // 4
            synchronized (Singleton.class) {  // 5
                if (instance == null) {  // 6
                    instance = new Singleton(); // 7
                }
            }
        }
        return instance;  //8
    }
}



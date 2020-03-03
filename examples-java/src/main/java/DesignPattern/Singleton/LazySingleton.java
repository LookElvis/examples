package DesignPattern.Singleton;

/**
 * Created by Elvis on 2020/1/13.
 */
public class LazySingleton {
    private volatile static LazySingleton instance = null;  // 1

    private LazySingleton() {  // 2

    }

    public static LazySingleton getInstance() {  // 3
        if (instance == null) {  // 4
            synchronized (LazySingleton.class) {  // 5
                if (instance == null) {  // 6
                    instance = new LazySingleton(); // 7
                }
            }
        }
        return instance;  //8
    }
}



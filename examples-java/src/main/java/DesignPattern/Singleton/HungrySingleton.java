package DesignPattern.Singleton;

/**
 * Created by Elvis on 2020/2/11.
 */
public class HungrySingleton {
    public static int STATUS = 1;
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {

    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}

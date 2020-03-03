package DesignPattern.Singleton;

/**
 * Created by Elvis on 2020/2/11.
 */
public class StaticSingleton {
    private static class SingletonHolder {
        private static StaticSingleton instance = new StaticSingleton();
    }

    private StaticSingleton() {

    }

    public static StaticSingleton getInstance() {
        return SingletonHolder.instance;
    }
}

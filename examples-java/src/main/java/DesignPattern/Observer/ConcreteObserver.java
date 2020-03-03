package DesignPattern.Observer;

/**
 * Created by Elvis on 2020/3/3.
 */
public class ConcreteObserver implements Observer{
    @Override
    public void Update() {
        System.out.println("Update");
    }
}

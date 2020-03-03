package DesignPattern.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elvis on 2020/3/3.
 */
public class ConcreteSubject implements Subject{
    List<Observer> list = new ArrayList<>();
    @Override
    public void Attach(Observer observer) {
        list.add(observer);
    }

    @Override
    public void Detach(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void Notify() {
        for (Observer observer: list) {
            observer.Update();
        }
    }
}

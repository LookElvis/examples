package DesignPattern.Observer;

/**
 * Created by Elvis on 2020/3/3.
 */
public class Client {
    public static void main(String[] args) {
        Observer ob1 = new ConcreteObserver();
        Observer ob2 = new ConcreteObserver();
        Observer ob3 = new ConcreteObserver();
        Subject subject = new ConcreteSubject();
        subject.Add(ob1);
        subject.Add(ob2);
        subject.Add(ob3);
        subject.Notify();
        subject.Remove(ob2);
        subject.Notify();
    }
}

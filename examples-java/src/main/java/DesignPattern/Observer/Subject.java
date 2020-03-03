package DesignPattern.Observer;

/**
 * Created by Elvis on 2020/3/3.
 */
public interface Subject {
    void Attach(Observer observer);
    void Detach(Observer observer);
    void Notify();
}
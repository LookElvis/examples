package DesignPattern.Observer;

/**
 * Created by Elvis on 2020/3/3.
 */
public interface Subject {
    void Add(Observer observer);
    void Remove(Observer observer);
    void Notify();
}

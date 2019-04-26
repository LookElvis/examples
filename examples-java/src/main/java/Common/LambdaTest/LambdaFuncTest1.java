package Common.LambdaTest;

import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

/**
 * Created by liuxiang on 2019/4/9.
 */
public class LambdaFuncTest1 {
    @FunctionalInterface
    public interface People {
        void eat();
    }

    public static void main(String[] args) {
        People people = ()-> System.out.println("吃东西");
        people.eat();
    }
}

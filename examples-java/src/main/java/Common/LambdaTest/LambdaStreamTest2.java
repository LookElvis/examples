package Common.LambdaTest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by liuxiang on 2019/4/9.
 */
public class LambdaStreamTest2 {
    public static void main(String[] args) {
        Stream.of(-3, - 5, -2, -8, -6, 3, 2, 7, 5)
                .parallel()
                .filter(num -> num >= -5)
                .map(t -> ((t - 3) * (t + 3)))
                .sorted()
                .limit(10)
                .forEach(System.out::println);
    }
}
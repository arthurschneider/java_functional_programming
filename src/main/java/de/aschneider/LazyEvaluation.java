package de.aschneider;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class LazyEvaluation {

    public static void main(String[] args) {

        evaluation(2, 2);

        Stream.iterate(0, add(11012212)).limit(5).forEach(System.out::println);
    }

    public static UnaryOperator<Integer> add(final int n) {
        return i -> i + 1;
    }

    public static boolean method1(int i) {
        System.out.println("Method 1");
        // return false;
        return true;

    }

    public static boolean method2(int i) {
        System.out.println("Method 2");
        return false;
    }

    public static void evaluation(int i, int j) {

        if (method1(i) && method2(j)) {
            System.out.println("both true");
        } else {
            System.out.println("one is false");
        }

    }
}

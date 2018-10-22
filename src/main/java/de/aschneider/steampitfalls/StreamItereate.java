package de.aschneider.steampitfalls;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class StreamItereate {
    
    public static void main(String[] args) {    
        Stream
        .iterate(0, add())
        .limit(5)
        .forEach(System.out::println);
    }
    
    public static UnaryOperator<Integer> add() {
        return i -> i + 2;
    }
}

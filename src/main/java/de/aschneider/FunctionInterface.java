package de.aschneider;

import java.util.function.Function;

public class FunctionInterface {

    public static void main(String[] args) {
        
        final Function<Integer, Integer> doubleF = a -> a * 2;

        final Function<Integer, Integer> expF = a -> a * a;
        
        System.out.println(doubleF.apply(3));
        
        System.out.println(expF.apply(3));

        // (3*3)*2
        System.out.println(doubleF.compose(expF).apply(3));
        // (3*2)^2
        System.out.println(doubleF.andThen(expF).apply(3));
    }

}

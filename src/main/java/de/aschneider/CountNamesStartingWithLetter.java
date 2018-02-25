package de.aschneider;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class CountNamesStartingWithLetter {

    public static void main(String[] args) {
        final String LETTER = "B";
        List<String> names = Arrays.asList("Ben", "Maike", "Lara", "Brian", "Michael");

//        final Function<String, Predicate<String>> startsWithLetter = (String letter) -> {
//            Predicate<String> checkStart = name -> name.startsWith(letter);
//            return checkStart;
//        };

        final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name
                .startsWith(letter);

        
        long namesWithB = names.stream().filter(startsWithLetter.apply(LETTER)).count();

        System.out.println(
                String.format("There are %d persons which name starts with %s", namesWithB, LETTER));
    }

}

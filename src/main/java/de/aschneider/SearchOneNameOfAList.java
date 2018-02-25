package de.aschneider;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SearchOneNameOfAList {

    public static void main(String[] args) {
        final String LETTER = "A";
        final List<String> names = Arrays.asList("Ben", "Maike", "Lara", "Brian", "Michael");

        Optional<String> foundName = names.stream().filter(name -> name.startsWith(LETTER)).findFirst();

        System.out.println(String.format("A name starting whit %s : %s", LETTER,
                foundName.orElse("No name found")));
    }

}

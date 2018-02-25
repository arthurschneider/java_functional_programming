package de.aschneider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamsAreLazyAndWillBeEvaluatedAfterTerminalFunctions {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Ben");
        names.add("Erich");
        names.add("Lara");
        names.add("Maike");

        Stream<String> namesStream = names.stream();

        names.add("Victor");

        Optional<String> foundName = namesStream.filter(name -> name.startsWith("V")).findFirst();
        if (foundName.isPresent()) {
            System.out.println(String.format("Name is %s", foundName.get()));
        }

        foundName.ifPresent(System.out::println);
    }
}

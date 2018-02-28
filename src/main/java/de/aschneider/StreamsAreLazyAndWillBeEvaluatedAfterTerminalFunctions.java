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

        Stream<String> namesStream = names.stream().filter(name -> name.startsWith("V"));

        names.add("Victor");

        Optional<String> foundName = namesStream.findFirst();
        
        // One possibility to print the name if it is there, or else it will nothing be printed
        if (foundName.isPresent()) {
            System.out.println(String.format("Name is %s", foundName.get()));
        }

        //Second possibility to print the name if it is found
        foundName.ifPresent(name -> System.out.println(String.format("Name is %s", name)));
    }
}

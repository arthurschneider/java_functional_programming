package de.aschneider;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GetInformationsAboutTheNamesInList {

    public static void main(String[] args) {
        final List<String> names = Arrays.asList("Ben", "Maike", "Lara", "Brian", "Michael");

        System.out.println(
                "Longest name has a length of " + getNamesAsIntStream(names).max().getAsInt());

        names.stream().max((a, b) -> a.length() - b.length())
                .ifPresent(name -> System.out.println("The longest name ist " + name));

        names.stream().reduce((a, b) -> a.length() >= b.length() ? a : b)
                .ifPresent(name -> System.out.println("The longest name ist " + name));

        System.out.println(
                "Shortest name has a length of " + getNamesAsIntStream(names).min().getAsInt());

        names.stream().min((a, b) -> a.length() - b.length())
                .ifPresent(name -> System.out.println("The shortest name ist " + name));

        getNamesAsIntStream(names).average().ifPresent(
                number -> System.out.println("The avarage length of a name is " + number));

        names.stream()
                .filter(name -> name.length() > getNamesAsIntStream(names).average().getAsDouble())
                .forEach(name -> System.out.println(
                        name + " the lenght of this name is bigger than the avarages name length"));

        System.out.println("++++++++++++++++++");
        System.out.println(names.stream().collect(Collectors.joining(", ")));
        
        System.out.println(names.stream().reduce("", (x, y) -> x + y));

        System.out.println(names.stream().map(String::toUpperCase).reduce("", (x, y) -> x + y));
        System.out.println("++++++++++++++++++");

        System.out.println("------------------");
        names.stream().sorted().forEach(System.out::println);
        System.out.println("------------------");

        System.out.println(
                "Length of all names is " + names.stream().reduce("", (x, y) -> x + y).length());

        System.out
                .println(String.format("There are %s names in the list ", names.stream().count()));

    }

    public static IntStream getNamesAsIntStream(List<String> list) {
        return list.stream().mapToInt(String::length);
    }
}

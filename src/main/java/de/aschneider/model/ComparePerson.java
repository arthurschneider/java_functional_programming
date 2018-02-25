package de.aschneider.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ComparePerson {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Erich", 11), new Person("Maike", 30),
                new Person("Ben", 12), new Person("Michael", 35));

        List<Person> peopleAscendingAge = people.stream().sorted(Person.comparePersonAgeAscending())
                .collect(Collectors.toList());

        List<Person> peopleDescendingAge = people.stream()
                .sorted(Person.comparePersonAgeDescending()).collect(Collectors.toList());

        System.out.println("People ordered by age ascending:");
        peopleAscendingAge.forEach(System.out::println);

        System.out.println("People ordered by age descending:");
        peopleDescendingAge.forEach(System.out::println);

        System.out.println("People ordered by name ascending:");
        people.stream().sorted(Person.comparePersonsNameAscending()).forEach(System.out::println);

        System.out.println("People ordered by name descending:");
        people.stream().sorted(Person.comparePersonsNameDescending()).forEach(System.out::println);

        people.stream().min(Person.comparePersonAgeAscending())
                .ifPresent(p -> System.out.println("The youngest person is " + p));
     
        people.stream().max(Person.comparePersonAgeAscending())
                .ifPresent(p -> System.out.println("The eldest person is " + p));
    }

}

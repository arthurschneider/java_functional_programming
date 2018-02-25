package de.aschneider.model;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class ComparePerson {

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Erich", 11), new Person("Maike", 30),
                new Person("Lisa", 30), new Person("Ben", 12), new Person("Michael", 35));

        List<Person> peopleAscendingAge = people.stream().sorted(Person.comparePersonAgeAscending())
                .collect(Collectors.toList());

        List<Person> peopleDescendingAge = people.stream()
                .sorted(Person.comparePersonAgeDescending()).collect(Collectors.toList());

        System.out.println("People ordered by age ascending:");
        peopleAscendingAge.forEach(System.out::println);

        // comparing takes a Function<Person, Integer> byAge = person -> person.getAge()
        System.out.println("People ordered by age ascending:");
        people.stream().sorted(comparing(Person::getAge)).forEach(System.out::println);

        System.out.println("People ordered by age descending:");
        peopleDescendingAge.forEach(System.out::println);

        //--------------------------------------
        
        System.out.println("People ordered by name ascending:");
        people.stream().sorted(comparing(Person::getName)).forEach(System.out::println);

        // the method reversed is a default method of the Comparator Interface
        System.out.println("People ordered by name descending:");
        people.stream().sorted(comparing(Person::getName).reversed()).forEach(System.out::println);

        System.out.println("People ordered by age and the by their name:");
        List<Person> peopleOrderedByAgeThenByName = people.stream()
                .sorted(comparing(Person::getAge).thenComparing(Person::getName))
                .collect(Collectors.toList());
        peopleOrderedByAgeThenByName.forEach(System.out::println);

        // --------------------------------------

        people.stream().min(Person.comparePersonAgeAscending())
                .ifPresent(p -> System.out.println("The youngest person is " + p));

        people.stream().max(Person.comparePersonAgeAscending())
                .ifPresent(p -> System.out.println("The eldest person is " + p));

        // --------------------------------------

        Map<Integer, List<String>> nameOfPeopleByAge = people.stream()
                .collect(Collectors.groupingBy(Person::getAge, mapping(Person::getName, toList())));
        System.out.println("People grouped by Age:" + nameOfPeopleByAge);

        // --------------------------------------

        Map<Character, Optional<Person>> oldestPersonOfEachLetter = people.stream().collect(
                groupingBy(person -> person.getName().charAt(0),
                reducing(BinaryOperator.maxBy(comparing(Person::getAge)))));
        
        System.out.println("Oldest person of each letter :");
        System.out.println(oldestPersonOfEachLetter);
    }

}

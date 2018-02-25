package de.aschneider.model;

import java.util.Comparator;

public class Person {

    private final String name;
    private final int    age;

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    /**
     * The method must be static so java knows the parameters are arguments of type Person.
     * Otherwise it will think the one is a target parameter and the other is a argument. 
     * @return
     */
    public static Comparator<Person> comparePersonAgeAscending() {
        return (p1, p2) -> p1.age - p2.age;
    }
    
    /**
     * The method must be static so java knows the parameters are arguments of type Person.
     * Otherwise it will think the one is a target parameter and the other is a argument. 
     * @return
     */
    public static  Comparator<Person> comparePersonAgeDescending() {
        return comparePersonAgeAscending().reversed();
    }
    
    public static Comparator<Person> comparePersonsNameAscending(){
        return (p1, p2) -> p1.getName().compareTo(p2.getName());
    }

    public static Comparator<Person> comparePersonsNameDescending(){
        return comparePersonsNameAscending().reversed();
    }

    @Override
    public String toString() {
        return String.format("%s - %d", name, age);
    }
}

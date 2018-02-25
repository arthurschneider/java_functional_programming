package de.aschneider;

public class WorkingWithStrings {

    public static void main(String[] args) {
        String string = "w00t";

        string.chars().forEach(digit -> System.out.println("Chars as ASCII digits " + digit));

        string.chars().mapToObj(ch -> Character.valueOf((char) ch)).forEach(System.out::println);

        string.chars().filter(Character::isDigit).mapToObj(ch -> Character.valueOf((char) ch))
                .forEach(digit -> System.out.println("Digit in this string is " + digit));

        string.chars().filter(Character::isAlphabetic).mapToObj(ch -> Character.valueOf((char) ch))
                .forEach(ch -> System.out.println("Character in this sting is " + ch));
    }
}

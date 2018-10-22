package de.aschneider.cardschuffler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Schuffler {

    public static void main(String[] args) {

        showStreamVersion();

        printDelimiter();

        showIterativeVersion();
    }

    private static void printDelimiter() {
        System.out.println("-----------------------------");
        System.out.println("-----------------------------");
    }

    private static void showIterativeVersion() {

        List<Card> cards = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }

        System.out.println("Cards overall " + cards.size());
        cards.forEach(System.out::println);

    }

    private static void showStreamVersion() {

        List<Card> cards = Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Rank.values()).
                        map(rank -> new Card(suit, rank)))
                .collect(Collectors.toList());

        System.out.println("Cards overall " + cards.size());
        cards.forEach(System.out::println);

    }

}

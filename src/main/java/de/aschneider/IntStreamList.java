package de.aschneider;

import java.util.ArrayList;
import java.util.List;

public class IntStreamList {
    public static void main(String[] args) {
        List<Integer> prices = new ArrayList<>();
        prices.add(44);
        prices.add(24);
        prices.add(7);
        prices.add(31);

        
        System.out.println(prices.stream().mapToInt(Integer::intValue).max().getAsInt());
    }
}

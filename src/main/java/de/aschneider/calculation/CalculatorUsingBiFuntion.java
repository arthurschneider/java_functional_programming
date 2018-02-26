package de.aschneider.calculation;

import java.util.function.BiFunction;

public class CalculatorUsingBiFuntion {

	public static void main(String[] args) {

		System.out.println("10 + 5 = " + getFunction("+").apply(10, 5));

		System.out.println("10 - 5 = " + getFunction("-").apply(10, 5));

		System.out.println("10 * 5 = " + getFunction("*").apply(10, 5));

		System.out.println("10 / 5 = " + getFunction("/").apply(10, 5));


		System.out.println("10 # 5  will return default value  =  " + getFunction("#").apply(10, 5));

		System.out.println("(2 + 3) * 2 = " + getFunction("+").andThen(e -> e * 2).apply(2, 3));
	}

	private static BiFunction<Integer, Integer, Integer> getFunction(String operator) {
		switch (operator) {
			case "+":
				return (a, b) -> a + b;
			case "-":
				return (a, b) -> a - b;
			case "*":
				return (a, b) -> a * b;
			case "/":
				return (a, b) -> a / b;
			default:
				return (a, b) -> 0;
		}
	}
}

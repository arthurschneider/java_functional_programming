package de.aschneider.calculation;

/**
 * @author aschneider
 * @since 26.02.2018
 */

public class Calculator {

	public static void main(String[] args) {
		
		//Lambda expresions are like anonymous methods


		// with type declaration
		MathOperation addition = (int a, int b) -> a + b;

		// with out type declaration
		MathOperation subtraction = (a, b) -> a - b;

		// with return statement along with curly braces and multiple statements
		MathOperation multiplication = (int a, int b) -> {
			System.out.println(a + ", " + b);
			return a * b;
		};

		// without return statement and without curly braces
		MathOperation division = (a, b) -> {
			return a / b;
		};

		System.out.println("10 + 5 = " + addition.compute(10, 5));
		System.out.println("10 - 5 = " + subtraction.compute(10, 5));
		System.out.println("10 x 5 = " + multiplication.compute(10, 5));
		System.out.println("10 / 5 = " + division.compute(10, 5));
		
		
		


		// lambda expression
		GreetingService greetTheWorld = message -> System.out.println("Hello " + message);

		// method reference
		GreetingService greetService = System.out::println;

		greetTheWorld.sayMessage("World");
		greetService.sayMessage("Hello Arthur");
	}

	@FunctionalInterface
	interface MathOperation {

		// A single abstact method. Every lambda expression will be invoked by this method
		int compute(int a, int b);
	}

	@FunctionalInterface
	interface GreetingService {

		// A single abstact method. Every lambda expression will be invoked by this method
		void sayMessage(String message);
	}

}

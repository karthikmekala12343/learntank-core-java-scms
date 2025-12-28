package com.airtribe.learntrack.util;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputValidator {
	private static final Scanner scanner = new Scanner(System.in);

	public static String getStringInput(String prompt) {
		System.out.print(prompt);
		return scanner.nextLine().trim();
	}

	public static int getIntInput(String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("\nInvalid input. Please enter a valid number.");
			} catch (NoSuchElementException e) {
				System.out.println("\nInput stream ended. Exiting...");
				System.exit(0); // Or return a default value
			}
		}
	}

	public static boolean getBooleanInput(String prompt) {
		while (true) {
			String input = getStringInput(prompt + " (true/false): ").toLowerCase();
			if (input.equals("true"))
				return true;
			if (input.equals("false"))
				return false;
			System.out.println("\nInvalid input. Please type 'true' or 'false'.");
		}
	}
}

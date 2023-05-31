package NumberBaseConverison;

import java.util.Scanner;

public class Stage2 {
	static long decimal;
	static int base;
	static String result;
	static String prompt;
	static String input;

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		prompt();

	}

	private static void prompt() {
		System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
		prompt = scanner.next();

		switch (prompt) {
		case "/from":
			fromDecimal();
			prompt();
			break;

		case "/to":
			toDecimal();
			prompt();
			break;

		case "/exit":
			return;

		default:
			System.out.println("Error");
			prompt();
		}

	}

	private static void fromDecimal() {
		decimalInput();
		enterTargetBase();
		converterFromDecimal();
	}

	private static void toDecimal() {
		enterSourceNumber();
		enterSourceBase();
		converterToDecimal();

	}

	private static void decimalInput() {
		System.out.print("Enter number in decimal system: ");
		String temp = scanner.nextLine();

		// check if input ok and contains only digits
		if (temp.matches("\\d+")) {
			decimal = Long.parseLong(temp);
		} else {
			System.out.println("Error");
			decimalInput();
		}
	}

	private static void enterTargetBase() {
		System.out.print("Enter target base: ");
		String temp = scanner.nextLine();

		// check if input = 2, 8, or 16
		if (temp.equals("2")) {
			base = 2;

		} else if (temp.equals("8")) {
			base = 8;

		} else if (temp.equals("16")) {
			base = 16;

		} else {
			System.out.println("Error");
			enterTargetBase();
		}

	}

	private static void converterFromDecimal() {

		if (base == 2) {
			convertToBinary();

		} else if (base == 8) {
			convertToOct();

		} else if (base == 16) {
			convertToHex();

		}

		System.out.println("Conversion result: " + result);
		System.out.println();

	}

	private static void convertToBinary() {
		result = Long.toBinaryString(decimal);
	}

	private static void convertToOct() {
		result = Long.toOctalString(decimal);
	}

	private static void convertToHex() {
		result = Long.toHexString(decimal);
	}

	private static void enterSourceNumber() {
		System.out.print("Enter source number: ");
		input = scanner.next();

	}

	private static void enterSourceBase() {
		System.out.print("Enter source base: ");
		String tmp = scanner.next();

		if (tmp.matches("\\d+")) {
			base = Integer.parseInt(tmp);
		} else {
			System.out.println("Error");
			enterSourceBase();
		}

		if (base == 2) {
			if (input.matches("\\d+")) {
				int i = Integer.parseInt(input, 2);
				result = Integer.toString(i);
			} else {
				System.out.println("Error! Source number and source base do not match!");
				enterSourceNumber();
			}

		} else if (base == 8) {
			if (input.matches("\\d+")) {
				int i = Integer.parseInt(input, 8);
				result = Integer.toString(i);
			} else {
				System.out.println("Error! Source number and source base do not match!");
				enterSourceNumber();
			}

		} else if (base == 16) {

			int i = Integer.parseInt(input, 16);
			result = Integer.toString(i);

		} else {
			System.out.println("Error! Wrong source base! Must be 2, 8 or 16.");
			enterSourceBase();
		}
	}

	private static void converterToDecimal() {

		System.out.println("Conversion to decimal result: " + result);
		System.out.println();
	}
}

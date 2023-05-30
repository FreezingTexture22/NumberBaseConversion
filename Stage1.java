package NumberBaseConverison;

import java.util.Scanner;

public class Stage1 {
	static long decimal;
	static int base;
	static String result;

	public static void main(String[] args) {
		prompt();

		converter();

	}

	private static void prompt() {

		decimalInput();
		enterTargetBase();

	}

	private static void decimalInput() {
		Scanner scanner = new Scanner(System.in);
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
		Scanner scanner = new Scanner(System.in);
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

	private static void converter() {

		if (base == 2) {
			convertToBinary();
		} else if (base == 8) {
			convertToOct();
		} else if (base == 16) {
			convertToHex();
		}

		System.out.print("Conversion result: " + result);

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

}

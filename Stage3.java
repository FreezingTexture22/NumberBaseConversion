package NumberBaseConverison;

import java.math.BigInteger;
import java.util.Scanner;

public class Stage3 {

	static String sourceBase;
	static String targetBase;
	static String number;
	static String result;

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		prompt1();

	}

	private static void prompt1() {
		System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
		sourceBase = scanner.next();

		if (sourceBase.equals("/exit")) {
			return;
		}

		targetBase = scanner.next();

		prompt2();

	}

	private static void prompt2() {
		System.out.printf("Enter number in base %s to convert to base %s (To go back type /back) ", sourceBase,
				targetBase);
		number = scanner.next();

		if (number.equals("/back")) {
			System.out.println();
			prompt1();
			return;
		}

		conversion();

	}

	private static void conversion() {
		BigInteger tmpBig = new BigInteger(number, Integer.parseInt(sourceBase));

		String convertedToBigInteger = tmpBig.toString(Integer.parseInt(targetBase));
		System.out.println("Conversion result: " + convertedToBigInteger + "\n");
		prompt2();
	}

}

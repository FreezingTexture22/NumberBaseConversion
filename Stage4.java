package NumberBaseConverison;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Stage4 {

	static String sourceBase;
	static int sourceBaseInt;
	static String targetBase;
	static int targetBaseInt;
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

		sourceBaseInt = Integer.parseInt(sourceBase);

		targetBase = scanner.next();

		targetBaseInt = Integer.parseInt(targetBase);

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

		if (number.contains(".")) {
			conversionFraction();
		} else {

			conversionInteger();
		}

	}

	private static void conversionInteger() {
		BigInteger tmpBig = new BigInteger(number, Integer.parseInt(sourceBase));
		String convertedToBigInteger = tmpBig.toString(Integer.parseInt(targetBase));

		System.out.println("Conversion result: " + convertedToBigInteger + "\n");

		prompt2();
	}

	private static void conversionFraction() {
		String[] fraction = number.split("\\."); // get integer and fraction from number

		// converting integers, before `.`
		// convert FROM sourceBase TO base10
		BigInteger tmpBig = new BigInteger(fraction[0], Integer.parseInt(sourceBase));

		// convert FROM base10 TO targetBase
		String convertedInteger = tmpBig.toString(Integer.parseInt(targetBase));

		// ********************
		// converting fractions
		// converting fraction FROM sourceBase TO base10

		String fractionString = fraction[1]; // set fraction to String

		BigDecimal sourceBaseBD = new BigDecimal(sourceBase); // convert sourceBase to BigDecimal

		int counter = 1; // counter for dividing

		BigDecimal fractionalPart = new BigDecimal("0"); // set var fractionalPart to return

		for (int i = 0; i < fractionString.length(); i++) {

			String charString = String.valueOf(fractionString.charAt(i));
			int tmp = Integer.parseInt(charString, sourceBaseInt);
			BigDecimal tmpBigDecimal = new BigDecimal(tmp);

			BigDecimal temporary = new BigDecimal("0");
			temporary = tmpBigDecimal.divide(sourceBaseBD.pow(counter), 10, RoundingMode.HALF_DOWN);
			fractionalPart = fractionalPart.add(temporary);
			counter++;
		}

		// converting fraction FROM base10 TO targetBase
		BigDecimal targetBaseBD = new BigDecimal(targetBase);
		StringBuilder convertedFraction = new StringBuilder(); // initialize result

		// for every element of fractionalPart
		// do until fractionalPart == 1 OR result.length() < 5
		for (int i = 0; fractionalPart.compareTo(BigDecimal.ONE) < 0 && convertedFraction.length() < 5; i++) {

			fractionalPart = fractionalPart.multiply(targetBaseBD); // fraction * targetBase

			int intgr = fractionalPart.intValue(); // int to remove from mult AND to add to result
			String convertedToTargetBase = Integer.toString(intgr, targetBaseInt);
			convertedFraction = convertedFraction.append(convertedToTargetBase); // adding big integer to result String

			fractionalPart = fractionalPart.subtract(BigDecimal.valueOf(intgr));

		}

		// printing out result
		StringBuilder convertedFractionResult = new StringBuilder(convertedInteger + "." + convertedFraction);
		System.out.println("Conversion result: " + convertedFractionResult + "\n");

		prompt2();
	}

}

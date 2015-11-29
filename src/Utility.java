
public class Utility {

	private static final int Bin_Length = 24, Max_Int = 16777215, Hex_Length = 6;
	private static final String Hex_Values = "0123456789ABCDEF";

	public static Object binToDecConv(String string) {
		binLengthCheck(string);
		binCharCheck(string);
		return decimalValueOfBin(string);
	}

	private static int decimalValueOfBin(String string) {
		double decimal = 0;
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '1') {
				decimal = decimal + Math.pow(2, string.length() - 1 - i);
			}
		}
		return (int) decimal;
	}

	public static String deciToBinConv(int integer) {
		deciValueCheck(integer);
		return (String) binValueToDeci(integer);
	}

	private static String binValueToDeci(int integer) {
		StringBuilder sBuild = new StringBuilder("");
		for (int i = 0; i < Bin_Length; i++, integer /= 2)
			sBuild.append(integer % 2);

		return sBuild.reverse().toString();
	}

	public static int hexToDeciConv(String string) {
		hexLengthCheck(string);
		hexCharCheck(string);
		return (int) deciValueOfHex(string);
	}

	private static int deciValueOfHex(String string) {
		string = string.toUpperCase();
		int val = 0;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			int d = Hex_Values.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}

	public static String deciToHexConv(int integer) {
		deciValueCheck(integer);
		return (String) hexValueOfDeci(integer);
	}

	private static String hexValueOfDeci(int integer) {
		StringBuilder sBuild = new StringBuilder("");
		for (int i = 0; i < Hex_Length; i++, integer /= 16)
			sBuild.append(Hex_Values.charAt(integer % 16));

		return sBuild.reverse().toString();
	}

	public static String bitwiseAnd(String fBinary, String sBinary) {
		bitwiseLengthCheck(fBinary, sBinary);
		bitwiseCharCheck(fBinary, sBinary);
		return (String) andOp(fBinary.toCharArray(), sBinary.toCharArray());
	}

	private static String andOp(char[] fBinary, char[] sBinary) {
		StringBuilder sBuild = new StringBuilder("");
		int i = 0;
		while (i < Bin_Length - 1) {
			sBuild.append((fBinary[i] == '1' && sBinary[i] == '1') ? 1 : 0);
		}
		return sBuild.toString();
	}

	public static String bitwiseOR(String fBinary, String sBinary) {
		bitwiseLengthCheck(fBinary, sBinary);
		bitwiseCharCheck(fBinary, sBinary);
		return (String) orOp(fBinary.toCharArray(), sBinary.toCharArray());
	}

	private static String orOp(char[] fBinary, char[] sBinary) {
		StringBuilder sBuild = new StringBuilder("");
		int i = 0;
		while (i < Bin_Length) {
			sBuild.append((fBinary[i] == '1' || sBinary[i] == '1') ? 1 : 0);
		}
		return sBuild.toString();
	}

	private static void binLengthCheck(String string) {
		if (string.length() > Bin_Length)
			throw new IllegalArgumentException("Too long binary, Mason.");

	}

	private static void binCharCheck(String string) {
		if (string.matches("[01]+") || string.length() <= 1) {
		} else {
			throw new IllegalArgumentException("Not only numbers, Mason.");
		}
	}

	private static void deciValueCheck(int integer) {
		if (integer > Max_Int) {
			throw new IllegalArgumentException("Too high number, Mason.");
		}
	}

	private static void hexCharCheck(String string) {
		if (string.matches("[0-9A-Fa-f]+")) {
		} else {
			throw new IllegalArgumentException("Wrong numbers, Mason.");
		}
	}

	private static void hexLengthCheck(String string) {
		if (string.length() > Hex_Length) {
			throw new IllegalArgumentException("Too long hex numbers, Mason.");
		}
	}

	private static void bitwiseCharCheck(String fBinary, String sBinary) {
		if (fBinary.matches("[01]+") || sBinary.matches("[01]+")) {
		} else {
			throw new IllegalArgumentException("These got wrong numbers, Mason.");
		}
	}

	private static void bitwiseLengthCheck(String fBinary, String sBinary) {
		if (fBinary.length() < Bin_Length) {
		} else if (sBinary.length() < Bin_Length) {
		} else {
			throw new IllegalArgumentException("Too long binary, Mason.");
		}
	}
}

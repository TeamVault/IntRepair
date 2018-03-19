package smtcodan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class IntegersUpperBounds {

	// linux 32bit and 64 bit have the same values
	// private static final String _default = "127";
	// private static final String CHAR_MAX_VAL = "127";
	// private static final String SHRT_MAX_VAL = "32767";
	// private static final String INT_MAX_VAL = "2147483647";
	// private static final String UINT_MAX_VAL = "4294967295";
	// private static final String LLONG_MAX_VAL = "9223372036854775807";

	private static final String _default = "127";
	private static String CHAR_MAX_VAL = "0";
	private static String SHRT_MAX_VAL = "0";
	private static String INT_MAX_VAL = "0";
	private static String UINT_MAX_VAL = "0";
	private static String LLONG_MAX_VAL = "0";
	private static String LONG_MAX_VAL = "0";

	private static String __currentLimit = _default;

	public enum Constants {
		CHAR_MAX, SHRT_MAX, INT_MAX, UINT_MAX, LLONG_MAX, LONG_MAX
	}

	public static String getLONG_MAX_VAL() {
		return LONG_MAX_VAL;
	}

	public static void setLONG_MAX_VAL(String lONG_MAX_VAL) {
		LONG_MAX_VAL = lONG_MAX_VAL;
	}

	public static String getCHAR_MAX_VAL() {
		return CHAR_MAX_VAL;
	}

	public static void setCHAR_MAX_VAL(String cHAR_MAX_VAL) {
		CHAR_MAX_VAL = cHAR_MAX_VAL;
	}

	public static String getSHRT_MAX_VAL() {
		return SHRT_MAX_VAL;
	}

	public static void setSHRT_MAX_VAL(String sHRT_MAX_VAL) {
		SHRT_MAX_VAL = sHRT_MAX_VAL;
	}

	public static String getINT_MAX_VAL() {
		return INT_MAX_VAL;
	}

	public static void setINT_MAX_VAL(String iNT_MAX_VAL) {
		INT_MAX_VAL = iNT_MAX_VAL;
	}

	public static String getUINT_MAX_VAL() {
		return UINT_MAX_VAL;
	}

	public static void setUINT_MAX_VAL(String uINT_MAX_VAL) {
		UINT_MAX_VAL = uINT_MAX_VAL;
	}

	public static String getLLONG_MAX_VAL() {
		return LLONG_MAX_VAL;
	}

	public static void setLLONG_MAX_VAL(String lLONG_MAX_VAL) {
		LLONG_MAX_VAL = lLONG_MAX_VAL;
	}

	public static void resetLimit() {
		__currentLimit = _default;
	}

	public static String getCurrentLimit() {
		return __currentLimit;
	}

	public static void updateLimit(String operandLeft, String operandRight) {
		if (operandLeft.equalsIgnoreCase(Constants.CHAR_MAX.toString())
				|| operandRight.equalsIgnoreCase(Constants.CHAR_MAX.toString())) {
			__currentLimit = CHAR_MAX_VAL;
		}

		if (operandLeft.equalsIgnoreCase(Constants.SHRT_MAX.toString())
				|| operandRight.equalsIgnoreCase(Constants.SHRT_MAX.toString())) {
			__currentLimit = SHRT_MAX_VAL;
		}

		if (operandLeft.equalsIgnoreCase(Constants.INT_MAX.toString())
				|| operandRight.equalsIgnoreCase(Constants.INT_MAX.toString())) {
			__currentLimit = INT_MAX_VAL;
		}

		if (operandLeft.equalsIgnoreCase(Constants.UINT_MAX.toString())
				|| operandRight.equalsIgnoreCase(Constants.UINT_MAX.toString())) {
			__currentLimit = UINT_MAX_VAL;
		}

		if (operandLeft.equalsIgnoreCase(Constants.LLONG_MAX.toString())
				|| operandRight
						.equalsIgnoreCase(Constants.LLONG_MAX.toString())) {
			__currentLimit = LLONG_MAX_VAL;
		}
	}

	public static void readLimitsFile(String path) throws IOException {
		String os_arch = System.getProperty("os.arch");
		boolean bit_32 = false;
		boolean bit_64 = false;

		if (os_arch.endsWith("64")) {
			bit_64 = true;
		} else {
			bit_32 = true;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			boolean nextValue = false;
			String myIdentifier = null;
			while (line != null) {
				for (Constants dir : IntegersUpperBounds.Constants.values()) {
					String[] tokens = line.toString().split(" ");
					StringTokenizer defaultTokenizer = new StringTokenizer(
							line.toString());
					int i = 0;
					while (defaultTokenizer.hasMoreTokens()) {
						String token = defaultTokenizer.nextToken();
						if (nextValue) {
							if ((token + " ").contains("U ")) {
								token = token.replace("U", "");
							} else if ((token + " ").contains("LL")) {
								token = token.replace("LL", "");
							} else if ((token + " ").contains("L")) {
								token = token.replace("L", "");
							} else if ((token + " ").contains("UL")) {
								token = token.replace("UL", "");
							} else if ((token + " ").contains("ULL")) {
								token = token.replace("ULL", "");
							}

							if (token.matches("[0-9]+") && token.length() > 0) {
								// System.out.println("number  " + token);
								switch (myIdentifier) {
								case "SCHAR_MAX ":
									if (IntegersUpperBounds.getCHAR_MAX_VAL()
											.equals("0")) {
										IntegersUpperBounds
												.setCHAR_MAX_VAL(token);
									} else {
										BigInteger bigInt = new BigInteger(
												token);
										int res = bigInt
												.compareTo(new BigInteger(
														IntegersUpperBounds
																.getCHAR_MAX_VAL()));
										if (res == 0) {
											// equal values
										} else if (res == 1) {
											if (bit_64) {
												// set the bigger value
												IntegersUpperBounds
														.setCHAR_MAX_VAL(token);
											}
										} else if (res == -1) {
											if (bit_32) {
												// set the bigger value
												IntegersUpperBounds
														.setCHAR_MAX_VAL(token);
											}
										}
									}
									break;
								case "CHAR_MAX ":
									if (IntegersUpperBounds.getCHAR_MAX_VAL()
											.equals("0")) {
										IntegersUpperBounds
												.setCHAR_MAX_VAL(token);
									} else {
										BigInteger bigInt = new BigInteger(
												token);
										int res = bigInt
												.compareTo(new BigInteger(
														IntegersUpperBounds
																.getCHAR_MAX_VAL()));
										if (res == 0) {
											// equal values
										} else if (res == 1) {
											if (bit_64) {
												// set the bigger value
												IntegersUpperBounds
														.setCHAR_MAX_VAL(token);
											}
										} else if (res == -1) {
											if (bit_32) {
												// set the bigger value
												IntegersUpperBounds
														.setCHAR_MAX_VAL(token);
											}
										}
									}
									break;
								case "SHRT_MAX ":
									if (IntegersUpperBounds.getSHRT_MAX_VAL()
											.equals("0")) {
										IntegersUpperBounds
												.setSHRT_MAX_VAL(token);
									} else {
										BigInteger bigInt = new BigInteger(
												token);
										int res = bigInt
												.compareTo(new BigInteger(
														IntegersUpperBounds
																.getSHRT_MAX_VAL()));
										if (res == 0) {
											// equal values
										} else if (res == 1) {
											if (bit_64) {
												// set the bigger value
												IntegersUpperBounds
														.setSHRT_MAX_VAL(token);
											}
										} else if (res == -1) {
											if (bit_32) {
												// set the bigger value
												IntegersUpperBounds
														.setSHRT_MAX_VAL(token);
											}
										}
									}
									break;
								case "INT_MAX ":
									if (IntegersUpperBounds.getINT_MAX_VAL()
											.equals("0")) {
										IntegersUpperBounds
												.setINT_MAX_VAL(token);
									} else {
										BigInteger bigInt = new BigInteger(
												token);
										int res = bigInt
												.compareTo(new BigInteger(
														IntegersUpperBounds
																.getINT_MAX_VAL()));
										if (res == 0) {
											// equal values
										} else if (res == 1) {
											if (bit_64) {
												// set the bigger value
												IntegersUpperBounds
														.setINT_MAX_VAL(token);
											}
										} else if (res == -1) {
											if (bit_32) {
												// set the bigger value
												IntegersUpperBounds
														.setINT_MAX_VAL(token);
											}
										}
									}
									break;
								case "UINT_MAX ":
									if (IntegersUpperBounds.getUINT_MAX_VAL()
											.equals("0")) {
										IntegersUpperBounds
												.setUINT_MAX_VAL(token);
									} else {
										BigInteger bigInt = new BigInteger(
												token);
										int res = bigInt
												.compareTo(new BigInteger(
														IntegersUpperBounds
																.getUINT_MAX_VAL()));
										if (res == 0) {
											// equal values
										} else if (res == 1) {
											if (bit_64) {
												// set the bigger value
												IntegersUpperBounds
														.setUINT_MAX_VAL(token);
											}
										} else if (res == -1) {
											if (bit_32) {
												// set the bigger value
												IntegersUpperBounds
														.setUINT_MAX_VAL(token);
											}
										}
									}
									break;
								case "LLONG_MAX ":
									if (IntegersUpperBounds.getLLONG_MAX_VAL()
											.equals("0")) {
										IntegersUpperBounds
												.setLLONG_MAX_VAL(token);
									} else {
										BigInteger bigInt = new BigInteger(
												token);
										int res = bigInt
												.compareTo(new BigInteger(
														IntegersUpperBounds
																.getLLONG_MAX_VAL()));
										if (res == 0) {
											// equal values
										} else if (res == 1) {
											if (bit_64) {
												// set the bigger value
												IntegersUpperBounds
														.setLLONG_MAX_VAL(token);
											}
										} else if (res == -1) {
											if (bit_32) {
												// set the bigger value
												IntegersUpperBounds
														.setLLONG_MAX_VAL(token);
											}
										}
									}
									break;
								case "LONG_MAX ":
									if (IntegersUpperBounds.getLONG_MAX_VAL()
											.equals("0")) {
										IntegersUpperBounds
												.setLONG_MAX_VAL(token);
									} else {
										BigInteger bigInt = new BigInteger(
												token);
										int res = bigInt
												.compareTo(new BigInteger(
														IntegersUpperBounds
																.getLONG_MAX_VAL()));
										if (res == 0) {
											// equal values
										} else if (res == 1) {
											if (bit_64) {
												// set the bigger value
												IntegersUpperBounds
														.setLONG_MAX_VAL(token);
											}
										} else if (res == -1) {
											if (bit_32) {
												// set the bigger value
												IntegersUpperBounds
														.setLONG_MAX_VAL(token);
											}
										}
									}
									break;
								default:
									// bla
									break;
								}
							} else {
								// System.out.println("identifier  " + token);
							}
						}
						token = token + " ";
						nextValue = false;
						myIdentifier = null;
						if (token.contains(dir.toString() + " ")) {
							// System.out.println(":" + token + ":");
							myIdentifier = token;
							nextValue = true;
						}
					}
				}

				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
			}
			String everything = sb.toString();
		}
	}
}

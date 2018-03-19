/**
   [Class description.  Logger]
   
   [Other notes: used for printing in the console]
   
   @author Paul Muntean
   @version $Revision: x  Date: x hour: x
 **/
package smtcodan.logger;

// TODO: Auto-generated Javadoc
/**
 * The Class Logger. test test
 */
public class MyLogger {

	/** switch on off logger by setting true or false. */

	private static boolean logg_a = false;

	/** The logg_b. */
	private static boolean logg_b = false;

	/** The logg_c. */
	private static boolean logg_c = false;

	/** The logg_parser. */
	private static boolean logg_parser = false;

	/**
	 * Log to the System.err err is used for color contrast in the console
	 * output
	 * 
	 * @param s
	 *            the log message
	 */
	public static void log_a(String s) {
		if (logg_a)
			System.err.println(s);
	}

	/**
	 * Log_b.
	 * 
	 * @param s
	 *            the s
	 */
	public static void log_b(String s) {
		if (logg_b)
			System.out.println(s);
	}

	/**
	 * Log_c.
	 * 
	 * @param s
	 *            the s
	 */
	public static void log_c(String s) {
		if (logg_c)
			System.err.println(s);
	}

	/**
	 * Log_parser.
	 * 
	 * @param s
	 *            the s
	 */
	public static void log_parser(String s) {
		if (logg_parser)
			System.out.println(s);
	}

}

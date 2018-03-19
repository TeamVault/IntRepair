package smtcodan.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;
import org.eclipse.cdt.internal.core.dom.rewrite.commenthandler.ASTCommenter;

import smtcodan.logger.MyLogger;

// TODO: Auto-generated Javadoc
/**
 * The Class ParserCommenter.
 */
public class TranslationunitMapper extends ASTCommenter {

	/** The map. */
	public HashMap<Integer, String> map = new HashMap<Integer, String>();

	/** The list. */
	public StringBuffer theList = null;

	/** The allfilescontent. */
	public String allfilescontent = null;

	/** The comments method attribute map. */
	HashMap<String, String> commentsMethodAttributeMap = null;

	/** The maximum multiline comment length. */
	private static final int maximumMultilineCommentLength = 30;

	/** The Constant multiLineStartingString. */
	private static final String multiLineStartingString = "/*@";

	/** The Constant multiLineBeginningString. */
	private static final String multiLineBeginningString = "* @";

	/** The Constant singleLineStartingString. */
	private static final String singleLineStartingString = "//@";

	/** The Constant newLine. */
	private static final String newLine = "\n";

	/** The Constant emptyString. */
	private static final String emptyString = "";
	// this is needed in order to have after each parameter comma an empty space
	/** The Constant space. */
	private static final String space = " ";

	/** The Constant headerFunctionTerminator. */
	private static final String headerFunctionTerminator = ";";

	/**
	 * Instantiates a new parser commenter.
	 * 
	 */
	public TranslationunitMapper() {
		commentsMethodAttributeMap = new HashMap<String, String>();
	}

	/**
	 * Gets the comments.
	 * 
	 * @param commentsList
	 *            the comments list
	 * @return the comments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public synchronized HashMap<String, String> getComments(
			ArrayList<IASTTranslationUnit> commentsList) throws IOException {
		Pattern pattern;
		Matcher matcher;
		for (IASTTranslationUnit ast : commentsList) {
			MyLogger.log_parser("Analyzing translation unit: "
					+ ast.getContainingFilename());
			// commentList = ast.getComments();

			String allHeaderFileContents = new String(ast
					.getOriginatingTranslationUnit().getContents());

			StringBuffer stringBuffer = new StringBuffer();
			StringBuffer stringBufferAnnotation = new StringBuffer();
			String line;
			HashMap<Integer, String> commentsMap = new HashMap<Integer, String>();
			HashMap<Integer, String> methodAttributeMap = new HashMap<Integer, String>();

			// Variable bufferedReader parses the header file in string format
			BufferedReader bufferedReader = new BufferedReader(
					new StringReader(allHeaderFileContents));

			while ((line = bufferedReader.readLine()) != null) {
				stringBuffer.append(line);
				stringBuffer.append(newLine);
				/*
				 * This part parses the code which is annotated with our
				 * annotation
				 */
				pattern = Pattern.compile("/*@ | //@");
				matcher = pattern.matcher(stringBuffer);
				if (matcher.find()) {
					stringBufferAnnotation.append(line);
					stringBufferAnnotation.append(newLine);
				}
			}
			String allContentOfFileWithAnnotation = stringBufferAnnotation
					.toString();

			// variable bufreader read the string line by line
			BufferedReader bufReader = new BufferedReader(new StringReader(
					allContentOfFileWithAnnotation));
			String singleLine = null;
			String nextLine1 = null;
			String nextLine2 = null;
			String nextLine3 = null;
			String nextLine4 = null;
			String concat = emptyString;
			int lineNo = 1;
			int temp = 0;
			int commentNumberOfLines = 0;

			/*
			 * This portion create to HashMaps.One for comments and other for
			 * methods and attribute
			 */
			while ((singleLine = bufReader.readLine()) != null) {
				// adding multiline comments
				if (singleLine.startsWith(multiLineStartingString)) {
					commentNumberOfLines = 0;
					concat += singleLine;
					nextLine1 = bufReader.readLine();
					// avoid reading comemnts longer then a given size
					while (nextLine1.contains(multiLineBeginningString)
							&& commentNumberOfLines < maximumMultilineCommentLength) {
						temp = 1;
						lineNo++;
						concat += newLine + nextLine1;
						nextLine1 = bufReader.readLine();
						commentNumberOfLines++;
					}

					if ((temp == 1)) {
						commentsMap.put(lineNo, concat);
						temp = 0;
						concat = emptyString;
					}

					while (nextLine1.trim().equals(emptyString)) {
						nextLine1 = bufReader.readLine();
					}
					// put single line function headers
					if (nextLine1.contains(headerFunctionTerminator)) {
						methodAttributeMap.put(lineNo, nextLine1);
						// put multi line function headers
					} else if (!nextLine1.contains(headerFunctionTerminator))
						while (!nextLine1.contains(headerFunctionTerminator)) {
							nextLine3 = bufReader.readLine();
							nextLine1 = nextLine1.trim() + space
									+ nextLine3.trim();
						}
					// put the function header part in the map
					methodAttributeMap.put(lineNo, nextLine1.trim());
				}

				// adding single line comments
				// there will be only one single line comment added
				// the one that is just before the function header
				// the other ones will be omitted
				if (singleLine.contains(singleLineStartingString)) {
					commentsMap.put(lineNo, singleLine);
					nextLine2 = bufReader.readLine();
					// avoid putting blank spaces
					if (!nextLine2.trim().equals(emptyString)
							&& nextLine2.contains(";")) {
						methodAttributeMap.put(lineNo, nextLine2);
					} else {
						// avoid putting a blank line into the map
						while (nextLine2.trim().equals(emptyString)) {
							nextLine2 = bufReader.readLine();
						}
						// put single line function headers
						if (nextLine2.contains(headerFunctionTerminator)) {
							methodAttributeMap.put(lineNo, nextLine2);
							// put multi line function headers
						} else if (!nextLine2
								.contains(headerFunctionTerminator))
							while (!nextLine2
									.contains(headerFunctionTerminator)) {
								nextLine4 = bufReader.readLine();
								nextLine2 = nextLine2.trim() + space
										+ nextLine4.trim();
							}
						// put the function header part in the map
						methodAttributeMap.put(lineNo, nextLine2.trim());
					}
				}

				lineNo++;
			}
			// System.out.println(commentsMap+"\n");
			// System.out.println(methodAttributeMap+"\n");

			/*
			 * Combines two HashMaps into one with comments and method_attribute
			 * pairs
			 */
			for (Integer x : commentsMap.keySet()) {
				String y1 = commentsMap.get(x);
				String x1 = methodAttributeMap.get(x);
				// removing non-valid method headers
				// if (!x1.contains(singleLineStartingString))
				// commentsMethodAttributeMap.put(x1, y1);
				commentsMethodAttributeMap.put(x1, y1);
			}
		}

		return commentsMethodAttributeMap;

	}

	/**
	 * Prints the map.
	 * 
	 * @param mp
	 *            the mp
	 */
	public static void printMap(Map mp) {
		Iterator it = mp.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println(pairs.getKey() + " contains: \n "
					+ pairs.getValue());
			System.out.println(newLine);
			it.remove(); // avoids a ConcurrentModificationException
		}
	}

}
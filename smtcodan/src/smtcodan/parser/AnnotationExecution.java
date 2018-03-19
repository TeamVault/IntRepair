package smtcodan.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.eclipse.cdt.core.dom.ast.IASTTranslationUnit;

import smtcodan.symvars.SymVarSSA;

// TODO: Auto-generated Javadoc
/**
 * The Class AnnotationExecution.
 */
public class AnnotationExecution {

	/** The comments map. */
	private static HashMap<String, Comment> commentsMap;

	/** The annotation parser. */
	private AnnotationParser annotationParser;

	/**
	 * Instantiates a new annotation execution.
	 * 
	 * @param headersastlist
	 *            the headersastlist
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws RecognitionException
	 *             the recognition exception
	 */
	public AnnotationExecution(ArrayList<IASTTranslationUnit> headersastlist)
			throws IOException, RecognitionException {

		// calculating processing start time
		long lStartTime = System.currentTimeMillis();

		// 1 create annotation mappings
		TranslationunitMapper mapper = new TranslationunitMapper();
		HashMap<String, String> annotationMap = mapper
				.getComments(headersastlist);
		// printMap(annotationMap);

		// 2 call the annotation parser
		annotationParser = new AnnotationParser();
		commentsMap = annotationParser.mapCommentToObject(annotationMap);

		// calculating processing end time
		long lEndTime = System.currentTimeMillis();
		long difference = lEndTime - lStartTime;
		System.out.println("Processing project files took: " + difference
				+ " milliseconds");
	}

	/**
	 * Gets the comments map.
	 * 
	 * @return the comments map
	 */
	public static HashMap<String, Comment> getCommentsMap() {
		return commentsMap;
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
			System.out.println("\n");
			// it.remove(); // avoids a ConcurrentModificationException
		}
	}

	// used to attach labels to an symbolic variable
	public static void labelSymbolicVariable(SymVarSSA sym,
			String symVarOriginalName, String declaration) {

		Comment comment = (Comment) commentsMap.get(declaration);
		if (comment != null) {
			ArrayList<ParameterComment> parameter_comments = comment
					.getParameterComments();
			// check that the comment is a sink
			for (int i = 0; i < parameter_comments.size(); i++) {
				ParameterComment pc = parameter_comments.get(i);
				if (pc.getLevel() != null) {
					if (symVarOriginalName.equals(pc.getParameterName()))
						sym.setLabel(pc.getLevel());
				}
			}
		}
	}
}
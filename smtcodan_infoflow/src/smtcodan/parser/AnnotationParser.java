package smtcodan.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.eclipse.cdt.core.dom.ast.IASTComment;
import org.eclipse.cdt.internal.core.dom.rewrite.commenthandler.NodeCommentMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.xtext.example.mydsl.myDsl.AnnotationLanguage;
import org.xtext.example.mydsl.myDsl.FunctionAnnotation;
import org.xtext.example.mydsl.myDsl.FunctionType;
import org.xtext.example.mydsl.myDsl.HeaderModel;
import org.xtext.example.mydsl.myDsl.MultilineAnnotation;
import org.xtext.example.mydsl.myDsl.SecurityType;
import org.xtext.example.mydsl.myDsl.SingleLineAnnotation;

import smtcodan.Activator;
import smtcodan.logger.MyLogger;

import com.google.inject.Injector;

// TODO: Auto-generated Javadoc
/**
 * The Class AnnotationParser.
 */
public class AnnotationParser extends XtextResourceSet {

	/** The ncm. */
	public static NodeCommentMap ncm;

	/** The tu contents. */
	public static char[] tuContents = null;

	/** The tu list. */
	static IASTComment[] tuList = null;

	/** The string buffer. */
	public static StringBuffer stringBuffer = null;

	/** The resource set. */
	private XtextResourceSet resourceSet;

	/** The resource factory. */
	private XtextResourceFactory resourceFactory;

	/** The in. */
	static InputStream in;

	/** The injector. */
	Injector injector;

	/** The activator. */
	Activator activator;

	/** The resource. */
	Resource resource;

	/** The comments map. */
	private HashMap<String, Comment> commentsMap = null;

	/** The comment. */
	private Comment comment = null;

	/** The function comment. */
	private FunctionComment functionComment = null;

	/** The parameter comment. */
	private ParameterComment parameterComment = null;

	/** The function comments list. */
	private ArrayList<FunctionComment> functionCommentsList = null;

	/** The parameter comments list. */
	private ArrayList<ParameterComment> parameterCommentsList = null;

	/**
	 * Instantiates a new annotation parser.
	 */
	public AnnotationParser() {
		setupParser();
		this.commentsMap = new HashMap<String, Comment>();
	}

	/**
	 * Setup parser.
	 */
	private void setupParser() {
		new org.eclipse.emf.mwe.utils.StandaloneSetup().setPlatformUri("../");
		injector = Activator.getInstance().getInjector(
				Activator.ORG_XTEXT_EXAMPLE_MYDSL_MYDSL);

		resourceSet = new XtextResourceSet();
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL,
				Boolean.TRUE);
		resourceSet.getLoadOptions().put(XMIResource.OPTION_SUPPRESS_XMI, true);
		resourceSet.getLoadOptions().put(
				XMIResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		resourceSet.getLoadOptions().put(
				XMIResource.OPTION_USE_DEPRECATED_METHODS, true);
		resourceSet.getLoadOptions().put(
				XMIResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP,
				new HashMap<Object, Object>());
		resource = resourceSet.createResource(URI.createURI("memory.h", true));

	}

	/**
	 * Map comment to object.
	 * 
	 * @param map
	 *            the map
	 * @return the hash map
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws RecognitionException
	 *             the recognition exception
	 */
	public HashMap<String, Comment> mapCommentToObject(Map<?, ?> map)
			throws IOException, RecognitionException {
		if (resource == null) {
			MyLogger.log_parser("resource is null");
		}
		// iterate through all comments from the map
		@SuppressWarnings("rawtypes")
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pairs = (Map.Entry) it.next();
			MyLogger.log_parser(pairs.getKey().toString()
					+ " \n Annotation: \n " + pairs.getValue());
			MyLogger.log_parser("\n");
			in = new ByteArrayInputStream(pairs.getValue().toString()
					.getBytes("UTF-8"));

			functionCommentsList = new ArrayList<FunctionComment>();
			parameterCommentsList = new ArrayList<ParameterComment>();
			comment = new Comment(functionCommentsList, parameterCommentsList);

			try {
				// resource unloading
				resource.unload();
				// resource loading
				resource.load(in, resourceSet.getLoadOptions());
				if (resource.getContents().size() == 0) {
					MyLogger.log_parser("Resource file is empty: "
							+ resource.getURI());
				} else {
					MyLogger.log_parser("Resource not empty: "
							+ resource.getURI());
				}

				if (resource.getErrors().size() == 0) {
					MyLogger.log_parser("Resource has no errors: "
							+ resource.getURI());
				} else {
					MyLogger.log_parser("Resource has errors: "
							+ resource.getURI());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// get the contents if the resource has no errors
			if (resource.getErrors().size() == 0
					&& resource.getContents().size() != 0) {
				// getting the object
				MyLogger.log_parser("Resource size: "
						+ resource.getContents().size());
				AnnotationLanguage domainModel = (AnnotationLanguage) resource
						.getContents().get(0);
				EList<HeaderModel> elements = domainModel.getElement();
				EList<SingleLineAnnotation> singleLineAnnotation = null;
				MyLogger.log_parser("Elements size: " + elements.size());

				for (int i = 0; i < elements.size(); i++) {

					// get the multiline comments
					if (elements.get(i) instanceof MultilineAnnotation) {
						MultilineAnnotation entity = ((MultilineAnnotation) elements
								.get(i));
						// set the type of the comment
						comment.setType("mutilineComment");
						// get the function annotations
						if (entity.getFunctionAnnotation() instanceof FunctionAnnotation) {
							// parameter comment
							if (entity.getFunctionAnnotation().getParameter() != null) {
								MyLogger.log_parser("parameter: "
										+ entity.getFunctionAnnotation()
												.getParameter());
								MyLogger.log_parser("securityType: "
										+ entity.getFunctionAnnotation()
												.getSecurityType());
								MyLogger.log_parser("level: "
										+ entity.getFunctionAnnotation()
												.getLevel());

								parameterComment = new ParameterComment();
								parameterComment
										.setParameterName(entity
												.getFunctionAnnotation()
												.getParameter());
								parameterComment.setSecurityType(entity
										.getFunctionAnnotation()
										.getSecurityType().toString());
								parameterComment.setIndex(getIndex(
										entity.getFunctionAnnotation()
												.getParameter(), pairs.getKey()
												.toString()));
								parameterComment.setLevel(entity
										.getFunctionAnnotation().getLevel());

								parameterCommentsList.add(parameterComment);
							}
							// function comment
							else if (entity.getFunctionAnnotation()
									.getFunctionType() != null
									&& entity.getFunctionAnnotation()
											.getPreStep() == null
									&& entity.getFunctionAnnotation()
											.getPostStep() == null) {
								MyLogger.log_parser("functionType: "
										+ entity.getFunctionAnnotation()
												.getFunctionType());

								functionComment = new FunctionComment();
								functionComment.setAtribute(entity
										.getFunctionAnnotation()
										.getFunctionType().toString());

								functionCommentsList.add(functionComment);
							} else if (entity.getFunctionAnnotation()
									.getPreStep() != null) {
								functionComment = new FunctionComment();
								functionComment.setPreStep(entity
										.getFunctionAnnotation().getPreStep());
								functionComment.setLevel(entity
										.getFunctionAnnotation().getLevel());

								functionCommentsList.add(functionComment);

							} else if (entity.getFunctionAnnotation()
									.getPostStep() != null) {
								functionComment = new FunctionComment();
								functionComment.setPostStep(entity
										.getFunctionAnnotation().getPostStep());
								functionComment.setLevel(entity
										.getFunctionAnnotation().getLevel());

								functionCommentsList.add(functionComment);

							}

						}
					}
					// get the single line comment parameters
					singleLineAnnotation = elements.get(i).getHeaders();
					if (singleLineAnnotation.size() > 0) {

						if (singleLineAnnotation.get(0) instanceof SingleLineAnnotation) {
							SingleLineAnnotation entity = singleLineAnnotation
									.get(0);
							// set the type of the comment
							comment.setType("singlelineComment");
							// if the function does not have a parameter then it
							// is a parameter annotation
							// else a function annotation
							if (entity.getParameter() == null) {
								if (entity.getFunctionType() instanceof FunctionType
										&& entity.getVariable() == null) {
									MyLogger.log_parser("singleline FunctionType: "
											+ entity.getFunctionType()
													.getName());

									functionComment = new FunctionComment();
									functionComment.setAtribute(entity
											.getFunctionType().getName());

									functionCommentsList.add(functionComment);

								} else if (entity.getVariable() != null) {
									parameterComment = new ParameterComment();
									parameterComment.setParameterName(entity
											.getVariable());
									parameterComment.setSecurityType(entity
											.getSecurityType().toString());
									parameterComment.setIndex(getIndex(entity
											.getVariable(), pairs.getKey()
											.toString()));
									parameterComment
											.setLevel(entity.getLevel());

									parameterCommentsList.add(parameterComment);
								}
							} else if (entity.getSecurityType() instanceof SecurityType) {

								MyLogger.log_parser("singleline SecurityType: "
										+ entity.getSecurityType()
										+ " Parameter Name : "
										+ entity.getParameter());

								parameterComment = new ParameterComment();
								parameterComment.setParameterName(entity
										.getParameter());
								parameterComment.setSecurityType(entity
										.getSecurityType().toString());
								parameterComment.setIndex(getIndex(entity
										.getParameter(), pairs.getKey()
										.toString()));
								parameterCommentsList.add(parameterComment);

							} else if (entity.getPreStep() != null) {
								functionComment = new FunctionComment();
								functionComment.setPreStep(entity.getPreStep());
								functionComment.setLevel(entity.getLevel());

								functionCommentsList.add(functionComment);

							} else if (entity.getPostStep() != null) {
								functionComment = new FunctionComment();
								functionComment
										.setPostStep(entity.getPreStep());
								functionComment.setLevel(entity.getLevel());

								functionCommentsList.add(functionComment);

							} else if (entity.getVariable() != null) {
								parameterComment = new ParameterComment();
								parameterComment.setParameterName(entity
										.getVariable());
								parameterComment.setSecurityType(entity
										.getSecurityType().toString());
								parameterComment.setIndex(getIndex(entity
										.getParameter(), pairs.getKey()
										.toString()));

								parameterCommentsList.add(parameterComment);
							} else {
								MyLogger.log_parser("singleline SecurityType: null ");
							}

						}
					}
				}
				// add the comments lists to the commentsMap
				MyLogger.log_parser("key: " + pairs.getKey().toString());
				commentsMap.put(pairs.getKey().toString(), comment);
				it.remove(); // avoids a ConcurrentModificationException
				// printMap(commentsMap);
			}
		}
		return commentsMap;
	}

	/**
	 * Prints the comments.
	 * 
	 * @param comment1
	 *            the comment1
	 * @param index
	 *            the index
	 */
	public void printComments(String comment1, int index) {
		System.out.println("Comment: " + index + " \n " + comment1);
	}

	/**
	 * Prints the map.
	 * 
	 * @param mp
	 *            the mp
	 */
	public static void printMap(Map<?, ?> mp) {
		@SuppressWarnings("rawtypes")
		Iterator it = mp.entrySet().iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry pairs = (Map.Entry) it.next();
			System.out.println(pairs.getKey() + " Contains: "
					+ pairs.getValue());
			if (pairs.getValue() instanceof Comment) {
				Comment comment = (Comment) pairs.getValue();
				// ptint type of the comment
				MyLogger.log_parser(" Comemnt type: " + comment.getType());

				// print function comments
				ArrayList<FunctionComment> objects = comment
						.getFunctionComments();
				for (FunctionComment object : objects) {
					if (object != null) {
						MyLogger.log_parser(" Function type: "
								+ object.getType() + " Atributte: "
								+ object.getAtribute());
					}
				}

				// print parameter comments
				ArrayList<ParameterComment> objects2 = comment
						.getParameterComments();
				for (ParameterComment object : objects2) {
					if (object != null) {
						MyLogger.log_parser(" Paramter type: "
								+ object.getType() + " Parameter Name: "
								+ object.getParameterName()
								+ " Security Type: " + object.getSecurityType()
								+ " Parameter Index: " + object.getIndex());
					}
				}
			}
			System.out.println("\n");
			it.remove(); // avoids a ConcurrentModificationException
		}
	}

	/**
	 * Gets the index.
	 * 
	 * @param parameterName
	 *            the parameter name
	 * @param functionSignature
	 *            the function signature
	 * @return the index
	 */
	private int getIndex(String parameterName, String functionSignature) {
		int index = 0;
		if (functionSignature.contains(parameterName)) {
			String str = functionSignature;
			String substr = parameterName;
			String[] parts = str.split(substr);
			String before = parts[0];
			index = before.split(",").length - 1;
		}
		return index;
	}

}
package smtcodan.quickfixes.introduceimpl;

import org.eclipse.osgi.util.NLS;

// TODO: Auto-generated Javadoc
/**
 * The Class Messages.
 */
public class Messages extends NLS {

	/** The Constant BUNDLE_NAME. */
	private static final String BUNDLE_NAME = "org.eclipse.cdt.internal.ui.refactoring.introducepimpl.messages";//$NON-NLS-1$

	/**
	 * Instantiates a new messages.
	 */
	private Messages() {
		// Do not instantiate
	}

	/** The choice3. */
	public static String dummy_message = "bla will be removed in future";

	/** The refactory_message. */
	public static String refactory_message = "Size is not equal to actual number of refactors";

	/** For choosing the option. */
	public static String IntroduceBufferOverflow_Choosetheoption = "Choose one among the options";

	/** The Introduce p impl_ rewrite_ include insert. */
	public static String IntroducePImpl_Rewrite_IncludeInsert = "include insert";

	/** The Introduce p impl_ rewrite_ impl class insert source. */
	public static String IntroducePImpl_Rewrite_ImplClassInsertSource = "class insert source";

	/** The Constant IntroducePImpl_Rewrite_NamespaceInserted. */
	public static final String IntroducePImpl_Rewrite_NamespaceInserted = "Namespace inserted";

	public static final String IntroduceRaceCondition_Choosetheoption = "Choose the option below";
	
	public static final String IntroduceInformationExposure_Choosetheoption = "Choose the option below";

	static {
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}
}
/*
 * 
 */
package smtcodan.checkers;

import org.eclipse.cdt.codan.ui.AbstractCodanProblemDetailsProvider;

// TODO: Auto-generated Javadoc
/**
 * The Class InformationExposureErrorHelp.
 */
public class HardCodedPasswordHelper extends
		AbstractCodanProblemDetailsProvider {

	/**
	 * Instantiates a new bound error help.
	 */
	public HardCodedPasswordHelper() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.codan.ui.AbstractCodanProblemDetailsProvider#
	 * getStyledProblemDescription()
	 */
	public String getStyledProblemDescription() {
		String args[] = getProblemArguments();
		String superarg = super.getStyledProblemDescription();
		return args[1];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.cdt.codan.ui.AbstractCodanProblemDetailsProvider#
	 * getStyledProblemMessage()
	 */
	public String getStyledProblemMessage() {
		String location = getLocation();
		String locationRef = getLocationHRef();
		String args[] = getProblemArguments();
		return super.getStyledProblemMessage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.cdt.codan.ui.AbstractCodanProblemDetailsProvider#isApplicable
	 * (java.lang.String)
	 */
	@Override
	public boolean isApplicable(String id) {
		return BoundsChecker.problemid.equalsIgnoreCase(id);
	}

}

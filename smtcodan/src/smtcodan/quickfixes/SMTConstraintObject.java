package smtcodan.quickfixes;

// TODO: Auto-generated Javadoc
/**
 * The Class SMTConstraintObject.
 */
public class SMTConstraintObject {

	/** The buffer size. */
	private String bufferSize;

	/** The linear system. */
	private String linearSystem;

	/** The offset. */
	private String offset;

	/**
	 * Instantiates a new sMT constraint object.
	 * 
	 * @param bufferSize
	 *            the buffer size
	 * @param linearSystem
	 *            the linear system
	 * @param offset
	 *            the offset
	 */
	public SMTConstraintObject(String bufferSize, String linearSystem,
			String offset) {
		super();
		this.offset = offset;
		this.bufferSize = bufferSize;
		this.linearSystem = linearSystem;
	}

	/**
	 * Gets the offset.
	 * 
	 * @return the offset
	 */
	public String getOffset() {
		return offset;
	}

	/**
	 * Sets the offset.
	 * 
	 * @param offset
	 *            the new offset
	 */
	public void setOffset(String offset) {
		this.offset = offset;
	}

	/**
	 * Gets the buffer size.
	 * 
	 * @return the buffer size
	 */
	public String getBufferSize() {
		return bufferSize;
	}

	/**
	 * Sets the buffer size.
	 * 
	 * @param bufferSize
	 *            the new buffer size
	 */
	public void setBufferSize(String bufferSize) {
		this.bufferSize = bufferSize;
	}

	/**
	 * Gets the linear system.
	 * 
	 * @return the linear system
	 */
	public String getLinearSystem() {
		return linearSystem;
	}

	/**
	 * Sets the linear system.
	 * 
	 * @param linearSystem
	 *            the new linear system
	 */
	public void setLinearSystem(String linearSystem) {
		this.linearSystem = linearSystem;
	}

}

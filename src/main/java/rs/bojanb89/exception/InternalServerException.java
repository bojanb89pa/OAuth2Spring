package rs.bojanb89.exception;

public class InternalServerException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3635219033961737501L;


	public InternalServerException(int code, String description) {
		super(code, description);
	}
}

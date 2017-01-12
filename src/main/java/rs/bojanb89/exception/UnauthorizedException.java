package rs.bojanb89.exception;

public class UnauthorizedException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8533044270848487864L;

	public UnauthorizedException(int code, String description) {
		super(code, description);
	}
}

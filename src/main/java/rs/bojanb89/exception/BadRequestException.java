package rs.bojanb89.exception;

public class BadRequestException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5324903659620508699L;
	
	public BadRequestException(int code, String description) {
		super(code, description);
	}

}

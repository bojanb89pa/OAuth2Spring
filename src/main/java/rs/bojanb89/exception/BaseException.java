package rs.bojanb89.exception;

import rs.bojanb89.exception.code.ErrorCode;
import rs.bojanb89.exception.code.ExceptionCode;

public class BaseException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2180976082364154665L;
	
	public BaseException(int code, String description) {
		super(description);
		this.code = new ErrorCode(code);
//	    log.error("Error: {}", description);
	}

	protected ExceptionCode code;

	public ExceptionCode getCode() {
		return code;
	}
	
	
}

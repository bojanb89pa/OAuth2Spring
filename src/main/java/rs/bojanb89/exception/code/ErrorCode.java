package rs.bojanb89.exception.code;

public class ErrorCode extends ExceptionCode {

	public static final int BAD_REQUEST_DATA = 40000;
	public static final int BAD_REQUEST_PARAMS = 40001;

	public static final int USER_EXISTS = 40300;

	/**
	 * @param code
	 */
	public ErrorCode(int code) {
		super(ErrorCode.class.getDeclaredFields(), code);
		if (codeMessage == null || codeMessage.equals("") || code == DEFAULT_CODE) {
			codeMessage = "Internal server error!";
		}
	}
}

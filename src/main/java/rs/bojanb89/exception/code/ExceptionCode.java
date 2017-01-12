package rs.bojanb89.exception.code;

import java.lang.reflect.Field;

public class ExceptionCode {

	public static final int DEFAULT_CODE = 50000;

	protected int code;

	protected String codeMessage;

	/**
	 * @param class1
	 * @param code
	 */
	public ExceptionCode(Field[] flds, int code) {
		this.code = code;

		Field field = null;

		for (Field fld : flds) {
			try {
				int codeForField = fld.getInt(new Integer(0));
				if (codeForField == code) {
					field = fld;
					break;
				}
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}

		if (field != null) {
			codeMessage = field.getName();
		}
	}

	/**
	 * 
	 * Constructor for changing default message
	 * 
	 * @param message
	 */
	public ExceptionCode(String codeMessage) {
		this.code = DEFAULT_CODE;
		this.codeMessage = codeMessage;
	}

	public int getCode() {
		return code;
	}

	public String getCodeMessage() {
		return codeMessage;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append(code).append("_").append(codeMessage);
		return sb.toString();
	}
}

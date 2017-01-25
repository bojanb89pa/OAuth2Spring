package rs.bojanb89.datamodel.to;

public class ExceptionTO {

	public int code;
	public String error;

	public ExceptionTO() {
	}

	public ExceptionTO(int code, String error) {
		super();
		this.code = code;
		this.error = error;
	}
}

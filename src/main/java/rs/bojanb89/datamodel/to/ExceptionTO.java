package rs.bojanb89.datamodel.to;

public class ExceptionTO {

	public int code;
	public String codeMessage;

	public ExceptionTO() {
	}

	public ExceptionTO(int code, String codeMessage) {
		super();
		this.code = code;
		this.codeMessage = codeMessage;
	}
	
	
}

package LoginExection;

public class LoginExection  extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 异常信息
	private String message;
	public LoginExection() {
		super();
	}
	public LoginExection(String message) {
		super();
		this.message = message;
		
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

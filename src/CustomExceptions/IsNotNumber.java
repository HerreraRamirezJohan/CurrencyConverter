package CustomExceptions;

public class IsNotNumber extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3481834457259079342L;
	
	public IsNotNumber() {
		super();
	}
	public IsNotNumber(String msg) {
		super(msg);
	}
}

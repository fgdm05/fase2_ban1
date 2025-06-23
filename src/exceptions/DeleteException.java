package exceptions;

public class DeleteException extends Exception {

	public DeleteException() {super();}
	public DeleteException(String msg) {super(msg);}
	public DeleteException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
}
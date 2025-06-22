package exceptions;

public class AbastecimentoException extends Exception {
	public AbastecimentoException() {}
	public AbastecimentoException(String msg) {super(msg);}
	public AbastecimentoException(String msg, Throwable cause) {super(msg, cause);}
}
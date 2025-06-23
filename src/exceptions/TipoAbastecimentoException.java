package exceptions;

public class TipoAbastecimentoException extends AbastecimentoException {
	public TipoAbastecimentoException() {super();}
	public TipoAbastecimentoException(String msg) {super(msg);}
	public TipoAbastecimentoException(String msg, Throwable cause) {super(msg, cause);}
}
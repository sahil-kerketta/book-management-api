package jsp.springboot.SpringBoot_Crud.Exception;

public class IdNotFoundException extends RuntimeException {
	public IdNotFoundException(String msg) {
		super(msg);
	}
}

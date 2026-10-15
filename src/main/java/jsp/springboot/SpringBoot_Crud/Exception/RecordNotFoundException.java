package jsp.springboot.SpringBoot_Crud.Exception;

public class RecordNotFoundException extends RuntimeException {
	public RecordNotFoundException(String message) {
		super(message);
	}
	
}

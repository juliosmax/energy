package vistra.energy.retailer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class UnitNotFoundException extends RuntimeException {

	public UnitNotFoundException(String message) {
		super(message);
	}
	
}

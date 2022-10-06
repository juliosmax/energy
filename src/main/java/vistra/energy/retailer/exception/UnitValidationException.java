package vistra.energy.retailer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class UnitValidationException extends RuntimeException {

	public UnitValidationException(String message) {
		super(message);
	}
}

package vistra.test.energy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class BadDateTimeException extends RuntimeException {
	public BadDateTimeException(String message) {
		super(message);
	}
}

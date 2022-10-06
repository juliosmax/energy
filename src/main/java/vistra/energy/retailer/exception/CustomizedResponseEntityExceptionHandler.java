package vistra.energy.retailer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import vistra.energy.retailer.dto.ErrorDetails;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		return new ResponseEntity(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BadDateTimeException.class)
	public final ResponseEntity<ErrorDetails> handleBadDateTimeException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnitNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUnitNotFoundException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		return new ResponseEntity(errorDetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UnitValidationException.class)
	public final ResponseEntity<ErrorDetails> handleUnitValidationException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(ex.getMessage());
		return new ResponseEntity(errorDetails,HttpStatus.BAD_REQUEST);
	}

}
package br.com.luxfacta.controlleradvice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice	
public class GlobalExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErrorResponse> handle(MethodArgumentNotValidException exception) {
		List<ErrorResponse> erros = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e -> {
			String message = messageSource.getMessage(e, LocaleContextHolder.getLocale());
			ErrorResponse error = new ErrorResponse(message, e.getField());
			erros.add(error);
		});
		return erros;
	}
	
	@ExceptionHandler( CustomNotFoundException.class )
	public ResponseEntity<?> handlePollNotFoundException(CustomNotFoundException ex) {
		return ResponseEntity.notFound().build();
	}
	
}

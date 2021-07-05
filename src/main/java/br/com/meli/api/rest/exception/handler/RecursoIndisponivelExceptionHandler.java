package br.com.meli.api.rest.exception.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.meli.api.rest.dto.ExceptionDTO;
import br.com.meli.api.rest.exception.RecursoIndisponivelException;

@ControllerAdvice
public class RecursoIndisponivelExceptionHandler {
	
	@ExceptionHandler(RecursoIndisponivelException.class)
	//@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<ExceptionDTO> defaultHandler(RecursoIndisponivelException e){
		return ResponseEntity.badRequest().body(new ExceptionDTO(e.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<ExceptionDTO>> defaultHandler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ExceptionDTO> processFieldErrors = processFieldErrors(fieldErrors);
        return ResponseEntity.badRequest().body(processFieldErrors);
	}
	
    private List<ExceptionDTO> processFieldErrors(List<FieldError> fieldErrors) {
    	List<ExceptionDTO> listaDtos = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
        	listaDtos.add(new ExceptionDTO(fieldError.getField(), fieldError.getDefaultMessage()));
            
        }
        return listaDtos;
    }
	
}

package rs.bojanb89.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import rs.bojanb89.datamodel.to.ExceptionTO;


@ControllerAdvice
public class GlobalExceptionController {

	  @ExceptionHandler(BadRequestException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  @ResponseBody
	  public ExceptionTO handleBadRequestException(BadRequestException ex) {

	    return handleBaseException(ex);

	  }

	  @ExceptionHandler(UnauthorizedException.class)
	  @ResponseStatus(HttpStatus.UNAUTHORIZED)
	  @ResponseBody
	  public ExceptionTO handleUnauthorizedException(UnauthorizedException ex) {

	    return handleBaseException(ex);

	  }

	  @ExceptionHandler(ForbiddenException.class)
	  @ResponseStatus(HttpStatus.FORBIDDEN)
	  @ResponseBody
	  public ExceptionTO handleForbiddenException(ForbiddenException ex) {

	    return handleBaseException(ex);

	  }

	  @ExceptionHandler(InternalServerException.class)
	  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	  @ResponseBody
	  public ExceptionTO handleInternalException(InternalServerException ex) {

	    return handleBaseException(ex);

	  }

	  @ExceptionHandler(BaseException.class)
	  @ResponseBody
	  public ExceptionTO handleBaseException(BaseException ex) {

		    return new ExceptionTO(ex.getCode().getCode(), ex.getCode().toString());

	  }

}

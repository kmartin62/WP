package test1.demo.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by @kmartin62
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmptyParameteresException extends Exception {
}

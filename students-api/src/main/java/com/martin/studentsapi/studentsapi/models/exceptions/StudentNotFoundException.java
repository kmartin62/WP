package com.martin.studentsapi.studentsapi.models.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by @kmartin62
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends Exception {
}

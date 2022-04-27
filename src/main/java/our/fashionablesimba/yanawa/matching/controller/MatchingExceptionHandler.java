package our.fashionablesimba.yanawa.matching.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import our.fashionablesimba.yanawa.common.errorhandler.CommonExceptionHandler;
import our.fashionablesimba.yanawa.common.errorhandler.ErrorCode;
import our.fashionablesimba.yanawa.common.errorhandler.ErrorResponse;
import our.fashionablesimba.yanawa.matching.exception.NotFoundMatchingException;

import java.util.List;

@RestControllerAdvice
@CrossOrigin
public class MatchingExceptionHandler extends CommonExceptionHandler {

    @ExceptionHandler(value = {NotFoundMatchingException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodNotFoundDataException(Exception e) {
        return buildError(ErrorCode.NOT_FOUND_MATCHING);
    }

    @ExceptionHandler(value = {IllegalStateException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodIllegalStateException(Exception e) {
        return buildError(e, HttpStatus.BAD_REQUEST);
    }

}

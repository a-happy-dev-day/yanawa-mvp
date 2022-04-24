package our.fashionablesimba.yanawa.user.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import our.fashionablesimba.yanawa.common.errorhandler.CommonExceptionHandler;
import our.fashionablesimba.yanawa.common.errorhandler.ErrorCode;
import our.fashionablesimba.yanawa.common.errorhandler.ErrorResponse;
import our.fashionablesimba.yanawa.user.exception.EmailDuplicationException;
import our.fashionablesimba.yanawa.user.exception.LoginFailedException;
import our.fashionablesimba.yanawa.user.exception.UserNotFoundException;

@RestControllerAdvice
@Slf4j
public class UserExceptionHandler extends CommonExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return buildFieldErrors(ErrorCode.INPUT_VALUE_INVALID, e.getFieldErrors());
    }

    @ExceptionHandler(value = {
            EmailDuplicationException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorResponse handleBoardNotFoundException(EmailDuplicationException e) {

        final ErrorCode accountNotFound = ErrorCode.EMAIL_DUPLICATION;
        log.error(accountNotFound.getMessage(), e.getMessage());
        return buildError(accountNotFound);
    }

    @ExceptionHandler(value = {
            UserNotFoundException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorResponse handleUserNotFoundException(UserNotFoundException e) {

        final ErrorCode accountNotFound = ErrorCode.ACCOUNT_NOT_FOUND;
        log.error(accountNotFound.getMessage(), e.getMessage());
        return buildError(accountNotFound);
    }

    @ExceptionHandler(value = {
            LoginFailedException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorResponse handleLoginFailedException(LoginFailedException e) {

        final ErrorCode loginFailed = ErrorCode.LOGIN_FAILED;
        log.error(loginFailed.getMessage(), e.getMessage());
        return buildError(loginFailed);
    }

}

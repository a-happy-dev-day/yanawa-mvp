package our.fashionablesimba.yanawa.user.error;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import our.fashionablesimba.yanawa.user.domain.User;
import our.fashionablesimba.yanawa.user.exception.EmailDuplicationException;
import our.fashionablesimba.yanawa.user.exception.LoginFailedException;
import our.fashionablesimba.yanawa.user.exception.UserNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
@Slf4j
public class ErrorExceptionController {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        final List<ErrorResponse.FieldError> fieldErrors = getFieldErrors(e.getBindingResult());
        return buildFieldErrors(ErrorCode.INPUT_VALUE_INVALID, fieldErrors);
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

        final ErrorCode loginFaild = ErrorCode.LOGIN_FAILD;
        log.error(loginFaild.getMessage(), e.getMessage());
        return buildError(loginFaild);
    }

//    @ExceptionHandler(PasswordFailedExceededException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    protected ErrorResponseDto handlePasswordFailedExceededException(PasswordFailedExceededException e) {
//        log.error(e.getMessage());
//        return buildError(e.getErrorCode());
//    }

    private List<ErrorResponse.FieldError> getFieldErrors(BindingResult bindingResult) {
        final List<FieldError> errors = bindingResult.getFieldErrors();
        return errors.parallelStream()
                .map(error -> ErrorResponse.FieldError.builder()
                        .reason(error.getDefaultMessage())
                        .field(error.getField())
                        .value((String) error.getRejectedValue())
                        .build())
                .collect(Collectors.toList());
    }

    private ErrorResponse buildError(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .status(errorCode.getStatus())
                .message(errorCode.getMessage())
                .build();
    }

    private ErrorResponse buildFieldErrors(ErrorCode errorCode, List<ErrorResponse.FieldError> errors) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .status(errorCode.getStatus())
                .message(errorCode.getMessage())
                .errors(errors)
                .build();
    }
}

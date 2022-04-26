package our.fashionablesimba.yanawa.common.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

public abstract class CommonExceptionHandler {
    protected ErrorResponse buildError(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .status(errorCode.getStatus())
                .message(errorCode.getMessage())
                .build();
    }

    protected ErrorResponse buildError(Exception e, HttpStatus status) {
        return ErrorResponse.builder()
                .code("???")
                .status(status)
                .message(e.getMessage())
                .build();
    }

    protected ErrorResponse buildFieldErrors(ErrorCode errorCode, List<FieldError> errors) {
        return ErrorResponse.builder()
                .code(errorCode.getCode())
                .status(errorCode.getStatus())
                .message(errorCode.getMessage())
                .errors(errors)
                .build();
    }

    protected List<FieldError> getFieldErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .parallelStream().collect(Collectors.toList());
    }
}

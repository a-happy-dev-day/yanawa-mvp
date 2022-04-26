package our.fashionablesimba.yanawa.common.errorhandler;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ErrorResponse {
    private String message;
    private String code;
    private HttpStatus status;
    private List<FieldError> errors;

    @Builder
    public ErrorResponse(String message, String code, HttpStatus status, List<FieldError> errors) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.errors = initErrors(errors);
    }

    private List<FieldError> initErrors(List<FieldError> errors) {
        return (errors == null) ? new ArrayList<>() : errors;
    }

}

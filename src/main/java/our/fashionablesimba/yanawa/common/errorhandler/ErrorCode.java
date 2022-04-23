package our.fashionablesimba.yanawa.common.errorhandler;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    ACCOUNT_NOT_FOUND("AC_001", "해당 회원을 찾을 수 없습니다.", HttpStatus.NOT_FOUND),
    EMAIL_DUPLICATION("AC_001", "이메일이 중복되었습니다.", HttpStatus.BAD_REQUEST),
    INPUT_VALUE_INVALID("???", "입력값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST),
    LOGIN_FAILED("???", "이메일 또는 비밀번호를 잘못 입력했습니다", HttpStatus.BAD_REQUEST),
    PASSWORD_FAILED_EXCEEDED("???", "비밀번호 실패 횟수가 초과했습니다.", HttpStatus.BAD_REQUEST),
    NOT_FOUND_MATCHING("???", "메칭이 존재하지 않습니다.", HttpStatus.BAD_REQUEST);


    private final String code;
    private final String message;
    private final HttpStatus status;

    ErrorCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

}

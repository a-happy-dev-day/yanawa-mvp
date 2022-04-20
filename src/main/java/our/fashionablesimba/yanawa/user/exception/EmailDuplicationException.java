package our.fashionablesimba.yanawa.user.exception;

import our.fashionablesimba.yanawa.user.domain.Email;

import javax.validation.Valid;

public class EmailDuplicationException extends RuntimeException {
    public EmailDuplicationException(@Valid Email email) {
    }
}

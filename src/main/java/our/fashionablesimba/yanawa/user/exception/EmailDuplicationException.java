package our.fashionablesimba.yanawa.user.exception;

import our.fashionablesimba.yanawa.user.domain.Email;

public class EmailDuplicationException extends RuntimeException {

    private Email email;
    public EmailDuplicationException(Email email) {
        this.email = email;
    }
}

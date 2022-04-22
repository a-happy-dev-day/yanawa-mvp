package our.fashionablesimba.yanawa.user.exception;

import our.fashionablesimba.yanawa.user.domain.Email;

public class LoginFailedException extends RuntimeException {

    private Email email;
    public LoginFailedException(Email email) {
        this.email = email;
    }
}

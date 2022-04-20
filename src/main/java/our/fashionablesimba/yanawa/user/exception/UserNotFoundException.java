package our.fashionablesimba.yanawa.user.exception;

public class UserNotFoundException extends RuntimeException{
    private Long id;


    public UserNotFoundException(Long id) {
        this.id = id;
    }
}

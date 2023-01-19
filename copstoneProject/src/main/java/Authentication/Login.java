package Authentication;
import java.io.IOException;


public class Login {
    public boolean login(String userName , String password ) throws IOException {
    return new Validator(userName,password).isValid();
    }
}

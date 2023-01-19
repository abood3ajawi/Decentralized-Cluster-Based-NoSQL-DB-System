package Authentication;

public class Token {
    private final String token;
    public Token(String name , String password){
        token = generateToken( name , password);
    }
    private String generateToken(String name , String password){
        final String secretKey = "ssshhhhhhhhhhh!!!!";
        return   AES.encrypt(name+password, secretKey);
    }
    public String getToken(){
        return token;
    }
}

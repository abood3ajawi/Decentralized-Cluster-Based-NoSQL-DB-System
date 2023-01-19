package Authentication;

import FileSystemUtilities.IO.ReadFile;
import org.json.JSONArray;

import java.io.IOException;

public class Validator {
    private boolean valid;
    Validator(String userName , String password) throws IOException {
        JSONArray user =  getUsers();
        for (int i = 0; i < user.length(); i++) {
            valid =   userName.equals(user.getJSONObject(i).getString("name")) && password.equals(user.getJSONObject(i).getString("password"));
            if(valid) break;
        }
    }
    // /home/abood/Desktop/Storge/
    private JSONArray  getUsers() throws IOException {
        return new ReadFile("/volume").readFile("user.json").optJSONArray("users");
    }
    boolean isValid(){
        return valid;
    }

}
// /volume
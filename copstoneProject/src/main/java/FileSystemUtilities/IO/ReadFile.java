package FileSystemUtilities.IO;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile extends FileOperation {
    public ReadFile(String path){
        super(path);
    }
    public  JSONObject readFile(String name) throws IOException {
        String fileContent =new String(Files.readAllBytes(Paths.get(getPath()+"/"+name)));
       if( fileContent.equals(""))
        return new JSONObject( "{}");
       else return new JSONObject( fileContent);
    }
}

package FileSystemUtilities.CDFileSystem;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.UUID;

public class FileName {
    private final String path;
    private final UUID uuid;

    FileName(String path){
        this.path = path;
        this.uuid = UUID.randomUUID();
    }
    public String getFileName(){
        String fileName = path+"/"+uuid ;
        return Base64.getUrlEncoder().encodeToString(fileName.getBytes(StandardCharsets.UTF_8));
    }
}

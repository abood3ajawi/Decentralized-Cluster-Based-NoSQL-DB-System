package FileSystemUtilities.CDFileSystem;

import FileSystemUtilities.IO.ReadFile;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;

public class RemoveFile {
    String path ;
    public RemoveFile(String path){
        this.path = path;
    }
    public void remove(String filename) throws IOException {
        new File(path+"/"+filename).delete();
    }

    }

package FileSystemUtilities.IO;
import Affinity.Affinity;
import Broadcaste.Broadcasting;
import FileSystemUtilities.CDFileSystem.FileCreation;
import Indexing.Indexing;
import ObjectUtilities.KeyValueObject;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;


public class WriteFile extends FileOperation {
    public  WriteFile(String path){
        super(path);
    }
    public  synchronized void Write(KeyValueObject... objects) throws IOException {
        System.out.println(getPath());
        FileCreation fileCreation = new FileCreation(getPath());
        File file = fileCreation.createFile();
        System.out.println(file.getName());
        JSONObject temporaryJSONObject = new JSONObject();
        temporaryJSONObject.put("id",file.getName());
        //temporaryJSONObject.put("affinity",new Affinity().value());
        for(KeyValueObject object : objects ){
            temporaryJSONObject.put(object.getKey(),object.getValue());
        }
        FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
        fileWriter.write(temporaryJSONObject.toString());
        fileWriter.flush();
        fileWriter.close();
        needUpdateIndex(file.getName(),objects);

    }
    private synchronized void needUpdateIndex (String id, KeyValueObject ... objects) throws IOException {
        File files = new File(getPath()+"/index");
        Indexing index= new Indexing();
        for (KeyValueObject object  : objects){
         for(File file : Objects.requireNonNull(files.listFiles())){
             if(Objects.equals(object.getKey(), file.getName())){
                 index.putIndex(getPath(),object.getKey(),object.getValue(),id);
             }
         }
        }
    }
}


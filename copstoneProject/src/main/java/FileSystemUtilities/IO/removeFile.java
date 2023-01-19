package FileSystemUtilities.IO;

import FileSystemUtilities.CDFileSystem.RemoveFile;
import ObjectUtilities.KeyValueObject;
import logicOperator.Operator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Set;

public class removeFile extends ReaderDecorator {
    public removeFile(FileOperation fileOperation){
        super(fileOperation);
    }
    public void remove(Operator expression) throws IOException {
//        File[] files =  new File(this.getPath()).listFiles();
//        for (int i = 0; i < Objects.requireNonNull(files).length ; i++) {
//            if(!files[i].isDirectory()) {
//                JSONObject temporaryJSONObject = ((ReadFile) fileOperation).readFile(files[i].getName());
//                expression.existInFile(temporaryJSONObject);
//                if (expression.execute()) {
//                    removeIndex(files[i].getName());
//                 new RemoveFile(getPath()).remove(files[i].getName());
//                }
//            }
//
//        }
    }
//    private void removeIndex(String fileName) throws IOException {
//        File[] files = new File(getPath() + "/index/").listFiles();
//        Set<String> keys = new ReadFile(getPath()).readFile(fileName).keySet();
//        for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
//            if(keys.contains(files[i].getName().replace(".json",""))){
//                JSONObject data =  (new ReadFile(getPath()+"/index/").readFile(files[i].getName()));
//                JSONArray arrayData = data.getJSONArray(files[i].getName().replace(".json",""));
//                for (int j = 0; j < data.length(); j++) {
//                    if(arrayData.getJSONObject(j).get("id").equals(fileName)){
//                        arrayData.remove(j);
//                    }
//                }
//                FileWriter file = new FileWriter(files[i].getAbsolutePath());
//                file.write(data.toString());
//                file.flush();
//                file.close();
//            }
//        }
//    }
}

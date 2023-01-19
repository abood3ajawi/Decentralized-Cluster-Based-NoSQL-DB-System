package FileSystemUtilities.IO;

import ObjectUtilities.KeyValueObject;
import logicOperator.Operator;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class UpdateFile extends ReaderDecorator {
    public UpdateFile(FileOperation fileOperation){
        super(fileOperation);
    }
    public synchronized void update(Operator expression, KeyValueObject... objects) throws IOException {
        File[] files =  new File(this.getPath()).listFiles();
        for (int i = 0; i < Objects.requireNonNull(files).length ; i++) {
            if(!files[i].isDirectory()) {
                JSONObject temporaryJSONObject = ((ReadFile) fileOperation).readFile(files[i].getName());
                expression.existInFile(temporaryJSONObject);
                if (expression.execute()) {
                    for (KeyValueObject object : objects) {
                        if (temporaryJSONObject.has(object.getKey())) {
                            temporaryJSONObject.put(object.getKey(), object.getValue());
                        }
                    }
                    try {
                        FileWriter file = new FileWriter(files[i].getAbsolutePath());
                        System.out.println(temporaryJSONObject.toString());
                        file.write(temporaryJSONObject.toString());
                        file.flush();
                        file.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    needUpdateIndex(files[i].getName(),objects);
                }
            }

        }
    }
    private synchronized void needUpdateIndex(String id, KeyValueObject ... objects) throws IOException {
        for(KeyValueObject object : objects ) {
            JSONObject data =  new ReadFile(getPath() + "/index/" ).readFile(object.getKey()+".json");
            System.out.println(data.toString());
            JSONArray updatedData =  data.getJSONArray(object.getKey());
            System.out.println(updatedData.toString());
            for (int i = 0;i<updatedData.length();i++){
                if(Objects.equals(updatedData.getJSONObject(i).getString("id"), id)){
                    System.out.println(updatedData.getJSONObject(i));
                    JSONObject tmp =  updatedData.getJSONObject(i);
                    tmp.put(object.getKey(),object.getValue());
                }
            }
            FileWriter file =  new FileWriter(getPath()+"/index/"+object.getKey()+".json");
            file.write(data.toString());
            file.close();
        }

    }
}

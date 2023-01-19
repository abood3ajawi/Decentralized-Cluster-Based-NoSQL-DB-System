package Indexing;

import FileSystemUtilities.CDFileSystem.FileCreation;
import FileSystemUtilities.IO.FindAll;
import FileSystemUtilities.IO.ReadFile;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Indexing {
    public void createIndex(String path,String key) throws IOException {
        FileWriter file = new FileWriter(path+"/index/"+key+".json");
        JSONObject data = new JSONObject();
        data.put(key,new FindAll(new ReadFile(path)).findAllByKeyNameID(key));
        file.write(data.toString());
        file.close();
    }
    public void putIndex(String path , String key,String value , String id ) throws IOException {
        JSONObject data = new ReadFile(path+"/index").readFile(key+".json");
        JSONArray keyArray = data.getJSONArray(key);
        JSONObject newData = new JSONObject();
        newData.put("id",id);
        newData.put(key,value);
        keyArray.put(newData);
        System.out.println(data);
        FileWriter file =  new FileWriter(path+"/index/"+key+".json");
        file.write(data.toString());
        file.close();
        updateID(id,path);
    }
    public void updateID(String id , String path) throws IOException {
        JSONObject data = new ReadFile(path+"/index").readFile("id"+".json");
        JSONArray keyArray = data.getJSONArray("id");
        JSONObject newData = new JSONObject();
        newData.put("id",id);
        keyArray.put(newData);
        System.out.println(data);
        FileWriter file =  new FileWriter(path+"/index/id.json");
        file.write(data.toString());
        file.close();
    }
    public void removeIndex(String path , String fileName) throws IOException {
        File[] files = new File(path + "/index/").listFiles();
        Set<String> keys = new ReadFile(path).readFile(fileName).keySet();
        for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
            if(keys.contains(files[i].getName().replace(".json",""))){
                JSONObject data =  (new ReadFile(path+"/index/").readFile(files[i].getName()));
                JSONArray arrayData = data.getJSONArray(files[i].getName().replace(".json",""));
                for (int j = 0; j < data.length(); j++) {
                    if(arrayData.getJSONObject(j).get("id").equals(fileName)){
                        arrayData.remove(j);
                    }
                }
                FileWriter file = new FileWriter(files[i].getAbsolutePath());
                file.write(data.toString());
                file.flush();
                file.close();
            }
        }
    }

}

package FileSystemUtilities.IO;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;


public class FindAll extends ReaderDecorator{
   public FindAll(FileOperation fileOperation){
        super(fileOperation);
    }
    public  ArrayList<JSONObject> findAll() throws IOException {
        File[] files =  new File(getPath()).listFiles();
        System.out.println(getPath());
        ArrayList<JSONObject> data = new ArrayList<>();
        System.out.println(files);
        for (int i = 0; i < Objects.requireNonNull(files).length ; i++) {
            if(!files[i].isDirectory())
             data.add( ((ReadFile) fileOperation).readFile(files[i].getName()));
        }
       return  data ;
    }
    public   ArrayList<JSONObject> findAllByKeyName(String ... keys) throws IOException{
       ArrayList<JSONObject> data = findAll();
        ArrayList<JSONObject> filterData = new ArrayList<>();
        JSONObject tmp = null;
       for(JSONObject record : data ){
           tmp = new JSONObject();
           for(String key : keys) {
               if(record.has(key)) {
                   tmp.put(key, record.get(key));
               }
           }
           filterData.add(tmp);
       }
       return  filterData;
    }
    public   ArrayList<JSONObject> findAllByKeyNameID(String  key) throws IOException{
        ArrayList<JSONObject> data = findAll();
        ArrayList<JSONObject> filterData = new ArrayList<>();
        JSONObject tmp = null;
        ///System.out.println(data.toString());
        for(JSONObject record : data ){
                if(record.has(key)) {
                    tmp = new JSONObject();
                    tmp.put("id", record.get("id"));
                    tmp.put(key, record.get(key));
                    filterData.add(tmp);
                    System.out.println(filterData.toString());

                }

        }
        return  filterData;
    }
}

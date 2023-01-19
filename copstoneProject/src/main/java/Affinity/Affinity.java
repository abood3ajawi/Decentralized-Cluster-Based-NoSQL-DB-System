package Affinity;

import FileSystemUtilities.IO.ReadFile;
import FileSystemUtilities.IO.WriteFile;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Affinity {

    public  int value() throws IOException {
        JSONObject data = new ReadFile("/home/abood/Desktop/Storge/").readFile("affinity.json");
        int node1 = data.getInt("affinitynode1");
        int node2 = data.getInt("affinitynode2");
        int node3 = data.getInt("affinitynode3");
        int node4 = data.getInt("affinitynode4");
        int[] affinity ={node1,node2,node3,node4};
        int min = node1;
        for (int i = 1 ; i < 5 ; i++){
            if(affinity[i]<min){
                min =affinity[i];
                data.put("affinitynode"+i,data.getInt("affinitynode"+i)+1);
                synchronized(this) {
                   FileWriter f =  new FileWriter("/home/abood/Desktop/Storge/");
                   f.write(data.toString());
                   f.close();
                }
                return min;
            }
        }
        data.put("affinitynode1",min+1);
        synchronized(this) {
            FileWriter f =  new FileWriter("/home/abood/Desktop/Storge/");
            f.write(data.toString());
            f.close();
        }
        return min;
    }
}

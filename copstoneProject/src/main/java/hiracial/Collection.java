package hiracial;

import Broadcaste.Broadcasting;
import FileSystemUtilities.CDFileSystem.RemoveFile;
import FileSystemUtilities.IO.*;
import Indexing.Indexing;
import NodeInterface.CollectionInterface;
import ObjectUtilities.KeyValueObject;
import ObjectUtilities.pathAnalysis;
import logicOperator.Operator;
import org.json.JSONObject;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.io.IOException;
import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Collection extends UnicastRemoteObject implements CollectionInterface {
    private static final long serialVersionUID = 1L;
    private final String path;
    private String userName = null;
    private String password = null;
   public Collection(String path) throws RemoteException {
       super();
       this.path = path;
   }
    public String  findAll() throws IOException {
        return new FindAll(new ReadFile(path)).findAll().toString();
    }
    public String find(Operator expression) throws IOException {
        return new Find(new ReadFile(path)).find(expression).toString();
    }
    public void createDocument(KeyValueObject...data) throws IOException {
        System.out.println("lol");
        new WriteFile(path).Write(data[0]);
        System.out.println("ddddddddddddddd"+data[1].getValue());
        System.out.println(InetAddress.getLocalHost().getHostAddress());
        System.out.println(data[1].getValue() == InetAddress.getLocalHost().getHostAddress());
        if("10.2.0.2".contains(InetAddress.getLocalHost().getHostAddress())) {
            new Broadcasting().broadcastWriteData(userName, password, new pathAnalysis(path), data);
        }
    }
    public void Update(Operator expression , KeyValueObject data) throws IOException {
        new UpdateFile(new ReadFile(path)).update(expression,data);
    }
    public void deleteDocument(Operator expression) throws IOException {
        ArrayList<JSONObject> data = new Find(new ReadFile(path)).find(expression);
        RemoveFile file = new RemoveFile(path);
        for (JSONObject id :data) {
             new Indexing().removeIndex(path,id.getString("id"));
             file.remove(id.getString("id"));
        }

    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
}

package hiracial;

import FileSystemUtilities.CDFileSystem.*;
import NodeInterface.CollectionInterface;
import NodeInterface.DatabaseInterface;

import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Database extends UnicastRemoteObject implements DatabaseInterface {
    private static final long serialVersionUID = 1L;
    private final String path;
    private String userName = null;
    private String password = null;

    Database( String path) throws RemoteException {
        super();
        this.path = path;
    }
    public CollectionInterface useCollation(String collectionName) throws RemoteException {
        Collection collection =  new Collection(path+"/"+collectionName);
        collection.setUserName(userName);
        collection.setPassword(password);
        return collection;
    }
    public void createCollection(String name) throws IOException {
        // create schema
        DirectoryCreation directory = new DirectoryCreation(path+"/"+name);
        directory.createDirectory();
        DirectoryCreation index = new DirectoryCreation(path+"/"+name+"/index");
        index.createDirectory();
//        File file = new File(path+"/"+name+"/index/id.json");
//        if(file.createNewFile()){
//            System.out.println("id file created !");
//        }
//        else System.out.println("failed");
        new Indexing.Indexing().createIndex(path+"/"+name,"id");
    }
    public void deleteCollection(String name) throws RemoteException{
        new RemoveDirectory(path+"/"+name).remove();
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void setPassword(String password){
        this.password = password;
    }
}

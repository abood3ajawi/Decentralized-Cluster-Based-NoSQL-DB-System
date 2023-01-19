package hiracial;

import FileSystemUtilities.CDFileSystem.DirectoryCreation;
import NodeInterface.DatabaseInterface;
import NodeInterface.UserInterface;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class User extends UnicastRemoteObject implements UserInterface {
    private static final long serialVersionUID = 1L;
    private final String path;
    private final String userName;
    private final String password;

    public User  (String name , String password) throws RemoteException {
        this.userName = name;
        path = "/volume/"+name;
        this.password = password;
        new DirectoryCreation("/volume/"+name).createDirectory();
        System.out.println(name);
        System.out.println("one");
        System.out.println(name);
        ///volume
    }
    public DatabaseInterface useDatabase(String databaseName) throws RemoteException {
        Database Database = new Database(path+"/"+databaseName);
        Database.setUserName(userName);
        Database.setPassword(password);
        return Database;

    }
    public void createDatabase(String name) throws RemoteException{
        DirectoryCreation directory = new DirectoryCreation(path+"/"+name);
        directory.createDirectory();
    }
    public void deleteDatabase(String name) throws RemoteException{
        DirectoryCreation directory = new DirectoryCreation(path+"/"+name);
        directory.createDirectory();
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}

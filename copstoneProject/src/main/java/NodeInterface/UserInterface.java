package NodeInterface;

import FileSystemUtilities.CDFileSystem.DirectoryCreation;
import hiracial.Database;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserInterface  extends Remote {
    public DatabaseInterface useDatabase(String databaseName) throws RemoteException;
    public void createDatabase(String name) throws RemoteException;
    public void deleteDatabase(String name) throws RemoteException;
}

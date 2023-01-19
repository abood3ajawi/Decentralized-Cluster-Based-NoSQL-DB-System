package NodeInterface;

import FileSystemUtilities.CDFileSystem.DirectoryCreation;
import FileSystemUtilities.CDFileSystem.RemoveDirectory;
import hiracial.Collection;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DatabaseInterface  extends Remote {
    public CollectionInterface useCollation(String collectionName) throws RemoteException;
    public void createCollection(String name) throws IOException;
    public void deleteCollection(String name) throws RemoteException;
}

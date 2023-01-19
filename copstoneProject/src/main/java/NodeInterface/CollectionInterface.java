package NodeInterface;


import ObjectUtilities.KeyValueObject;
import logicOperator.Operator;
import org.json.JSONObject;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface CollectionInterface  extends Remote {
    public String findAll() throws IOException;
    public String find(Operator expression) throws IOException  ;
    public void createDocument(KeyValueObject...data) throws IOException;
    public void Update(Operator expression , KeyValueObject data) throws IOException ;
    public void deleteDocument(Operator expression) throws IOException ;
}

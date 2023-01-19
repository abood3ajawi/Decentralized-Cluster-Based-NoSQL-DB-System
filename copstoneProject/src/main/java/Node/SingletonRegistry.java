package Node;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class SingletonRegistry {
    private static SingletonRegistry single_instance = null;
    private Registry registry = null;
    private SingletonRegistry() throws RemoteException {
        registry =LocateRegistry.createRegistry(1199);
    }
    public static SingletonRegistry getInstance() throws RemoteException {
        if (single_instance == null)
            single_instance =  new SingletonRegistry();

        return single_instance;
    }

    public Registry getRegistry() {
        return registry;
    }
}

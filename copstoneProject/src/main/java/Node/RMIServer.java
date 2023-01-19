package Node;

import NodeInterface.UserInterface;
import hiracial.User;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Objects;
public class RMIServer {
    Registry registry ;
    RMIServer(String token , String userName , String password) {
        try {
            registry = SingletonRegistry.getInstance().getRegistry();
            boolean add  = true;
            for (String tokenList:registry.list()) {
                if (Objects.equals(token, tokenList)) {
                    add = false;
                    break;
                }
            }
            if(add) {
                UserInterface user = new User(userName,password);
                registry.rebind(token, user);
            }
            System.out.println("hi");
            System.out.println(Arrays.toString(registry.list()));
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}

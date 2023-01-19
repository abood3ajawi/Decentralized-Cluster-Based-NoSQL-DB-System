package ObjectUtilities;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class KeyValueObject  implements Serializable {
    private final String key ;
    private final String value;
    private static final long serialVersionUID = 20120731125400L;
    public KeyValueObject(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}

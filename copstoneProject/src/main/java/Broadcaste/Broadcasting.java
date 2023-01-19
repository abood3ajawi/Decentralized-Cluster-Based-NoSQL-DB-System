package Broadcaste;

import NodeInterface.UserInterface;
import ObjectUtilities.KeyValueObject;
import ObjectUtilities.pathAnalysis;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;

public class Broadcasting {
    public void broadcastWriteData(String userName, String password, pathAnalysis path, KeyValueObject...data) throws UnknownHostException {
        for (int i = 2; i < 6; i++) {
            System.out.println(InetAddress.getLocalHost().getHostAddress());
            if ((!(("10.2.0."+(i)).equals(InetAddress.getLocalHost().getHostAddress())))) {
                try {
                    Login client = new Login("10.2.0."+(i), 7000, userName, password);
                    System.out.println(client.getToken());
                    String url = "rmi://10.2.0." + (i)+":1199/" + client.getToken();
                    UserInterface remote = (UserInterface) Naming.lookup(url);
                    remote.createDatabase("grading");
                    remote.useDatabase("grading").createCollection("info");
                    remote.useDatabase(path.getDatabaseName()).useCollation(path.getCollection()).createDocument(data);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

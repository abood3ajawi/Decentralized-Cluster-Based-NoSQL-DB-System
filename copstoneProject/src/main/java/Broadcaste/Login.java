package Broadcaste;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Login {

    public String token;

    public Login(String address, int port, String user, String password) {
        Socket socket = null;
        DataOutputStream out = null;
        DataInputStream in = null;
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException u) {
            System.out.println(u);
        }
        String line = "";
        try {
            //line = "abood 123456";
            //assert out != null;
            System.out.println(1);
            out.writeUTF(user + " " + password);
            System.out.println(1);

            //assert in != null;
            token = in.readUTF();
        } catch (IOException i) {
            System.out.println(i);
        }
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public String getToken() {
        return token;
    }
}



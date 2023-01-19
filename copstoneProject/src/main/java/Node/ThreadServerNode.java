package Node;

import Authentication.*;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ThreadServerNode extends Thread {
    private final Socket socket;
    private String userName;
    private String password;
    public  ThreadServerNode(Socket socket){
        this.socket = socket;
    }
    public void run(){
        System.out.println("Client accepted");
        DataOutputStream out = null;
        DataInputStream in = null;
        try {
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String userNameSpacePassword = "";
        try
        {
            userNameSpacePassword = in.readUTF();
            int Split = userNameSpacePassword.indexOf(" ");
            userName = userNameSpacePassword.substring(0 , Split);
            password = userNameSpacePassword.substring(Split+1);
            if (successfulLogin()){
                System.out.println(userNameSpacePassword);
                String token  = new Token(userName , password).getToken();
                new RMIServer(token , userName, password);
                out.writeUTF(token);
            }
            else
                out.writeUTF("username or Password incorrect");

        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        System.out.println("Closing connection");
        try {
            socket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean successfulLogin() throws IOException {
        return  new Login().login(userName , password);
    }

}

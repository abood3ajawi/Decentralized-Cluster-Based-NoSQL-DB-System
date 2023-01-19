package Node;

import Authentication.Login;

import java.net.*;
import java.io.*;

public class LoginServer {

        public LoginServer(int port)
        {
            ServerSocket server = null;
            try
            {
                server = new ServerSocket(port);
                System.out.println("Server started");
                System.out.println("Waiting for a client ...");
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
            while (true) {
                Socket socket = null;
                try {
                    socket = server.accept();
                } catch (IOException e) {
                    System.out.println("I/O error: " + e);
                }
                // new thread for a client
                new ThreadServerNode(socket).start();
            }
        }

}

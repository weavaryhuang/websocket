import java.net.*;
import java.io.*;

import static java.lang.System.exit;
import static java.lang.System.in;

public class Server
{
    int port;
    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            ServerSocket server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            //initialize socket and input stream
            Socket socket = server.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            BufferedReader input = new BufferedReader(new InputStreamReader(in));
            DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String line = "";

            // reads message from client until "Over" is sent
            while (!line.equals("Over"))
            {
                try
                {
                    line = in.readUTF();
                    System.out.println(line);
                }
                catch(IOException i)
                {
                    System.out.println(i.toString());
                    break;
                }
            }
            System.out.println("Closing connection");

            // close connection
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args)
    {
        Server server = new Server(5000);
    }
}
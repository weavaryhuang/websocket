import java.io.*;
import java.net.*;

import static java.lang.System.in;

public class Client  {

    // constructor to put ip address and port
    String address;
    int port;
    public Client(String address, int port) {
        // establish a connection
        // initialize socket and input output streams
        Socket socket = null;
        BufferedReader input = null;
        DataOutputStream out = null;
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            // takes input from terminal
            input = new BufferedReader(new InputStreamReader(in));
            DataInputStream in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            // sends output to the socket
            out = new DataOutputStream(
                    socket.getOutputStream());
        }
        catch (IOException i) {
            System.out.println(i.toString());
            return;
        }

        // string to read message from input
        String line = "";

        // keep reading until "Over" is input
        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            }
            catch (IOException i) {
                System.out.println(i.toString());
            }
        }

        // close the connection
        try {
            input.close();
            out.close();
            socket.close();
        }
        catch (IOException i) {
            System.out.println(i.toString());
        }
    }

    public static void main(String[] args)
    {
        Client client = new Client("127.0.0.1", 5000);
    }
}
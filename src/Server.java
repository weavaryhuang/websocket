import java.io.*;
import java.net.*;
import java.util.Date;

/**
 * This program demonstrates a simple TCP/IP socket server.
 *
 * @author www.codejava.net
 */
public class Server {

    public static void main(String[] args) {
//        if (args.length < 1) return;

//        int port = Integer.parseInt(args[0]); // [c] [f] [v1] #v1 = args[0]
        int port = 6500;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);


                String text;

                do {
                    text = reader.readLine();
                    String[] message = text.split("/", 2);
                    System.out.println("Client form " + message[1]);

                    if (message[0].equals("a")) {
                        writer.println("Server: .html");
                    } else {
                        writer.println("Server: " + message[0]);
                    }

                } while (!text.equals("bye"));

                socket.close();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

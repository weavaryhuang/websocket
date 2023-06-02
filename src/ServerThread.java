import java.io.*;
import java.net.*;

/**
 * This thread is responsible to handle client connection.
 *
 * @author www.codejava.net
 */
public class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);


            String text;

            do {
                text = reader.readLine();
                String[] message = text.split("/", 2);
                System.out.println("Client form " + message[1]);
                System.out.println(text);

                if (message[0].equals("index")) {
                    writer.println(message[0] + ".html");
                } else {
//                    writer.println("Server: " + message[0]);
                    writer.println("Server: accepted");
                }

            } while (!text.equals("exit"));

            socket.close();
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}

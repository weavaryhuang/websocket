import java.io.*;
import java.net.Socket;

import static java.lang.System.in;

public class Five extends Thread{

    public void run(){
        String line = "";
        try {
            Socket socket = null;
            BufferedReader input = new BufferedReader(new InputStreamReader(in));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            sleep(100);

            line = input.readLine();
            out.writeUTF(line);

        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
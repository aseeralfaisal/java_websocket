import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(3333);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (s.isConnected()) {
                str = din.readUTF();
                System.out.println("Client: " + str);
                str2 = br.readLine();
                System.out.println("Server: " + str2);
                dout.writeUTF(str2);
                dout.flush();
            }
            din.close();
            s.close();
            ss.close();
        } catch (Exception error) {
            System.out.println(error);
        }
    }
}

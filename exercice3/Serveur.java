import java.io.*;
import java.net.*;

public class Serveur {
  public static void main(String[] args) {

    int counter = 1;
    try {
      ServerSocket serverSocket = new ServerSocket(5555);

      System.out.println("Server listening at " + serverSocket.getLocalPort());
      while (true) {
        Socket socket = serverSocket.accept();

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        int age = in.readInt();
        String nom = in.readUTF();

        System.out.println("Received: " + age + " , " + nom);

        int identifiantClient = counter;
        counter++;

        out.writeInt(identifiantClient);

        socket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

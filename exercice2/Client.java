import java.io.*;
import java.net.*;

public class Client {
  public static void main(String[] args) {
    try {
      Voiture maVoiture = new Voiture("Berline", "Toyota");
      Socket socket = new Socket("localhost", 5555);
      ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

      System.out.println("Sending object voiture");

      out.writeObject(maVoiture);

      out.close();
      socket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

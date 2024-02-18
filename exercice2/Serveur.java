
import java.io.*;
import java.net.*;

public class Serveur {
  public static void main(String[] args) {
    try {
      ServerSocket serverSocket = new ServerSocket(5555);
      System.out.println("Server is listening at " + serverSocket.getLocalPort());
      Socket socket = serverSocket.accept();
      ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
      Voiture voitureRecue = (Voiture) in.readObject();
      voitureRecue.setCarburant(50);
      System.out.println(
          "Quantité de carburant de la voiture reçue: " + voitureRecue.getCarburant());
      in.close();
      socket.close();
      serverSocket.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


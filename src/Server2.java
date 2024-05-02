import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    public static void Server () throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        while (true) {
            Socket client = serverSocket.accept();
            OutputStream sendToClient = client.getOutputStream();
            InputStream fromClient = client.getInputStream();
            Scanner scanner = new Scanner(fromClient);
            sendToClient.write("Server: chào b".getBytes());
            System.out.println(fromClient);
            while (scanner.hasNextLine()) {
                String clientMessage = scanner.nextLine();
                System.out.println("Như Anh : " + clientMessage);
            }
            sendToClient.flush();
        }
    }
    public static void Client () throws IOException {
        Socket server  = new Socket("localhost", 3000);
        while (true) {
            OutputStream sendToServer = server.getOutputStream();
            InputStream fromServer = server.getInputStream();
            Scanner scanner = new Scanner(fromServer);
            sendToServer.write("Client: chào b".getBytes());
            System.out.println(scanner.nextLine());
            while (scanner.hasNextLine()) {
                String clientMessage = scanner.nextLine();
                System.out.println("Như Anh : " + clientMessage);
            }
            sendToServer.flush();
        }
    }

}

class AA {
    public static void main(String[] args) throws IOException {
        Server2.Server();
    }
}
class BB {
    public static void main(String[] args) throws IOException {
        Server2.Client();
    }
}

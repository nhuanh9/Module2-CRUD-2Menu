import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
    public static void Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(3001);
        Socket client = serverSocket.accept();
        InputStream fromClient = client.getInputStream();
        OutputStream toClient = client.getOutputStream();

        // C: client
        // Nhan tin nhan ben C: fromClient
        // In ra tin nhan da nhan tu C: sout
        new Thread(() -> {
            Scanner messFromClient = new Scanner(fromClient);
            while (messFromClient.hasNextLine()) {
                System.out.println("C02: " + messFromClient.nextLine());
            }
        }).start();

        // Nhap tin nhan ben S: scanner
        // Gui sang ben C: toClient
        Scanner inputS = new Scanner(System.in);
        while (true) {
            String inp = inputS.nextLine();
            toClient.write(inp.getBytes());
            toClient.flush();
        }


    }

    public static void Client() throws IOException {
        Socket server = new Socket("localhost", 3001);
        InputStream fromServer = server.getInputStream();
        OutputStream toServer = server.getOutputStream();
        // S: server
        // Nhan tin nhan ben S: fromServer
        // In ra tin nhan da nhan tu S: sout
        new Thread(() -> {
            Scanner messFromClient = new Scanner(fromServer);
            while (messFromClient.hasNextLine()) {
                System.out.println("NA: " + messFromClient.nextLine());
            }
        }).start();
        // Nhap tin nhan ben C: scanner
        // Gui sang ben S: toServer

        Scanner inputC = new Scanner(System.in);
        while (true) {
            String inp = inputC.nextLine();
            toServer.write(inp.getBytes());
            toServer.flush();
        }

    }

}

class A4 {
    public static void main(String[] args) throws IOException {
        Server2.Server();
    }
}

class B4 {
    public static void main(String[] args) throws IOException {
        Server2.Client();
    }
}

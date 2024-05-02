import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {
    public static void Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(3001);
        while (true) {
            Socket client = serverSocket.accept();
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter toClient = new PrintWriter(client.getOutputStream(), true);

            new Thread(() -> {
                try {
                    String line;
                    while ((line = fromClient.readLine()) != null) {
                        System.out.println("C02: " + line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            Scanner inputS = new Scanner(System.in);
            while (true) {
                String inp = inputS.nextLine();
                toClient.println(inp);
            }
        }
    }

    public static void Client() throws IOException {
        Socket server = new Socket("localhost", 3001);
        BufferedReader fromServer = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintWriter toServer = new PrintWriter(server.getOutputStream(), true);

        new Thread(() -> {
            try {
                String line;
                while ((line = fromServer.readLine()) != null) {
                    System.out.println("NA: " + line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        Scanner inputC = new Scanner(System.in);
        while (true) {
            String inp = inputC.nextLine();
            toServer.println(inp);
        }
    }
    
}

class A3 {
    public static void main(String[] args) throws IOException {
        Server2.Server();
    }
}

class B3 {
    public static void main(String[] args) throws IOException {
        Server2.Client();
    }
}

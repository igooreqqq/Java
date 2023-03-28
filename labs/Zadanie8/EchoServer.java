package pl.edu.uj.javaframe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer implements Runnable {

    Socket clientSocket;
    public EchoServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }
    private static final ExecutorService execute = Executors.newFixedThreadPool(2);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }

        Socket clientSocket = null;
        try {
            while(true) {
                clientSocket = serverSocket.accept();
                executeServerSocket(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
    }

    public static void executeServerSocket(Socket clientSocket) {
        execute.execute(new EchoServer(clientSocket));
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] liczby = inputLine.split(";", 2);
                int a;
                int b;

                System.out.println("Otrzymano przedział: " + inputLine);

                a = Integer.parseInt(liczby[0]);
                b = Integer.parseInt(liczby[1]);

                List<Integer> liczbyPierwsze = new ArrayList<>();

                for(int i = a; i <= b; i++) {
                    for(int j = a; j <= i; j++) {
                        if(i == j) {
                            liczbyPierwsze.add(i);
                        }
                        if(i % j == 0) {
                            break;
                        }
                    }
                }
                out.println(liczbyPierwsze);
            }
            out.close();
            in.close();
            clientSocket.close();
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6666");
            System.exit(-1);
        }
    }
}
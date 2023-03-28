package pl.edu.uj.javaframe;

import java.io.*;
import java.net.*;

public class EchoServer {
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
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println("Accept failed: 6666");
            System.exit(-1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));
        String inputLine;


        while ((inputLine = in.readLine()) != null) {
            String[] dodawanie = inputLine.split("\\s+");
            double wynik = 0;
            double a = 0;
            double b = 0;

            System.out.println("Otrzymano działanie: " + inputLine);

            a = Integer.parseInt(dodawanie[0]);
            b = Integer.parseInt(dodawanie[2]);

            if(dodawanie[1].equals("+")) {
                wynik = a + b;
            } else if(dodawanie[1].equals("-")) {
                wynik = a - b;
            } else if(dodawanie[1].equals("*")) {
                wynik = a * b;
            } else {
                if(b == 0){
                    out.println("Dzielenie przez 0!");
                    continue;
                }
                wynik = a / b;
            }
            System.out.println("Obliczono wynik otrzymanego działania: " + wynik);
            out.println(wynik);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();

    }
}
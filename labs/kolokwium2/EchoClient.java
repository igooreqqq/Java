package pl.edu.uj.eo;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoClient {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", 8001);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(
                new InputStreamReader(System.in));
        String userInput;

        List<String> lista= new ArrayList<>();
        List<String> metody = new ArrayList<>();
        metody.add("sin");
        metody.add("cos");
        metody.add("log");
        metody.add("log10");
        metody.add("sqrt");
        metody.add("ceil");
        metody.add("floor");

        Pattern pattern = Pattern.compile("x=\\d+");

        System.out.println("Escape character is '^]'.");
        System.out.println("Czekam na dane...");
        while ((userInput = stdIn.readLine()) != null) {
            Matcher matcher = pattern.matcher(userInput);
            if(metody.contains(userInput)) {
                lista.add(userInput);
                out.println(userInput);
            }
            if(userInput.equals("^]")) {
                out.println(userInput);
                try {
                    echoSocket.close();
                    System.out.println("Serwer został zamknięty.");
                } catch(IOException e) {
                    System.err.println("Error");
                } finally {
                    out.close();
                    in.close();
                    stdIn.close();
                }
            }
            if(!metody.contains(userInput) && !matcher.matches()){
                out.println(userInput);
                System.out.println(in.readLine());
            }

            if(matcher.matches()){
                out.println(userInput);
                for(int i = 0; i < lista.size(); i++){
                    System.out.println("Wynik działania: " + in.readLine());
                }
            }
        }

        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}